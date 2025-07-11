package com.project.backend04.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.backend04.entity.TaskEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Integer id;
    private String email;
    private String password;
    private List<TaskEntity> tasks=new ArrayList<>();
}
