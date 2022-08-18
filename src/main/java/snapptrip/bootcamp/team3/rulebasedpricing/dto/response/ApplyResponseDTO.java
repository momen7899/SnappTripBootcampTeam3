package snapptrip.bootcamp.team3.rulebasedpricing.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class ApplyResponseDTO {
    boolean applied;
    List<ApplyRuleResponseDTO> appliedRules;
}