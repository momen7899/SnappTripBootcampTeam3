package snapptrip.bootcamp.team3.rulebasedpricing.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import snapptrip.bootcamp.team3.rulebasedpricing.dto.request.ApplicantItemRequestDTO;
import snapptrip.bootcamp.team3.rulebasedpricing.mapper.RuleBasedMapper;
import snapptrip.bootcamp.team3.rulebasedpricing.service.RuleBasedService;

@RestController
@RequestMapping(value = "api/v1/authentication")
@AllArgsConstructor
public class RuleBasedController {

    private RuleBasedService service;
    private RuleBasedMapper mapper;

    @PutMapping("/applied")
    private ResponseEntity<ApplicantItemRequestDTO> apply(@RequestBody ApplicantItemRequestDTO applicantItemRequestDTO) {
        return ResponseEntity.ok().build();
    }
}
