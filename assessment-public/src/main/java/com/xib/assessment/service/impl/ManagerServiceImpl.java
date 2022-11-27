package com.xib.assessment.service.impl;

import com.xib.assessment.entity.Manager;
import com.xib.assessment.mapper.ManagerMapper;
import com.xib.assessment.model.ManagerDto;
import com.xib.assessment.repository.ManagerRepository;
import com.xib.assessment.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;
    private final ManagerMapper managerMapper;

    @Autowired
    public ManagerServiceImpl(ManagerRepository managerRepository, ManagerMapper managerMapper) {
        this.managerRepository = managerRepository;
        this.managerMapper = managerMapper;
    }

    @Transactional
    @Override
    public void create(ManagerDto managerDto) {
        Manager manager = managerMapper.toEntity(managerDto);
        managerRepository.save(manager);
    }
}
