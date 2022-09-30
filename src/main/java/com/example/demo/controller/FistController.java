package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FistController {

    @GetMapping("/hi")
    public String testhi(Model model){
        model.addAttribute("username","한글 테스트");
        return "greetings";
    }
    @GetMapping("/bye")
    public String testbye(Model model){
        model.addAttribute("username","잘가");
        return "bye";
    }

}
