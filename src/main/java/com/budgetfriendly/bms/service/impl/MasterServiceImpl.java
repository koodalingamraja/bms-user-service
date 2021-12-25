package com.budgetfriendly.bms.service.impl;

import com.budgetfriendly.bms.dto.MasterCityDTO;
import com.budgetfriendly.bms.dto.MasterRelationshipDTO;
import com.budgetfriendly.bms.dto.MasterStateDTO;
import com.budgetfriendly.bms.entity.MasterCity;
import com.budgetfriendly.bms.entity.MasterRelationship;
import com.budgetfriendly.bms.entity.MasterState;
import com.budgetfriendly.bms.repository.MasterCityRepository;
import com.budgetfriendly.bms.repository.MasterRealtionshipRepository;
import com.budgetfriendly.bms.repository.MasterStateRepository;
import com.budgetfriendly.bms.response.BaseResponse;
import com.budgetfriendly.bms.service.MasterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class MasterServiceImpl implements MasterService {

    @Autowired
    private MasterStateRepository stateRepository;

    @Autowired
    private MasterCityRepository cityRepository;

    @Autowired
    private MasterRealtionshipRepository realtionshipRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BaseResponse createState(MasterStateDTO masterStateDTO) {
        BaseResponse response = new BaseResponse();
        try {
            masterStateDTO.setStatus(Boolean.TRUE);
            masterStateDTO.setCreatedAt(new Date());
            MasterState masterStateData = modelMapper.map(masterStateDTO, MasterState.class);
            MasterState dbMasterState = stateRepository.save(masterStateData);
            response.setStatus("success");
            response.setMessage("state saved successfully");
            response.setData(dbMasterState);
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public BaseResponse createCity(MasterCityDTO masterCityDTO) {
        BaseResponse response = new BaseResponse();
        try{
            MasterCity masterCity = new MasterCity();
            masterCity.setCityName(masterCityDTO.getCityName());
            masterCity.setCityCode(masterCityDTO.getCityCode());
            masterCity.setStatus(Boolean.TRUE);
            masterCity.setCreatedAt(new Date());
            Optional<MasterState> dbMasterState = stateRepository.findById(masterCityDTO.getMasterStateDTO().getId());
            if(dbMasterState.isPresent()){
                masterCity.setMasterState(dbMasterState.get());
            }
            MasterCity dbMasterCity = cityRepository.save(masterCity);
            response.setStatus("success");
            response.setMessage("city saved successfully");
            response.setData(dbMasterCity);
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public BaseResponse createRelationship(MasterRelationshipDTO relationshipDTO) {
        BaseResponse response = new BaseResponse();
        try{
            MasterRelationship masterRelationship = new MasterRelationship();
            masterRelationship.setRelationshipName(relationshipDTO.getRelationshipName());
            masterRelationship.setRelationshipCode(relationshipDTO.getRelationshipCode());
            masterRelationship.setStatus(Boolean.TRUE);
            masterRelationship.setCreatedAt(new Date());
            MasterRelationship dbMasterRelationship = realtionshipRepository.save(masterRelationship);
            response.setStatus("success");
            response.setMessage("relationship save successfully");
            response.setData(masterRelationship);
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }
}
