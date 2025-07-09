package com.project.backend04.service;

import com.project.backend04.entity.TaskEntity;

import java.util.List;
import java.util.Optional;

public interface ITaskService {

    List<TaskEntity> findAll();
    Optional<TaskEntity> findById(Integer id);
    void deleteById(Integer id);
    TaskEntity save(TaskEntity task);

}
