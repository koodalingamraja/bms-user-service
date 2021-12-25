package com.budgetfriendly.bms.controller;

import com.budgetfriendly.bms.dto.LoginDTO;
import com.budgetfriendly.bms.response.BaseResponse;
import com.budgetfriendly.bms.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("userLogin")
    public BaseResponse login(@RequestBody LoginDTO loginDTO){
        return loginService.login(loginDTO);
    }
}
