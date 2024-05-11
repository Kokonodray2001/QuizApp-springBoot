package com.kokonod.quizApp.service;

import com.kokonod.quizApp.dao.QuestionDao;
import com.kokonod.quizApp.dao.QuizDao;
import com.kokonod.quizApp.model.Question;
import com.kokonod.quizApp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        try {
            List<Question> questions =  questionDao.findRandomQuestionByCategory(category,numQ);
            if(questions.size()>0) {
                Quiz quiz = new Quiz();
                quiz.setTitle(title);
                quiz.setQuestions(questions);
                quizDao.save(quiz);
                return new ResponseEntity<>("added quiz successfully", HttpStatus.CREATED);
            }

            }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("could not find category",HttpStatus.NOT_FOUND);
    }
}
