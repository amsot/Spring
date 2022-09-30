package com.example.demo.dto;


import com.example.demo.entity.article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class articleForm {

    private String title;
    private String content;

    public article getEntity(){
        return new article(null,title,content);
    }

}
