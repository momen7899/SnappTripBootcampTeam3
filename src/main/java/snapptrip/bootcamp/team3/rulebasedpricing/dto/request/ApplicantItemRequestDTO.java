package snapptrip.bootcamp.team3.rulebasedpricing.dto.request;

import lombok.Data;
import snapptrip.bootcamp.team3.rulebasedpricing.model.UserType;

import java.math.BigDecimal;

@Data
public class ApplicantItemRequestDTO {
    UserType userType;
    BigDecimal price;
}
