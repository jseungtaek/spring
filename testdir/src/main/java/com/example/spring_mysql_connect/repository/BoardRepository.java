package com.example.spring_mysql_connect.repository;

import com.example.spring_mysql_connect.entity.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Long> {
}
