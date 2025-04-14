package com.example.sms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String addressType;  
    private String city;
    private String state;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
}
