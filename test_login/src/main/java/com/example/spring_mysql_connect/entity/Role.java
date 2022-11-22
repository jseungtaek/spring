package com.example.spring_mysql_connect.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    public String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
