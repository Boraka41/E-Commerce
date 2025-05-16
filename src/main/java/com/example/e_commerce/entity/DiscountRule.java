package com.example.e_commerce.entity;

import com.example.e_commerce.enums.RuleType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class DiscountRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ruleName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RuleType ruleType;

    @Column(nullable = false)
    private String conditionValue;

    @Column(nullable = false)
    private Double discountRate;

    private String targetCategory;

    private boolean active = true;

    private String description;

}
