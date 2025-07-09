package com.project.backend04.controller;
import com.project.backend04.controller.dto.TaskDTO;
import com.project.backend04.entity.TaskEntity;
import com.project.backend04.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    private ITaskService service;

    @GetMapping("/{id}")
    private ResponseEntity<?> findById(@PathVariable("id") Integer id) {
        Optional<TaskEntity> taskEntity = service.findById(id);
        if(taskEntity.isPresent()) {
            TaskEntity task = taskEntity.get();
            TaskDTO taskDTO = TaskDTO.builder()
                    .id(task.getId())
                    .name(task.getName())
                    .description(task.getDescription())
                    .tasks_details(task.getTasks_details())
                    .build();
            return  ResponseEntity.ok(taskDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    private ResponseEntity<?> findAll() {
        List<TaskDTO> taskDTOList=this.service.findAll()
                .stream()
                .map(tasks->TaskDTO.builder()
                        .id(tasks.getId())
                        .name(tasks.getName())
                        .description(tasks.getDescription())
                        .tasks_details(tasks.getTasks_details())
                        .build())
                .toList();
                return ResponseEntity.ok(taskDTOList);
    }

    @PostMapping
    private ResponseEntity<?> save(@RequestBody TaskDTO taskDTO) throws URISyntaxException {
        this.service.save(TaskEntity.builder()
                .id(taskDTO.getId())
                .name(taskDTO.getName())
                .description(taskDTO.getDescription()).build());
        return ResponseEntity.created(new URI("/api/v1/tasks")).build();
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody TaskDTO taskDTO) {
        Optional<TaskEntity> taskEntity = service.findById(id);
        if(taskEntity.isPresent()) {
            TaskEntity task = taskEntity.get();
            task.setName(taskDTO.getName());
            task.setDescription(taskDTO.getDescription());
            this.service.save(task);
            return ResponseEntity.ok(task);
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
