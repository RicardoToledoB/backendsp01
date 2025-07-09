package com.project.backend04.persistence.impl;

import com.project.backend04.entity.TaskEntity;
import com.project.backend04.persistence.ITaskDAO;
import com.project.backend04.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TaskDAOImpl implements ITaskDAO {

    @Autowired
    private TaskRepository repository;

    @Override
    public List<TaskEntity> findAll() {
        return (List<TaskEntity>) this.repository.findAll();
    }

    @Override
    public Optional<TaskEntity> findById(Integer id) {
        return this.repository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        this.repository.deleteById(id);
    }

    @Override
    public TaskEntity save(TaskEntity task) {
        return this.repository.save(task);
    }


}
