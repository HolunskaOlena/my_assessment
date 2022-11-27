package com.xib.assessment.controller;

import com.xib.assessment.model.ManagerDto;
import com.xib.assessment.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerController {

    private final ManagerService managerService;

    @Autowired
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @PostMapping("/manager")
    public ResponseEntity<ManagerDto> createManager(@RequestBody ManagerDto managerDto){
        managerService.create(managerDto);
        return new ResponseEntity<>(managerDto, HttpStatus.CREATED);
    }
}
