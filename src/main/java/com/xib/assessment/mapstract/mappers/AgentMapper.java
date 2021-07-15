package com.xib.assessment.mapstract.mappers;

import com.xib.assessment.mapstract.dto.AgentDto;
import com.xib.assessment.persistence.entities.Agent;

public class AgentMapper {

    public static AgentDto toDto(Agent agent){
        if (agent.getTeam() != null){
            return AgentDto.builder().lastName(agent.getLastName())
                    .id(agent.getId())
                    .firstName(agent.getFirstName())
                    .idNumber(agent.getIdNumber())
                    .teamDto(TeamMapper.toDto(agent.getTeam()))
                    .build();
        }
        return AgentDto.builder().lastName(agent.getLastName())
                .id(agent.getId())
                .firstName(agent.getFirstName())
                .idNumber(agent.getIdNumber())
                .build();
    }

    public static Agent fromDto(AgentDto agentDto){
        if(agentDto.getTeamDto() != null){
            return Agent.builder().lastName(agentDto.getLastName())
                    .id(agentDto.getId())
                    .firstName(agentDto.getFirstName())
                    .idNumber(agentDto.getIdNumber())
                    .team(TeamMapper.fromDto(agentDto.getTeamDto()))
                    .build();
        }
        return Agent.builder().lastName(agentDto.getLastName())
                .id(agentDto.getId())
                .firstName(agentDto.getFirstName())
                .idNumber(agentDto.getIdNumber())
                .build();
    }
}
