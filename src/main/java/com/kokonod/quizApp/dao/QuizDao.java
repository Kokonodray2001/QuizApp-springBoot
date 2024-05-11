package com.kokonod.quizApp.dao;

import com.kokonod.quizApp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer> {
}
