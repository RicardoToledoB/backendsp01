package com.project.backend04.persistence;

import com.project.backend04.entity.TaskDetailEntity;
import com.project.backend04.entity.TaskEntity;

import java.util.List;
import java.util.Optional;

public interface ITaskDAO {
    List<TaskEntity> findAll();
    Optional<TaskEntity> findById(Integer id);
    void deleteById(Integer id);
    TaskEntity save(TaskEntity task);

}
