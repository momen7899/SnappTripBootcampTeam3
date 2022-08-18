package snapptrip.bootcamp.team3.rulebasedpricing.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import snapptrip.bootcamp.team3.rulebasedpricing.dto.request.ApplyRequestDTO;
import snapptrip.bootcamp.team3.rulebasedpricing.dto.response.ApplyResponseDTO;
import snapptrip.bootcamp.team3.rulebasedpricing.dto.response.ApplyRuleResponseDTO;
import snapptrip.bootcamp.team3.rulebasedpricing.model.*;
import snapptrip.bootcamp.team3.rulebasedpricing.repository.RuleRepository;
import snapptrip.bootcamp.team3.rulebasedpricing.service.RuleBasedService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RuleBaseServiceImpl implements RuleBasedService {

    RuleRepository repository;

    @Override
    public ApplyResponseDTO apply(ApplyRequestDTO applyRequestDTO) {
        List<Rule> rules = (List<Rule>) repository.findAll();
        List<ApplyRuleResponseDTO> appliedRules = new ArrayList<>();

        int seq = 0;

        for (Rule rule : rules) {
            if (check(rule, applyRequestDTO.getUserType())) {
                BigDecimal oldPrice = seq == 0 ? applyRequestDTO.getPrice() : appliedRules.get(appliedRules.size() - 1).getNewPrice();
                ApplyRuleResponseDTO applyRule = createApplyRule(rule, seq++, oldPrice);
                appliedRules.add(applyRule);
            }
        }

        ApplyResponseDTO applyResponseDTO = new ApplyResponseDTO();
        applyResponseDTO.setApplied(!appliedRules.isEmpty());
        applyResponseDTO.setAppliedRules(appliedRules);

        return applyResponseDTO;
    }

    private ApplyRuleResponseDTO createApplyRule(Rule rule, Integer seq, BigDecimal oldPrice) {
        ApplyRuleResponseDTO applyRule = new ApplyRuleResponseDTO();
        applyRule.setId(rule.getId());
        applyRule.setName(rule.getName());
        applyRule.setSequence(seq);
        applyRule.setOldPrice(oldPrice);
        applyRule.setNewPrice(calculatePrice(rule, oldPrice));
        applyRule.setDisplacement((applyRule.getNewPrice().subtract(applyRule.getOldPrice())).abs());
        return applyRule;
    }

    private BigDecimal calculatePrice(Rule rule, BigDecimal oldPrice) {
        Action action = rule.getAction();
        BigDecimal f =
                action.getFixedDisplacementAmount().add((oldPrice).
                        multiply(action.getPercentageDisplacementAmount().divide(BigDecimal.valueOf(100))));

        if (rule.getRuleType() == RuleType.DISCOUNT) {
            return oldPrice.subtract(min(f, action.getMaximumDisplacementAmount()));
        }
        return oldPrice.add(min(f, action.getMaximumDisplacementAmount()));
    }

    private BigDecimal min(BigDecimal a, BigDecimal b) {
        if (a.compareTo(b) > 0)
            return b;
        return a;
    }

    private boolean check(Rule rule, UserType userType) {

        for (Condition condition : rule.getConditions()) {
            if (!condition.getUserType().equals(userType)) {
                return false;
            }
        }

        return true;
    }
}