package com.xib.assessment.services;

import com.xib.assessment.dtos.AgentDto;
import com.xib.assessment.exceptions.NoDataFoundException;
import com.xib.assessment.mappers.AgentMapper;
import com.xib.assessment.persistence.entities.Agent;
import com.xib.assessment.persistence.repositories.AgentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AgentService {

    private final AgentRepository agentRepository;

    public AgentService(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    public AgentDto retrieveAgentUsingAgentId(Long id){
        Optional<Agent> agent = agentRepository.findById(id);
        if(agent.isPresent()){
            return AgentMapper.toDto(agent.get());
        }else {
            throw new NoDataFoundException("Invalid user id provided");
        }
    }

    public List<AgentDto> retrieveAgentsUsingPagination(Integer size) {
        List<AgentDto> agentDtos = new ArrayList<>();
        List<Agent> agents = agentRepository.retrieveAgentsUsingPagination(size);
        if(!agents.isEmpty()){
            agents.forEach(agent -> {
                agentDtos.add(AgentMapper.toDto(agent));
            });
        }
        return agentDtos;
    }

    public List<AgentDto> retrieveAllAgents() {
        List<AgentDto> agentDtos = new ArrayList<>();
        List<Agent> agents = agentRepository.findAll();
        if(!agents.isEmpty()){
            agents.forEach(agent -> {
                agentDtos.add(AgentMapper.toDto(agent));
            });
        }
        return agentDtos;
    }

    public AgentDto saveAgent(AgentDto agentDto) {
        return AgentMapper.toDto(agentRepository.save(AgentMapper.fromDto(agentDto)));
    }
}
