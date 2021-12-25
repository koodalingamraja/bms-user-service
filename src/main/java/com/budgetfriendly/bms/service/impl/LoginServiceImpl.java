package com.budgetfriendly.bms.service.impl;

import com.budgetfriendly.bms.dto.LoginDTO;
import com.budgetfriendly.bms.entity.Users;
import com.budgetfriendly.bms.repository.UsersRepository;
import com.budgetfriendly.bms.response.BaseResponse;
import com.budgetfriendly.bms.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public BaseResponse login(LoginDTO loginDTO) {
        BaseResponse response = new BaseResponse();
        try{
            if(loginDTO.getUserName() != null || loginDTO.getUserName().isEmpty() && loginDTO.getPassword() != null || loginDTO.getPassword().isEmpty()){
                Users user = usersRepository.login(loginDTO.getUserName(),loginDTO.getPassword());
                if(user == null){
                    response.setStatus("failed");
                    response.setMessage("please enter valid username or password");
                }else {
                    response.setStatus("success");
                    response.setMessage("Hi" + " " + user.getUserName() + " " + "you are successfully login");
                }
            }else{
                response.setStatus("failed");
                response.setMessage("please enter username or password");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }
}
