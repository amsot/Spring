package com.example.demo.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
@Setter
public class article {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;
    @Column
    private String content;


}
