package com.xib.assessment.service.impl;

import com.xib.assessment.entity.Agent;
import com.xib.assessment.mapper.AgentMapper;
import com.xib.assessment.model.AgentDto;
import com.xib.assessment.repository.AgentRepository;
import com.xib.assessment.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgentServiceImpl implements AgentService {

    private final AgentMapper agentMapper;
    private final AgentRepository agentRepository;

    @Autowired
    public AgentServiceImpl(AgentMapper agentMapper, AgentRepository agentRepository) {
        this.agentMapper = agentMapper;
        this.agentRepository = agentRepository;
    }

    @Transactional
    @Override
    public void create(AgentDto agentDto) {
        Agent agent = agentMapper.toEntity(agentDto);
        agentRepository.save(agent);
    }

    @Transactional(readOnly = true)
    @Override
    public AgentDto getById(Long agentId) {
        return agentMapper.toDto(agentRepository.findById(agentId).get());
    }

    @Transactional(readOnly = true)
    @Override
    public List<AgentDto> getAll() {
        List<Agent> agentList = agentRepository.findAll();
        return agentList
                .stream()
                .map(agentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public Page<AgentDto> getAllPageable(Pageable pageable) {
        return agentRepository.findAll(pageable).map(agentMapper::toDto);
    }
}
