package com.kokonod.quizApp.service;

import com.kokonod.quizApp.dao.QuestionDao;
import com.kokonod.quizApp.model.Question;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public String updateQuestion(Question question, String id) {
            Optional<Question> optionalQuestion = questionDao.findById(Integer.parseInt(id));
            if(optionalQuestion.isPresent()){
                Question existingQuestion =  optionalQuestion.get();
                if(question.getQuestionTitle() != null)
                    existingQuestion.setQuestionTitle(question.getQuestionTitle());
                if(question.getCategory() != null)
                    existingQuestion.setCategory(question.getCategory());

                if(question.getOption1() != null)
                    existingQuestion.setOption1(question.getOption1());
                if(question.getOption2() != null)
                    existingQuestion.setOption2(question.getOption2());
                if(question.getOption3() != null)
                    existingQuestion.setOption3(question.getOption3());
                if(question.getOption4() != null)
                    existingQuestion.setOption4(question.getOption4());

                if(question.getDifficultyLevel()!=null)
                    existingQuestion.setDifficultyLevel(question.getDifficultyLevel());
                if(question.getRightAnswer()!=null)
                    existingQuestion.setRightAnswer(question.getRightAnswer());

                questionDao.save(existingQuestion);
            }

         return "updated sucess";
    }

    public String deleteQuestion(String id) {
        questionDao.deleteById(Integer.parseInt(id));
        return "deleted record with id " + id;
    }

}
