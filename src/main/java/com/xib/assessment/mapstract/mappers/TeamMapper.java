package com.xib.assessment.mapstract.mappers;

import com.xib.assessment.mapstract.dto.TeamDto;
import com.xib.assessment.persistence.entities.Team;

public class TeamMapper {

    public static TeamDto toDto(Team team){
        return TeamDto.builder().id(team.getId())
                .name(team.getName()).build();
    }

    public static Team fromDto(TeamDto teamDto){
        return Team.builder().id(teamDto.getId())
                .name(teamDto.getName()).build();
    }
}
