package snapptrip.bootcamp.team3.rulebasedpricing.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sample_tb")
@Data
public class SampleEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;


}
