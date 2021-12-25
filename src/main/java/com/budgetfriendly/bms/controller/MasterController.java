package com.budgetfriendly.bms.controller;

import com.budgetfriendly.bms.dto.MasterCityDTO;
import com.budgetfriendly.bms.dto.MasterRelationshipDTO;
import com.budgetfriendly.bms.dto.MasterStateDTO;
import com.budgetfriendly.bms.response.BaseResponse;
import com.budgetfriendly.bms.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("master")
public class MasterController {

    @Autowired
    private MasterService masterService;

    @PostMapping("createState")
    public BaseResponse createState(@RequestBody MasterStateDTO masterStateDTO){
        return masterService.createState(masterStateDTO);
    }

    @PostMapping("createCity")
    public BaseResponse createCity(@RequestBody MasterCityDTO masterCityDTO){
        return masterService.createCity(masterCityDTO);
    }

    @PostMapping("createRelationship")
    public BaseResponse createRelationship(@RequestBody MasterRelationshipDTO masterRelationshipDTO){
        return masterService.createRelationship(masterRelationshipDTO);
    }

}
