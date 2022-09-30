package com.example.demo.controller;

import com.example.demo.dto.articleForm;
import com.example.demo.repository.articleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.article;

import java.util.List;

@Controller
@Slf4j
public class ArticleController {

    @Autowired // 스프링 부트가 미리 생성한 객체를 자동 연결
    private articleRepository rs;

    @GetMapping("/form/New")
    public String testform(Model model){

        return "/articles/formTest";
    }

    @PostMapping("/article/create")
    public String createArticles(articleForm form){
        //System.out.println(form.toString());
        log.info(form.toString());
        // dto -> entity
        article a = form.getEntity();

        // entity -> DB
        article saved = rs.save(a);
        //System.out.println(saved.toString());
        log.info(saved.toString());

        return "redirect:/articles/"+saved.getId();
    }

    @GetMapping("/articles/{id}")
    public String showArticles(@PathVariable Long id, Model model){
        log.info(""+id);
        article aEntity = rs.findById(id).orElse(null);

        model.addAttribute("article",aEntity);

        return "/articles/show";
    }

    @GetMapping("/articles")
    public String showAll(Model model){

        List<article> aEntityList = rs.findAll();

        model.addAttribute("articleList",aEntityList);

        return "/articles/index";
    }
    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model){

        article aEntity = rs.findById(id).orElse(null);

        model.addAttribute("article",aEntity);

        return "/articles/edit";
    }

    @PutMapping("/article/update/{id}")
    public String update(@PathVariable Long id, articleForm form){


        article a = form.getEntity();
        log.debug(a.toString());
        // entity -> DB
        a.setId(id);
        article saved = rs.save(a);



        return "redirect:/articles/"+saved.getId();
    }

    @GetMapping("/article/delete/{id}")
    public String delete(@PathVariable Long id){


        article aEntity = rs.findById(id).orElse(null);
        rs.delete(aEntity);




        return "redirect:/articles/";
    }

}
