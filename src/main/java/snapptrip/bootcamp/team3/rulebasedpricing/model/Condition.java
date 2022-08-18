package snapptrip.bootcamp.team3.rulebasedpricing.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "conditon_tb")
@Data
public class Condition {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private UserType userType;

    @ManyToOne
    @JoinColumn(name = "rule_id", referencedColumnName = "id")
    private Rule rule;
}
