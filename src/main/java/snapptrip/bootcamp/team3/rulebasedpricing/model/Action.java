package snapptrip.bootcamp.team3.rulebasedpricing.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "action_tb")
@Data
public class Action {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private BigDecimal fixedDisplacementAmount;
    private BigDecimal percentageDisplacementAmount;
    private BigDecimal maximumDisplacementAmount;
}
