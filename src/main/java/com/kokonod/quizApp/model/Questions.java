package com.kokonod.quizApp.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String questionTile; // in java, we use camelCase but in sql we use underscore camel_case , ORM(object relationship mapping) will handel it as we are using JPA(Java Persistence API) which is a ORM framework
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;
    private String difficultyLevel;
}
