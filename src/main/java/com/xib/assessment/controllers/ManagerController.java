package com.xib.assessment.controllers;

import com.xib.assessment.mapstract.dto.ManagerDto;
import com.xib.assessment.services.ManagerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/managers")
@RestController
@CrossOrigin("*")
public class ManagerController {


    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @PutMapping
    @ApiOperation(value = "Create Manager", response = Iterable.class)
    public ManagerDto assignAgent(@RequestBody ManagerDto managerDto){
        return managerService.saveManager(managerDto);
    }

}
