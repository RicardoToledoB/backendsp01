package com.project.backend04.persistence.impl;

import com.project.backend04.entity.TaskDetailEntity;
import com.project.backend04.entity.TaskEntity;
import com.project.backend04.persistence.ITaskDetailDAO;
import com.project.backend04.repository.TaskDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TaskDetailDAOImpl implements ITaskDetailDAO {

    @Autowired
    private TaskDetailRepository repository;

    @Override
    public List<TaskDetailEntity> findAll() {
        return (List<TaskDetailEntity>) this.repository.findAll();
    }

    @Override
    public Optional<TaskDetailEntity> findById(Integer id) {
        return this.repository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        this.repository.deleteById(id);
    }

    @Override
    public TaskDetailEntity save(TaskDetailEntity task) {
        return this.repository.save(task);
    }


}
