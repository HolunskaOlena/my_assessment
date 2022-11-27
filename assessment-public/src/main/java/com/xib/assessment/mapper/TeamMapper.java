package com.xib.assessment.mapper;

import com.xib.assessment.entity.Team;
import com.xib.assessment.model.TeamDto;
import org.springframework.stereotype.Component;

@Component
public class TeamMapper {

    public Team toEntity(TeamDto teamDto){
        Team team = new Team();
        team.setId(teamDto.getId());
        team.setName(teamDto.getName());

        return team;
    }

    public TeamDto toDto(Team team){
        TeamDto teamDto = new TeamDto();
        teamDto.setId(team.getId());
        teamDto.setName(team.getName());

        return teamDto;
    }
}
