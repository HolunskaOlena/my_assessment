package com.xib.assessment.service;

import com.xib.assessment.model.AgentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AgentService {

    void create(AgentDto agentDto);
    AgentDto getById(Long agentId);
    List<AgentDto> getAll();
    Page<AgentDto> getAllPageable(Pageable pageable);
}
