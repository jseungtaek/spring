package com.example.spring_mysql_connect.repository;

import com.example.spring_mysql_connect.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserJpaRepository extends JpaRepository<User, Long> {
    List<User> findByUsername(String name);


//    boolean equalUser(User a, User b);
}
