package com.budgetfriendly.bms.repository;

import com.budgetfriendly.bms.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users , Long> {

    @Query("select user from Users as user where user.userName = :userName AND user.status=true")
    Users getUserByUserName(@Param("userName") String userName);

    @Query("select user from Users as user where user.id = :userId AND user.status=true")
    Users getByUserId(@Param("userId")Long userId);

    @Query("select user from Users as user where user.userName = :userName  AND user.password = :password AND user.status=true")
    Users login(@Param("userName") String userName,@Param("password") String password);
}
