package com.budgetfriendly.bms.repository;

import com.budgetfriendly.bms.entity.FamilyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilDetailsRepository extends JpaRepository<FamilyDetails , Long> {
}
