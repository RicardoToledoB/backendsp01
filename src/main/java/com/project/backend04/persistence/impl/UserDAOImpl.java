package com.project.backend04.persistence.impl;

import com.project.backend04.entity.UserEntity;
import com.project.backend04.persistence.IUserDAO;
import com.project.backend04.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDAOImpl implements IUserDAO {

    @Autowired
    private UserRepository repository;

    @Override
    public List<UserEntity> findAll() {
        return (List<UserEntity>) this.repository.findAll();
    }

    @Override
    public Optional<UserEntity> findById(Integer id) {
        return this.repository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        this.repository.deleteById(id);
    }

    @Override
    public UserEntity save(UserEntity task) {
        return this.repository.save(task);
    }
}
