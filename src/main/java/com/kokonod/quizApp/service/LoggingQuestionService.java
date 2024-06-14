//for storing in some other database / cache / files
package com.kokonod.quizApp.service;

import com.kokonod.quizApp.model.Question;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class LoggingQuestionService implements QuestionService{
    @Override
    public ResponseEntity<List<Question>> getAllQuestions() {
        return null;
    }

    @Override
    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        return null;
    }

    @Override
    public ResponseEntity<Question> addQuestion(Question question) {
        return null;
    }

    @Override
    public ResponseEntity<String> updateQuestion(Question question, String id) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteQuestion(String id) {
        return null;
    }
}
