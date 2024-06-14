package com.kokonod.quizApp.service;

import com.kokonod.quizApp.model.Question;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionService {
    ResponseEntity<List<Question>> getAllQuestions();
    ResponseEntity<List<Question>> getQuestionsByCategory(String category);
    ResponseEntity<Question> addQuestion(Question question);
    ResponseEntity<String> updateQuestion(Question question, String id);
    ResponseEntity<String> deleteQuestion(String id);
}
