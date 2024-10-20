package com.example.btth04.entities;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String id;
    private String name;
    private String studentClass;
    private double gpa;
}
