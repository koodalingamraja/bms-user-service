package com.budgetfriendly.bms.repository;

import com.budgetfriendly.bms.entity.MasterExpensiveCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterExpensiveCategoryRepository extends JpaRepository<MasterExpensiveCategory , Long> {
}
