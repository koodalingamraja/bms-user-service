package com.budgetfriendly.bms.repository;

import com.budgetfriendly.bms.entity.MasterRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterRoleRepository extends JpaRepository<MasterRole , Long> {
}
