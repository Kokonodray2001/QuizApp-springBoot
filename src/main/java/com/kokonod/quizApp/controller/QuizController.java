package com.kokonod.quizApp.controller;

import com.kokonod.quizApp.model.Question;
import com.kokonod.quizApp.model.QuestionWrapper;
import com.kokonod.quizApp.model.Response;
import com.kokonod.quizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category , @RequestParam int numQ , @RequestParam String title) {

        return quizService.createQuiz(category,numQ,title);
    }

    @GetMapping("getQuiz/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable Integer id){
        return quizService.getQuizQuestion(id);
    }

    @PostMapping("submitQuiz/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id , @RequestBody List<Response> response){
        return quizService.getQuizResult(response, id);
    }
}
