package com.budgetfriendly.bms.dto;


import java.util.Date;

public class MasterExpensiveCategoryDTO {

    private Long id;
    private String expensiveCategoryName;
    private String expensiveCategoryCode;
    private Boolean status;
    private Date createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpensiveCategoryName() {
        return expensiveCategoryName;
    }

    public void setExpensiveCategoryName(String expensiveCategoryName) {
        this.expensiveCategoryName = expensiveCategoryName;
    }

    public String getExpensiveCategoryCode() {
        return expensiveCategoryCode;
    }

    public void setExpensiveCategoryCode(String expensiveCategoryCode) {
        this.expensiveCategoryCode = expensiveCategoryCode;
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
}
