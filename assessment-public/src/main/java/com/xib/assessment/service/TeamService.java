package com.xib.assessment.service;

import com.xib.assessment.model.AgentDto;
import com.xib.assessment.model.TeamDto;

import java.util.List;

public interface TeamService {

    void create(TeamDto teamDto);
    TeamDto getById(Long teamId);
    List<TeamDto> getAll();
    void assignAgentToTeam(Long teamId, AgentDto agentDto);
    List<TeamDto> getAllEmptyTeams();
}
