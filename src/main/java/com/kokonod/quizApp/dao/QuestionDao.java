package com.kokonod.quizApp.dao;

import com.kokonod.quizApp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    List<Question>findByCategory(String category); // JPA framework will figure out category is a column
}
