package com.rsfrancisco.course.resources;

import com.rsfrancisco.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User user = new User(1L, "Rafael", "broncasrafa@gmail.com", "11960641048", java.util.UUID.randomUUID().toString());
        return ResponseEntity.ok().body(user);
    }
}
