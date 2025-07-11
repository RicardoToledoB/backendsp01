package com.project.backend04.persistence;

import com.project.backend04.entity.TaskEntity;
import com.project.backend04.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserDAO {
    List<UserEntity> findAll();
    Optional<UserEntity> findById(Integer id);
    void deleteById(Integer id);
    UserEntity save(UserEntity task);
}
