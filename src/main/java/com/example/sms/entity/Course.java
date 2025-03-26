package com.example.sms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;  

    private String courseName;
    private String courseDescription;
    private String courseType;
    private String courseDuration;
    private String courseTopics;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();
}
