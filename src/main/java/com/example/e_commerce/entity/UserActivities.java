package com.example.e_commerce.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class UserActivities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    private Long click;

}
