package snapptrip.bootcamp.team3.rulebasedpricing.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rule_tb")
@Data
public class Rule {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;

    private RuleType ruleType;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "rule", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Condition> conditions;


    @OneToOne
    private Action action;

}