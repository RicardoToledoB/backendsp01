package com.project.backend04.repository;

import com.project.backend04.entity.TaskDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDetailRepository extends CrudRepository<TaskDetailEntity,Integer> {
}
