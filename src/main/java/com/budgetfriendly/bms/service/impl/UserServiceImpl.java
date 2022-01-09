package com.budgetfriendly.bms.service.impl;

import com.budgetfriendly.bms.common.CommonLogics;
import com.budgetfriendly.bms.constants.UserConstant;
import com.budgetfriendly.bms.dto.MasterCityDTO;
import com.budgetfriendly.bms.dto.MasterStateDTO;
import com.budgetfriendly.bms.dto.UserDTO;
import com.budgetfriendly.bms.entity.*;
import com.budgetfriendly.bms.repository.*;
import com.budgetfriendly.bms.response.BaseResponse;
import com.budgetfriendly.bms.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    private CommonLogics logics;

    @Autowired
    private MasterRoleRepository roleRepository;

    @Autowired
    private UserRoleMappingRepository roleMappingRepository;

    @Override
    public BaseResponse createUser(UserDTO userDTO) {
        BaseResponse response = new BaseResponse();
        try{
            Date dob = logics.getBirthDate(userDTO.getDob());
            Users users = new Users();
            users.setUserName(userDTO.getUserName());
            users.setPassword(userDTO.getPassword());
            users.setEmail(userDTO.getEmail());
            users.setMobile(userDTO.getMobile());
            users.setDob(dob);
            users.setAge(logics.getAge(userDTO.getDob()));
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

            Optional<MasterRole> dbMasterRole = roleRepository.findById(userDTO.getMasterRoleDTO().getId());

            if(dbMasterRole.isPresent()){
                UserRoleMapping roleMapping = new UserRoleMapping();
                roleMapping.setUsers(dbUser);
                roleMapping.setMasterRole(dbMasterRole.get());
                roleMapping.setStatus(Boolean.TRUE);
                roleMapping.setCreatedAt(new Date());
                roleMappingRepository.save(roleMapping);
            }

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

    @Override
    public BaseResponse updateUser(UserDTO userDTO) {
        BaseResponse response = new BaseResponse();
        try{
            Users user = null;
            if(userDTO.getId() != null && userDTO.getId() != 0){
                user  = usersRepository.getByUserId(userDTO.getId());
               if(user != null){
                   if(userDTO.getUserName() != null && !userDTO.getUserName().isEmpty()) {
                       user.setUserName(userDTO.getUserName());
                   }
                   if(userDTO.getEmail() != null && !userDTO.getEmail().isEmpty()) {
                       user.setEmail(userDTO.getEmail());
                   }
                   if(userDTO.getMobile() != null && !userDTO.getMobile().isEmpty()) {
                       user.setMobile(userDTO.getMobile());
                   }
                   if(userDTO.getDob() != null) {
                       Date dob = logics.getBirthDate(userDTO.getDob());
                       user.setDob(dob);
                       user.setAge(logics.getAge(userDTO.getDob()));
                   }
                   if(userDTO.getGender() != null && !userDTO.getGender().isEmpty()) {
                       user.setGender(userDTO.getGender());
                   }
                   if(userDTO.getMasterCityDTO().getMasterStateDTO().getId() != null && userDTO.getMasterCityDTO().getMasterStateDTO().getId() != 0){
                        Optional<MasterState> dbMasterState = stateRepository.findByIdAndStatusTrue(userDTO.getMasterCityDTO().getMasterStateDTO().getId());
                        if(dbMasterState.isPresent()) {
                            user.setMasterState(dbMasterState.get());
                        }
                    }
                   if(userDTO.getMasterCityDTO().getId() != null && userDTO.getMasterCityDTO().getId() != 0){
                        Optional<MasterCity> dbMastercity = cityRepository.findByIdAndStatusTrue(userDTO.getMasterCityDTO().getId());
                        if(dbMastercity.isPresent()){
                            user.setMasterCity(dbMastercity.get());
                        }
                    }
                   Users dbUser = null;
                    if(user != null) {
                        dbUser  = usersRepository.save(user);
                    }

                    if(userDTO.getMasterRoleDTO().getId() != null && userDTO.getMasterRoleDTO().getId() != 0) {
                        Optional<MasterRole> dbMasterRole = roleRepository.findById(userDTO.getMasterRoleDTO().getId());
                        if(dbMasterRole.isPresent()){
                            UserRoleMapping dbUserRoleMapping = roleMappingRepository.findUserById(dbUser.getId());
                            dbUserRoleMapping.setUsers(dbUserRoleMapping.getUsers());
                            dbUserRoleMapping.setMasterRole(dbMasterRole.get());
                            roleMappingRepository.save(dbUserRoleMapping);
                        }
                    }


                    response.setStatus("success");
                    response.setMessage("Hi" +" "+ userDTO.getUserName()  +" "+"your successfully updated");
                    response.setData(dbUser);
               }else{
                   response.setStatus("failed");
                   response.setMessage("please provide valid user id");
               }
            }else{
                response.setStatus("failed");
                response.setMessage("please provide user id");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public BaseResponse inActiveUser(Long userId, Long reqUserId) {
        BaseResponse response = new BaseResponse();
        try{
            if(userId != null) {
                UserRoleMapping userRoleMapping = null;
                if (reqUserId != null) {
                    userRoleMapping = roleMappingRepository.findUserById(reqUserId);
                }
                if(userRoleMapping != null){

                    if(userRoleMapping.getMasterRole().getRoleName().equalsIgnoreCase(UserConstant.ROLE_ADMIN)){

                        Users dbUser = usersRepository.getByUserId(userId);

                        if(dbUser != null){
                            dbUser.setStatus(Boolean.FALSE);
                            usersRepository.save(dbUser);
                            response.setStatus("success");
                            response.setMessage("successfully user has been in-active");
                            response.setData("in-active user");
                        }else{
                            response.setStatus("failed");
                            response.setMessage("please provide valid user id");
                        }
                    }else{
                        response.setStatus("failed");
                        response.setMessage("you don't have a access");
                    }
                }
            }else {
                response.setStatus("failed");
                response.setMessage("please provide any user id");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }
}
