package com.example.spring_mysql_connect.repository;

import com.example.spring_mysql_connect.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
