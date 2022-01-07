package com.budgetfriendly.bms.repository;

import com.budgetfriendly.bms.entity.UserRoleMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleMappingRepository extends JpaRepository<UserRoleMapping , Long> {

    @Query("select role from UserRoleMapping as role where role.users.id = :reqUserId")
    UserRoleMapping findByUserId(@Param("reqUserId") Long reqUserId);
}
