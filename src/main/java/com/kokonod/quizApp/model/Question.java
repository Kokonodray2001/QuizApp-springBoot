package com.kokonod.quizApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data // this is coming from lombok dependency which handles the data so no need to add getter and setters
@Entity //When you mark a class with @Entity, you're essentially telling the ORM framework (in this case, JPA) that instances of this class should be mapped to rows in a database table. Each field in the class corresponds to a column in the table.
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String questionTitle; // in java, we use camelCase but in sql we use underscore camel_case , ORM(object relationship mapping) will handel it as we are using JPA(Java Persistence API) which is a ORM framework
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;
    private String difficultyLevel;
    private String category;
}
