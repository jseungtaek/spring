package com.example.spring_mysql_connect.dto;

import com.example.spring_mysql_connect.entity.Board;

public class BoardForm {

    private String title;
    private String content;

    public BoardForm(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "BoardForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Board toEntity() {
        return new Board(null, title, content);
    }
}
