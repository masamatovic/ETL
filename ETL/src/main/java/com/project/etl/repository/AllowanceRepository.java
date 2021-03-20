package com.project.etl.repository;

import com.project.etl.model.Allowance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllowanceRepository extends JpaRepository<Allowance, Long> {
}
