package com.project.etl.repository;

import com.project.etl.dto.ShiftDTO;
import com.project.etl.model.Shift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftRepository extends JpaRepository<Shift, Long> {
}
