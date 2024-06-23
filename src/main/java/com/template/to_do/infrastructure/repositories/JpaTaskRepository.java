package com.template.to_do.infrastructure.repositories;

import com.template.to_do.infrastructure.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTaskRepository extends JpaRepository<TaskEntity, Long> {
}
