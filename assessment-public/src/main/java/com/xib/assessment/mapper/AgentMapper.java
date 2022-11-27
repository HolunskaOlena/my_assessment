package com.xib.assessment.mapper;

import com.xib.assessment.entity.Agent;
import com.xib.assessment.model.AgentDto;
import org.springframework.stereotype.Component;

@Component
public class AgentMapper {

    public Agent toEntity(AgentDto agentDto){
        Agent agent = new Agent();
        agent.setId(agentDto.getId());
        agent.setFirstName(agentDto.getFirstName());
        agent.setLastName(agentDto.getLastName());
        agent.setIdNumber(agentDto.getIdNumber());

        return agent;
    }

    public AgentDto toDto(Agent agent){
        AgentDto agentDto = new AgentDto();
        agentDto.setId(agent.getId());
        agentDto.setFirstName(agent.getFirstName());
        agentDto.setLastName(agent.getLastName());
        agentDto.setIdNumber(agent.getIdNumber());

        return agentDto;
    }
}
