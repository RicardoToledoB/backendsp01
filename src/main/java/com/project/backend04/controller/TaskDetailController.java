package com.project.backend04.controller;
import com.project.backend04.controller.dto.TaskDetailDTO;
import com.project.backend04.entity.TaskDetailEntity;
import com.project.backend04.service.ITaskDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/tasks_details")
public class TaskDetailController {

    @Autowired
    private ITaskDetailService service;

    @GetMapping("/{id}")
    private ResponseEntity<?> findById(@PathVariable Integer id) {
        Optional<TaskDetailEntity> taskDetailEntity = this.service.findById(id);
        if (taskDetailEntity.isPresent()) {
            TaskDetailEntity taskDetail = taskDetailEntity.get();
            TaskDetailDTO taskDetailDTO = TaskDetailDTO.builder()
                    .id(taskDetail.getId())
                    .comment(taskDetail.getComment())
                    .task(taskDetail.getTask())
                    .build();
            return ResponseEntity.ok(taskDetailDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    private ResponseEntity<?> findAll() {
        List<TaskDetailDTO> taskDetailDTOS = this.service.findAll()
                .stream()
                .map(tasks_details -> TaskDetailDTO.builder()
                        .id(tasks_details.getId())
                        .comment(tasks_details.getComment())
                        .task(tasks_details.getTask())
                        .build()).toList();
        return ResponseEntity.ok(taskDetailDTOS);
    }

    @PostMapping
    private ResponseEntity<?> save(@RequestBody TaskDetailDTO taskDetailDTO) throws URISyntaxException {
        this.service.save(TaskDetailEntity.builder()
                .comment(taskDetailDTO.getComment())
                .task(taskDetailDTO.getTask())
                .build());
        return ResponseEntity.created(new URI("/api/v1/tasks_details")).build();
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> update(@PathVariable Integer id, @RequestBody TaskDetailDTO taskDetailDTO) {
        Optional<TaskDetailEntity> taskDetailEntity = this.service.findById(id);
        if (taskDetailEntity.isPresent()) {
            TaskDetailEntity taskDetail = taskDetailEntity.get();
            taskDetail.setComment(taskDetailDTO.getComment());
            taskDetail.setTask(taskDetailDTO.getTask());
            this.service.save(taskDetail);
            return ResponseEntity.ok(taskDetailDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@PathVariable Integer id) {
        if(id!=null){
            this.service.deleteById(id);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.badRequest().build();
    }
}
