package com.kokonod.quizApp.service;

import com.kokonod.quizApp.dao.QuestionDao;
import com.kokonod.quizApp.dao.QuizDao;
import com.kokonod.quizApp.model.Question;
import com.kokonod.quizApp.model.QuestionWrapper;
import com.kokonod.quizApp.model.Quiz;
import com.kokonod.quizApp.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {

        try {

            Optional<Quiz> quiz = quizDao.findById(id);
            List<Question> questionsFromDB = quiz.get().getQuestions(); // .get() is to get the quiz object because we are using optional;
            List<QuestionWrapper> questionForUsers = new ArrayList<>();
            if(questionsFromDB!=null) {
                for (Question question : questionsFromDB) {
                    QuestionWrapper questionWrapper = new QuestionWrapper(question.getId(),
                            question.getQuestionTitle(), question.getOption1(), question.getOption2(),
                            question.getOption3(), question.getOption4());

                    questionForUsers.add(questionWrapper);
                }

                return new ResponseEntity<>(questionForUsers, HttpStatus.OK);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Integer> getQuizResult(List<Response> response , Integer id) {

        int score = 0;
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();
        int i =0;
        for(Response res:  response){
            if(res.getResponse().equals(questionsFromDB.get(i).getRightAnswer()))
                score += 10;
            i++;
        }
        return  new ResponseEntity<>(score,HttpStatus.OK);
    }
}
