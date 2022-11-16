package com.example.spring_test.controller;

import com.example.spring_test.dto.ArticleForm;
import com.example.spring_test.entity.Article;
import com.example.spring_test.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository; //객체를 만들지 않아도 spring boot가 생성해놓은 객체를 가져다 연결

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
//        System.out.println(form.toString());
//
//        //1. Dto를 변환 -> Entity
//        Article article = form.toEntity();
//        System.out.println(article.toString());
//
//        //2. Repository에 Entity를 DB에 저장
//        Article saved = articleRepository.save(article);
//        System.out.println(saved.toString());

        return "articles/new";
    }
}
