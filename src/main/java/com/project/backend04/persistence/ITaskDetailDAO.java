package com.project.backend04.persistence;

import com.project.backend04.entity.TaskDetailEntity;
import com.project.backend04.entity.TaskEntity;

import java.util.List;
import java.util.Optional;

public interface ITaskDetailDAO {
    List<TaskDetailEntity> findAll();
    Optional<TaskDetailEntity> findById(Integer id);
    void deleteById(Integer id);
    TaskDetailEntity save(TaskDetailEntity task);

}
