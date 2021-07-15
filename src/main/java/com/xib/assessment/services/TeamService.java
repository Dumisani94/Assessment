package com.xib.assessment.services;

import com.xib.assessment.dtos.AgentDto;
import com.xib.assessment.dtos.TeamDto;
import com.xib.assessment.exceptions.NoDataFoundException;
import com.xib.assessment.mappers.TeamMapper;
import com.xib.assessment.persistence.entities.Team;
import com.xib.assessment.persistence.repositories.TeamRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final AgentService agentService;

    public TeamService(TeamRepository teamRepository, AgentService agentService) {
        this.teamRepository = teamRepository;
        this.agentService = agentService;
    }

    public TeamDto retrieveATeamUsingTeamId(Long id) {
        Optional<Team> team = teamRepository.findById(id);
        if (team.isPresent()) {
            return TeamMapper.toDto(team.get());
        } else {
            throw new NoDataFoundException("Invalid user id provided");
        }
    }

    public List<TeamDto> retrieveAllTeams() {
        List<Team> all = teamRepository.findAll();
        List<TeamDto> teamDtoList = new ArrayList<>();

        if (!all.isEmpty()) {
            all.forEach(team -> {
                teamDtoList.add(TeamMapper.toDto(team));
            });
        }

        return teamDtoList;
    }

    public TeamDto saveTeam(TeamDto teamDto) {
        return TeamMapper.toDto(teamRepository.save(TeamMapper.fromDto(teamDto)));
    }

    public List<TeamDto> retrieveUnassignedTeams() {
        List<AgentDto> allAgents = agentService.retrieveAllAgents();
        List<TeamDto> unassignedTeams = new ArrayList<>();

        retrieveAllTeams().forEach(teamDto -> {
            if(allAgents.stream().noneMatch(agentDto -> agentDto.getTeamDto().getId().equals(teamDto.getId()))){
                unassignedTeams.add(teamDto);
            }
        });

        return unassignedTeams;
    }

    public TeamDto assignAgentATeam(AgentDto agentDto, Long id) {
        if (agentDto != null) {
            TeamDto teamDto = retrieveATeamUsingTeamId(id);
            if (teamDto != null) {
                agentDto.setTeamDto(teamDto);
                agentService.saveAgent(agentDto);
                return teamDto;
            }
        }
        throw new RuntimeException("Unable to assign a team");
    }
}
