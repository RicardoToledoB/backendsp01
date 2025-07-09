package com.project.backend04.controller.dto;
import com.project.backend04.entity.TaskDetailEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TaskDTO {

    private Integer id;
    private String name;
    private String description;
    List<TaskDetailEntity> tasks_details;
}
