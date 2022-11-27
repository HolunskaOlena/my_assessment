package com.xib.assessment.controller;

import com.xib.assessment.model.AgentDto;
import com.xib.assessment.model.TeamDto;
import com.xib.assessment.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/team/{id}")
    public ResponseEntity<TeamDto> getTeamById(@PathVariable("id") Long id){
        TeamDto teamDto = teamService.getById(id);
        return ResponseEntity.ok(teamDto);
    }

    @GetMapping("/teams")
    public ResponseEntity<List<TeamDto>> getAllTeams(){
        List<TeamDto> teamDtoList = teamService.getAll();
        return ResponseEntity.ok(teamDtoList);
    }

    @PostMapping("/team")
    public ResponseEntity<TeamDto> createTeam(@RequestBody TeamDto teamDto){
        teamService.create(teamDto);
        return new ResponseEntity<>(teamDto, HttpStatus.CREATED);
    }

    @PutMapping("/team/{id}/agent")
    public void assignAgentToTeam(@PathVariable("id") Long id, @RequestBody AgentDto agentDto){
        teamService.assignAgentToTeam(id, agentDto);
    }

    @GetMapping("/teams/empty")
    public ResponseEntity<List<TeamDto>> getAllEmptyTeams(){
        List<TeamDto> teamDtoList = teamService.getAllEmptyTeams();
        return ResponseEntity.ok(teamDtoList);
    }
}
