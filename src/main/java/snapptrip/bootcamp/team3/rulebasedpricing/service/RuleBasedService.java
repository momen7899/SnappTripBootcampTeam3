package snapptrip.bootcamp.team3.rulebasedpricing.service;

import snapptrip.bootcamp.team3.rulebasedpricing.dto.request.ApplyRequestDTO;
import snapptrip.bootcamp.team3.rulebasedpricing.dto.response.ApplyResponseDTO;

public interface RuleBasedService {
    ApplyResponseDTO apply(ApplyRequestDTO applyRequestDTO);
}
