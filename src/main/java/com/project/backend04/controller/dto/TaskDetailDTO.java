package com.project.backend04.controller.dto;
import com.project.backend04.entity.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDetailDTO {

    private Integer id;
    private String comment;
    private TaskEntity task;
}
