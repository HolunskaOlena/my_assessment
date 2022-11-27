package com.xib.assessment.service.impl;

import com.xib.assessment.entity.Agent;
import com.xib.assessment.entity.Team;
import com.xib.assessment.mapper.AgentMapper;
import com.xib.assessment.mapper.TeamMapper;
import com.xib.assessment.model.AgentDto;
import com.xib.assessment.model.TeamDto;
import com.xib.assessment.repository.AgentRepository;
import com.xib.assessment.repository.TeamRepository;
import com.xib.assessment.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamMapper teamMapper;
    private final TeamRepository teamRepository;
    private final AgentMapper agentMapper;
    private final AgentRepository agentRepository;

    @Autowired
    public TeamServiceImpl(TeamMapper teamMapper, TeamRepository teamRepository, AgentMapper agentMapper, AgentRepository agentRepository) {
        this.teamMapper = teamMapper;
        this.teamRepository = teamRepository;
        this.agentMapper = agentMapper;
        this.agentRepository = agentRepository;
    }

    @Override
    public void create(TeamDto teamDto) {
        Team team = teamMapper.toEntity(teamDto);
        teamRepository.save(team);
    }

    @Override
    public TeamDto getById(Long teamId) {
        return teamMapper.toDto(teamRepository.findById(teamId).get());
    }

    @Override
    public List<TeamDto> getAll() {
        List<Team> teamList = teamRepository.findAll();
        return teamList
                .stream()
                .map(teamMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void assignAgentToTeam(Long teamId, AgentDto agentDto) {
        Team foundTeam = teamRepository.findById(teamId).get();

        Agent agent = agentMapper.toEntity(agentDto);
        agentRepository.save(agent);

        foundTeam.getAgentList().add(agent);
        agent.setTeam(foundTeam);
    }

    @Override
    public List<TeamDto> getAllEmptyTeams() {
        List<Team> foundTeamList = teamRepository.getAllEmptyTeams();
        return foundTeamList
                .stream()
                .map(teamMapper::toDto)
                .collect(Collectors.toList());
    }
}
