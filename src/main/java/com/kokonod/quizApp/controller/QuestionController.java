package com.kokonod.quizApp.controller;

import com.kokonod.quizApp.model.Question;
import com.kokonod.quizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public List<Question> getALLQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public List<Question> getQuestionsByCategory( @PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("addQuestion")
    public Question addQuestion(@RequestBody Question question){
        return  questionService.addQuestion(question);
    }

    @PutMapping("updateQuestion/{id}")
    public String updateQuestion(@RequestBody Question question , @PathVariable String id){
        return questionService.updateQuestion(question,id);
    }

    @DeleteMapping("deleteQuestion/{id}")
    public String deleteQuestion(@PathVariable String id){
        return questionService.deleteQuestion(id);
    }
}
