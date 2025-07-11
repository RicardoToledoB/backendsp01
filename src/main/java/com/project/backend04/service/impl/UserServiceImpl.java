package com.project.backend04.service.impl;

import com.project.backend04.entity.UserEntity;
import com.project.backend04.persistence.IUserDAO;
import com.project.backend04.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDAO userDAO;

    @Override
    public List<UserEntity> findAll() {
        return this.userDAO.findAll();
    }

    @Override
    public Optional<UserEntity> findById(Integer id) {
        return this.userDAO.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        this.userDAO.deleteById(id);
    }

    @Override
    public UserEntity save(UserEntity task) {
        return this.userDAO.save(task);
    }
}
