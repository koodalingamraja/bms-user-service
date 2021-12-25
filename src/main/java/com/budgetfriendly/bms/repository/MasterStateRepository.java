package com.budgetfriendly.bms.repository;

import com.budgetfriendly.bms.entity.MasterState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MasterStateRepository extends JpaRepository<MasterState , Long> {

    Optional<MasterState> findByIdAndStatusTrue(Long id);
}
