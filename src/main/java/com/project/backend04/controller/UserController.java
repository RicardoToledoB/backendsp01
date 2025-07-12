package com.project.backend04.controller;

import com.project.backend04.controller.dto.UserDTO;
import com.project.backend04.entity.UserEntity;
import com.project.backend04.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private IUserService service;

    @GetMapping("/{id}")
    private ResponseEntity<?> findById(@PathVariable("id") Integer id) {
        Optional<UserEntity> user = service.findById(id);
        if (user.isPresent()) {
            UserEntity userEntity = user.get();
            UserDTO userDTO = UserDTO.builder()
                    .id(userEntity.getId())
                    .email(userEntity.getEmail())
                    .password(userEntity.getPassword())
                    .tasks(user.get().getTasks())
                    .build();
            return ResponseEntity.ok(userDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    private ResponseEntity<?> findAll() {
        List<UserDTO> userDTOs = service.findAll().stream()
                .map(users-> UserDTO.builder()
                        .id(users.getId())
                        .email(users.getEmail())
                        .password(users.getPassword())
                        .tasks(users.getTasks())
                        .build()
                ).toList();
        return ResponseEntity.ok(userDTOs);
    }

    @PostMapping
    private ResponseEntity<?> save(@RequestBody UserDTO userDTO) throws URISyntaxException {
       this.service.save(UserEntity.builder()
                       .email(userDTO.getEmail())
                       .password(userDTO.getPassword())
               .build());
        return ResponseEntity.created(new URI("/api/v1/users")).build();
    }

    @PutMapping("/{id}")
   private ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody UserDTO userDTO) {
        Optional<UserEntity> user = service.findById(id);
        if (user.isPresent()) {
            UserEntity userEntity = user.get();
            userEntity.setEmail(userDTO.getEmail());
            userEntity.setPassword(userDTO.getPassword());
            this.service.save(userEntity);
            return ResponseEntity.ok(userEntity);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        if(id!=null){
            this.service.deleteById(id);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.badRequest().build();
    }


}
