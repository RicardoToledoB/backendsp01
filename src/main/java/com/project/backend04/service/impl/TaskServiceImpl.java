package com.project.backend04.service.impl;
import com.project.backend04.entity.TaskEntity;
import com.project.backend04.persistence.ITaskDAO;
import com.project.backend04.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements ITaskService {

    @Autowired
    private ITaskDAO taskDAO;

    @Override
    public List<TaskEntity> findAll() {
        return this.taskDAO.findAll();
    }

    @Override
    public Optional<TaskEntity> findById(Integer id) {
        return this.taskDAO.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        this.taskDAO.deleteById(id);
    }

    @Override
    public TaskEntity save(TaskEntity task) {
        return this.taskDAO.save(task);
    }

}
