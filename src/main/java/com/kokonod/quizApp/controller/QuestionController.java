package com.kokonod.quizApp.controller;

import com.kokonod.quizApp.model.Question;
import com.kokonod.quizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getALLQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory( @PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("addQuestion")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        return  questionService.addQuestion(question);
    }

    @PutMapping("updateQuestion/{id}")
    public ResponseEntity<String> updateQuestion(@RequestBody Question question , @PathVariable String id){
        return questionService.updateQuestion(question,id);
    }

    @DeleteMapping("deleteQuestion/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable String id){
        return questionService.deleteQuestion(id);
    }
}
