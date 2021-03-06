package com.budgetfriendly.bms.controller;

import com.budgetfriendly.bms.dto.UserDTO;
import com.budgetfriendly.bms.response.BaseResponse;
import com.budgetfriendly.bms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("bms/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("createUser")
    public BaseResponse createUser(@RequestBody UserDTO userDTO){
        return userService.createUser(userDTO);
    }

    @GetMapping("username")
    public BaseResponse getByUsername(@RequestParam ("username") String username){
        return userService.getUserByUserName(username);
    }

    @PostMapping("updateUser")
    public BaseResponse updateUser(@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }

    @GetMapping("in-activeUser")
    public BaseResponse inActiveUser(@RequestParam("userId") Long userId){
        Long reqUserId = 1L;
        return userService.inActiveUser(userId,reqUserId);
  }
}
