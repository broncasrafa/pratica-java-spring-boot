package com.rsfrancisco.course.resources;

import com.rsfrancisco.course.entities.Order;
import com.rsfrancisco.course.entities.User;
import com.rsfrancisco.course.services.OrderService;
import com.rsfrancisco.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
