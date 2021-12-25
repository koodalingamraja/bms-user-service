package com.budgetfriendly.bms.repository;

import com.budgetfriendly.bms.entity.MasterRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterRealtionshipRepository extends JpaRepository<MasterRelationship , Long> {
}
