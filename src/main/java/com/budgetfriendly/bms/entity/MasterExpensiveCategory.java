package com.budgetfriendly.bms.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name  = "master_expensive_category")
public class MasterExpensiveCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "expensive_category_name")
    private String expensiveCategoryName;
    @Column(name = "expensive_category_code")
    private String expensiveCategoryCode;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "created_at")
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
