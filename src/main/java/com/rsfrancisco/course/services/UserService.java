package com.rsfrancisco.course.services;

import com.rsfrancisco.course.entities.User;
import com.rsfrancisco.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository _userRepository;

    public List<User> findAll() {
        return _userRepository.findAll();
    }

    public User findById(Long userId) {
        Optional<User> obj =_userRepository.findById(userId);
        return obj.get();
    }

    public User insert(User user) {
        return _userRepository.save(user);
    }

    public void delete(Long userId) {
        _userRepository.deleteById(userId);
    }
}
