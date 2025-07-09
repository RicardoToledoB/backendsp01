package com.project.backend04.service;


import com.project.backend04.entity.TaskDetailEntity;

import java.util.List;
import java.util.Optional;

public interface ITaskDetailService {
    List<TaskDetailEntity> findAll();
    Optional<TaskDetailEntity> findById(Integer id);
    void deleteById(Integer id);
    TaskDetailEntity save(TaskDetailEntity task);

}
