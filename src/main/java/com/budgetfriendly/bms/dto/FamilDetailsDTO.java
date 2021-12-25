package com.budgetfriendly.bms.dto;

import java.util.Date;

public class FamilDetailsDTO {

    private Long id;
    private String email;
    private String mobile;
    private Date dob;
    private String gender;
    private Boolean status;
    private Date createdAt;
    private UserDTO userDTO;
    private MasterRelationshipDTO masterRelationshipDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public MasterRelationshipDTO getMasterRelationshipDTO() {
        return masterRelationshipDTO;
    }

    public void setMasterRelationshipDTO(MasterRelationshipDTO masterRelationshipDTO) {
        this.masterRelationshipDTO = masterRelationshipDTO;
    }
}
