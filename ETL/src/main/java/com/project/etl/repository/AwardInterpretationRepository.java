package com.project.etl.repository;

import com.project.etl.model.AwardInterpretation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AwardInterpretationRepository extends JpaRepository<AwardInterpretation, Long> {
}
