package com.example.spring_mysql_connect.controller;

import com.example.spring_mysql_connect.dto.BoardForm;
import com.example.spring_mysql_connect.entity.Board;
import com.example.spring_mysql_connect.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("board/new")
    public String NewBoardForm() {
        return "board/new";
    }

    @PostMapping("/board/create")
    public String CreateBoard(BoardForm form) {

        //1. Dto -> Entity
        Board board = form.toEntity();
        System.out.println(board.toString());

        //2. Repository에 Entity정보를 DB에 저장
        Board saveinfo = boardRepository.save(board);
        System.out.println(saveinfo.toString());

        return "board/new";
    }

}
