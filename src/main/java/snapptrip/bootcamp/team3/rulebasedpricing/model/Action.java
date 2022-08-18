package snapptrip.bootcamp.team3.rulebasedpricing.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

@Entity
@Table(name = "action_tb")
@Data
public class Action {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "fixed_displacement_amount")
    private BigDecimal fixedDisplacementAmount;
    @Min(0)
    @Max(100)
    @Column(name = "percentage_displacement_amount")
    private BigDecimal percentageDisplacementAmount;
    @Column(name = "maximum_displacement_amount")
    private BigDecimal maximumDisplacementAmount;
}
