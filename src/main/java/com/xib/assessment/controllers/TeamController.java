package com.xib.assessment.controllers;

import com.xib.assessment.mapstract.dto.AgentDto;
import com.xib.assessment.mapstract.dto.TeamDto;
import com.xib.assessment.services.TeamService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/teams")
@RestController
@CrossOrigin("*")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Search for team details using agent ID", response = Iterable.class)
    public TeamDto findTeamById(@PathVariable("id") Long id) {
        return teamService.retrieveATeamUsingTeamId(id);
    }

    @GetMapping
    @ApiOperation(value = "View all teams", response = Iterable.class)
    public List<TeamDto> findAllTeams(){
        return teamService.retrieveAllTeams();
    }

    @PostMapping
    @ApiOperation(value = "Create a new team using team details", response = Iterable.class)
    public TeamDto createTeam(@RequestBody TeamDto teamDto){
        return teamService.saveTeam(teamDto);
    }

    @PutMapping("/team/{id}/agent")
    @ApiOperation(value = "Assigns an agent to the specified team", response = Iterable.class)
    public TeamDto assignAgent(@RequestBody AgentDto agentDto,@PathVariable("id") Long id){
        return teamService.assignAgentATeam(agentDto,id);
    }

    @GetMapping("/list/unassigned")
    @ApiOperation(value = "Return a list of all empty teams (i.e teams with no agents or managers)", response = Iterable.class)
    public List<TeamDto> unassignedTeams(){
        return teamService.retrieveUnassignedTeams();
    }
}
