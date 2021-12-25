package com.budgetfriendly.bms.service;

import com.budgetfriendly.bms.dto.UserDTO;
import com.budgetfriendly.bms.response.BaseResponse;

public interface UserService {

    BaseResponse createUser(UserDTO userDTO);

    BaseResponse getUserByUserName(String userName);

    BaseResponse updateUser(UserDTO userDTO);
}
