//contains only business logic
package com.kokonod.quizApp.service;

import com.kokonod.quizApp.dao.QuestionDao;
import com.kokonod.quizApp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultQuestionService implements QuestionService{

    @Autowired
    QuestionDao questionDao;

    @Override
    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            List<Question> questions = questionDao.findAll();
            if (!questions.isEmpty())
                return new ResponseEntity<>(questions, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
    return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            List<Question> questions = questionDao.findByCategory(category);
            if(!questions.isEmpty())
                return new ResponseEntity<>(questions,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Question> addQuestion(Question question) {
        try {
            return  new ResponseEntity<>(questionDao.save(question),HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<String> updateQuestion(Question question, String id) {
            Optional<Question> optionalQuestion = questionDao.findById(Integer.parseInt(id));

            try {
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
                    return new ResponseEntity<>("updated successfully ",HttpStatus.OK);
                }
            }catch (Exception e){
                e.printStackTrace();
            }


         return new ResponseEntity<>("could not find question",HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<String> deleteQuestion(String id) {
        try {
            if(questionDao.existsById(Integer.parseInt(id))){
                questionDao.deleteById(Integer.parseInt(id));
                return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("could not find question",HttpStatus.NOT_FOUND);
    }
}
