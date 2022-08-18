package snapptrip.bootcamp.team3.rulebasedpricing.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import snapptrip.bootcamp.team3.rulebasedpricing.model.Rule;

public interface RuleRepository extends PagingAndSortingRepository<Rule, Long> {
}
