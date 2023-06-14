package com.rsfrancisco.course.repositories;

import com.rsfrancisco.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
