package com.budgetfriendly.bms.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "family_details")
public class FamilyDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email_id")
    private String email;

    @Column(name = "mobile_number")
    private String mobile;

    @Column(name = "date_of_berth")
    private Date dob;

    @Column(name = "gender")
    private String gender;

    @Column(name = "active_status")
    private Boolean status;

    @Column(name = "created_at")
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id_fk")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "relationship_id_fk")
    private MasterRelationship masterRelationship;

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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public MasterRelationship getMasterRelationship() {
        return masterRelationship;
    }

    public void setMasterRelationship(MasterRelationship masterRelationship) {
        this.masterRelationship = masterRelationship;
    }
}
