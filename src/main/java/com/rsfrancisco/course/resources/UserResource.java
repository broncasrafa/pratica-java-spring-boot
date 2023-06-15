package com.rsfrancisco.course.resources;

import com.rsfrancisco.course.entities.Order;
import com.rsfrancisco.course.entities.User;
import com.rsfrancisco.course.services.OrderService;
import com.rsfrancisco.course.services.UserService;
import com.rsfrancisco.course.resources.viewmodels.request.UserUpdatePassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService _userService;
    @Autowired
    private OrderService _orderService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = _userService.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = _userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping(value="/{id}/orders")
    public ResponseEntity<List<Order>> findAllOrdersByUserId(@PathVariable Long id) {
        List<Order> userOrders = _orderService.findAllByUserId(id);
        return ResponseEntity.ok().body(userOrders);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User model) {
        User newUser = _userService.insert(model);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(uri).body(newUser);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        _userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User model) {
        User updatedUser = _userService.update(id, model);
        return ResponseEntity.ok().body(updatedUser);
    }

    @PutMapping(value="/{id}/password")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserUpdatePassword model) {
        User updatedUser = _userService.updatePassword(id, model.getPassword());
        return ResponseEntity.ok().body(updatedUser);
    }
}
