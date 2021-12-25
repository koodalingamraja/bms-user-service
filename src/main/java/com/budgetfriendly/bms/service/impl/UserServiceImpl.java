package com.budgetfriendly.bms.service.impl;

import com.budgetfriendly.bms.dto.MasterCityDTO;
import com.budgetfriendly.bms.dto.MasterStateDTO;
import com.budgetfriendly.bms.dto.UserDTO;
import com.budgetfriendly.bms.entity.MasterCity;
import com.budgetfriendly.bms.entity.MasterState;
import com.budgetfriendly.bms.entity.Users;
import com.budgetfriendly.bms.repository.MasterCityRepository;
import com.budgetfriendly.bms.repository.MasterRealtionshipRepository;
import com.budgetfriendly.bms.repository.MasterStateRepository;
import com.budgetfriendly.bms.repository.UsersRepository;
import com.budgetfriendly.bms.response.BaseResponse;
import com.budgetfriendly.bms.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private MasterStateRepository stateRepository;

    @Autowired
    private MasterCityRepository cityRepository;

    @Autowired
    private MasterRealtionshipRepository relationshipRepository;

    @Override
    public BaseResponse createUser(UserDTO userDTO) {
        BaseResponse response = new BaseResponse();
        try{

            Users users = new Users();
            users.setUserName(userDTO.getUserName());
            users.setPassword(userDTO.getPassword());
            users.setEmail(userDTO.getEmail());
            users.setMobile(userDTO.getMobile());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String date = format.format(userDTO.getDob());
            Date dob = format.parse(date);
            users.setDob(dob);
            users.setGender(userDTO.getGender());
            users.setStatus(Boolean.TRUE);
            users.setCreatedAt(new Date());

            Optional<MasterState> dbMasterState = stateRepository.findByIdAndStatusTrue(userDTO.getMasterCityDTO().getMasterStateDTO().getId());

            if(dbMasterState.isPresent()){
                users.setMasterState(dbMasterState.get());
            }

            Optional<MasterCity> dbMastercity = cityRepository.findByIdAndStatusTrue(userDTO.getMasterCityDTO().getId());

            if(dbMastercity.isPresent()){
                users.setMasterCity(dbMastercity.get());
            }

            Users dbUser = usersRepository.save(users);
            response.setStatus("success");
            response.setMessage("Hi" +" "+ userDTO.getUserName()  +" "+"your successfully registered");
            response.setData(dbUser);
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public BaseResponse getUserByUserName(String userName) {
        BaseResponse response = new BaseResponse();
        try{
            Users user = usersRepository.getUserByUserName(userName);
            if(user != null){
                UserDTO userDTO = new UserDTO();
                MasterCityDTO cityDTO = modelMapper.map(user.getMasterCity() , MasterCityDTO.class);
                MasterStateDTO stateDTO = modelMapper.map(user.getMasterState() , MasterStateDTO.class);
                userDTO.setMasterCityDTO(cityDTO);
                userDTO.getMasterCityDTO().setMasterStateDTO(stateDTO);
                userDTO = modelMapper.map(user , UserDTO.class);
                response.setStatus("success");
                response.setMessage("details get successfully");
                response.setData(userDTO);
            }else{
                response.setStatus("failed");
                response.setMessage("invalid username, please provide valid username");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }
}
