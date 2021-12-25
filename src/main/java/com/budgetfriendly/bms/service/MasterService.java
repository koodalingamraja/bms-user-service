package com.budgetfriendly.bms.service;

import com.budgetfriendly.bms.dto.MasterCityDTO;
import com.budgetfriendly.bms.dto.MasterExpensiveCategoryDTO;
import com.budgetfriendly.bms.dto.MasterRelationshipDTO;
import com.budgetfriendly.bms.dto.MasterStateDTO;
import com.budgetfriendly.bms.response.BaseResponse;

public interface MasterService {

    BaseResponse createState(MasterStateDTO masterStateDTO);

    BaseResponse createCity(MasterCityDTO masterCityDTO);

    BaseResponse createRelationship(MasterRelationshipDTO relationshipDTO);

    BaseResponse createExpensiveCategory(MasterExpensiveCategoryDTO expensiveCategoryDTO);
}
