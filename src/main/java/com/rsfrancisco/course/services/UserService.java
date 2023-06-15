package com.rsfrancisco.course.services;

import com.rsfrancisco.course.entities.User;
import com.rsfrancisco.course.repositories.UserRepository;
import com.rsfrancisco.course.services.exceptions.DatabaseException;
import com.rsfrancisco.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(userId));
    }

    public User insert(User user) {
        return _userRepository.save(user);
    }

    public void delete(Long userId) {
        try {
            _userRepository.deleteById(userId);
        } catch (EmptyResultDataAccessException ex) {
            throw new ResourceNotFoundException(userId);
        } catch (DataIntegrityViolationException ex) {
            throw new DatabaseException(ex.getMessage());
        }
    }

    public User update(Long userid, User user) {
        User entity = _userRepository.getReferenceById(userid); // prepara o objeto monitorado para você mexer e depois efetuar alguma operação no DB
        entity.setEmail(user.getEmail());
        entity.setName(user.getName());
        entity.setPhone(user.getPhone());
        return _userRepository.save(entity);
    }
    public User updatePassword(Long userid, String password) {
        User entity = _userRepository.getReferenceById(userid); // prepara o objeto monitorado para você mexer e depois efetuar alguma operação no DB
        entity.setPassword(password);
        return _userRepository.save(entity);
    }
}
