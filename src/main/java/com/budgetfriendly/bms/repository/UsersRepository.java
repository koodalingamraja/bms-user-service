package com.budgetfriendly.bms.repository;

import com.budgetfriendly.bms.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users , Long> {

    @Query("select user from Users as user where user.userName = :userName")
    Users getUserByUserName(@Param("userName") String userName);
}
