//only handles HTTP request
package com.kokonod.quizApp.controller;

import com.kokonod.quizApp.model.Question;
import com.kokonod.quizApp.service.DefaultQuestionService;
import com.kokonod.quizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("question")
public class QuestionController {

//    @Autowired
//    DefaultQuestionService defaultQuestionService;

    @Autowired
    QuestionService defaultQuestionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getALLQuestions(){
        return defaultQuestionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory( @PathVariable String category){
        return defaultQuestionService.getQuestionsByCategory(category);
    }

    @PostMapping("addQuestion")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        return  defaultQuestionService.addQuestion(question);
    }

    @PutMapping("updateQuestion/{id}")
    public ResponseEntity<String> updateQuestion(@RequestBody Question question , @PathVariable String id){
        return defaultQuestionService.updateQuestion(question,id);
    }

    @DeleteMapping("deleteQuestion/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable String id){
        return defaultQuestionService.deleteQuestion(id);
    }
}
