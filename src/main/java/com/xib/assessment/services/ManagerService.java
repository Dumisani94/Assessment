package com.xib.assessment.services;

import com.xib.assessment.dtos.ManagerDto;
import com.xib.assessment.mappers.ManagerMapper;
import com.xib.assessment.persistence.repositories.ManagerRepository;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    private final ManagerRepository managerRepository;

    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public ManagerDto saveManager(ManagerDto managerDto){
        return ManagerMapper.toDto(managerRepository.save(ManagerMapper.fromDto(managerDto)));
    }
}
