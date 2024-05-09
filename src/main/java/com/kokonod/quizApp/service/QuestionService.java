package com.kokonod.quizApp.service;

import com.kokonod.quizApp.dao.QuestionDao;
import com.kokonod.quizApp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }
    public List<Question> getQuestionsByCategory(String category) {
        return  questionDao.findByCategory(category);
    }

    public Question addQuestion(Question question) {
        return  questionDao.save(question);

    }
}
