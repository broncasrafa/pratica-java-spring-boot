package com.rsfrancisco.course.repositories;

import com.rsfrancisco.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository // JpaRepository ja tem a anotação @Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
