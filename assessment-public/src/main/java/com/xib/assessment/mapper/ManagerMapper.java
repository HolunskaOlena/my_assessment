package com.xib.assessment.mapper;

import com.xib.assessment.entity.Manager;
import com.xib.assessment.model.ManagerDto;
import org.springframework.stereotype.Component;

@Component
public class ManagerMapper {

    public Manager toEntity(ManagerDto managerDto){
        Manager manager = new Manager();
        manager.setId(managerDto.getId());
        manager.setFirstName(managerDto.getFirstName());
        manager.setLastName(managerDto.getLastName());
        manager.setAddress(managerDto.getAddress());

        return manager;
    }

    public ManagerDto toDto(Manager manager){
        ManagerDto managerDto = new ManagerDto();
        managerDto.setId(manager.getId());
        managerDto.setFirstName(manager.getFirstName());
        managerDto.setLastName(manager.getLastName());
        managerDto.setAddress(manager.getAddress());

        return managerDto;
    }
}
