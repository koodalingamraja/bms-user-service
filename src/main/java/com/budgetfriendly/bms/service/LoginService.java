package com.budgetfriendly.bms.service;

import com.budgetfriendly.bms.dto.LoginDTO;
import com.budgetfriendly.bms.response.BaseResponse;

public interface LoginService {

    BaseResponse login(LoginDTO loginDTO);
}
