package com.example.spring_mysql_connect.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Board {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    public Board() {
        this.id = null;
        this.title = "";
        this.content = "";
    }

    public Board(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
