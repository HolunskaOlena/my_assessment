package com.xib.assessment.controller;

import com.xib.assessment.model.AgentDto;
import com.xib.assessment.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AgentController {

    private final AgentService agentService;

    @Autowired
    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @GetMapping("/agent/{id}")
    public ResponseEntity<AgentDto> findAgent(@PathVariable("id") Long id) {
        AgentDto agentDto = agentService.getById(id);
        return ResponseEntity.ok(agentDto);
    }

    @PostMapping("/agent")
    public ResponseEntity<AgentDto> createAgent(@RequestBody AgentDto agentDto){
        agentService.create(agentDto);
        return new ResponseEntity<>(agentDto, HttpStatus.CREATED);
    }

    @GetMapping("/agents")
    public ResponseEntity<List<AgentDto>> getAllAgents(){
        List<AgentDto> agentDtoList = agentService.getAll();
        return ResponseEntity.ok(agentDtoList);
    }

    @GetMapping("/agents/page")
    public ResponseEntity<Page<AgentDto>> getAllPageableAgents(@PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC, size = Integer.MAX_VALUE) Pageable pageable){
        return ResponseEntity.ok(agentService.getAllPageable(pageable));
    }

}
