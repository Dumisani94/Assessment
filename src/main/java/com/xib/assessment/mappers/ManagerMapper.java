package com.xib.assessment.mappers;

import com.xib.assessment.dtos.ManagerDto;
import com.xib.assessment.persistence.entities.Manager;

public class ManagerMapper {

    public static ManagerDto toDto(Manager manager){
        if(manager.getTeams() != null){
            return ManagerDto.builder().lastName(manager.getLastName())
                    .id(manager.getId())
                    .firstName(manager.getFirstName())
                    .idNumber(manager.getIdNumber())
                    .build();
        }
        return ManagerDto.builder().lastName(manager.getLastName())
                .id(manager.getId())
                .firstName(manager.getFirstName())
                .idNumber(manager.getIdNumber())
                .build();
    }

    public static Manager fromDto(ManagerDto manager){
        if(manager != null){
            return Manager.builder().lastName(manager.getLastName())
                    .id(manager.getId())
                    .firstName(manager.getFirstName())
                    .idNumber(manager.getIdNumber())
                    .build();
        }
        return Manager.builder().lastName(manager.getLastName())
                .id(manager.getId())
                .firstName(manager.getFirstName())
                .build();
    }
}
