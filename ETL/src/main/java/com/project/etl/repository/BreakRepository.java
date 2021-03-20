package com.project.etl.repository;

import com.project.etl.model.Break;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreakRepository extends JpaRepository<Break, Long> {
}
