package com.project.backend04.service.impl;
import com.project.backend04.entity.TaskDetailEntity;
import com.project.backend04.persistence.ITaskDetailDAO;
import com.project.backend04.service.ITaskDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskDetailServiceImpl implements ITaskDetailService {

    @Autowired
    private ITaskDetailDAO taskDetailDAO;

    @Override
    public List<TaskDetailEntity> findAll() {
        return this.taskDetailDAO.findAll();
    }

    @Override
    public Optional<TaskDetailEntity> findById(Integer id) {
        return this.taskDetailDAO.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        this.taskDetailDAO.deleteById(id);
    }

    @Override
    public TaskDetailEntity save(TaskDetailEntity task) {
        return this.taskDetailDAO.save(task);
    }

}
