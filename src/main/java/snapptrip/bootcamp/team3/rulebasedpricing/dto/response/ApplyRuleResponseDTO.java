package snapptrip.bootcamp.team3.rulebasedpricing.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ApplyRuleResponseDTO {
    long id;
    String name;
    Integer sequence;
    BigDecimal oldPrice;
    BigDecimal newPrice;
    BigDecimal displacement;
}
