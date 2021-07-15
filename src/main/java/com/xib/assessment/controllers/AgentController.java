package com.xib.assessment.controllers;

import com.xib.assessment.mapstract.dto.AgentDto;
import com.xib.assessment.services.AgentService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/agents")
@RestController
@CrossOrigin("*")
public class AgentController {

    private final AgentService agentService;
    private static final Logger log = LoggerFactory.getLogger(AgentController.class);

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Search for agent details using agent ID", response = Iterable.class)
    public AgentDto retrieveAgent(@PathVariable("id") Long id) {
        return agentService.retrieveAgentUsingAgentId(id);
    }

    @GetMapping
    @ApiOperation(value = "View all agents. Use the size parameter to set the pagination.", response = Iterable.class)
    public List<AgentDto> allAgents(@RequestParam(name = "size") Integer size){
        return agentService.retrieveAgentsUsingPagination(size);
    }

    @PostMapping
    @ApiOperation(value = "Creates a new agent", response = Iterable.class)
    public AgentDto createAgent(@RequestBody AgentDto agentDto){
        log.info("Request {}", agentDto.toString());
        return agentService.saveAgent(agentDto);
    }

}
