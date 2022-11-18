package com.example.spring_mysql_connect.repository;

import com.example.spring_mysql_connect.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {

}
