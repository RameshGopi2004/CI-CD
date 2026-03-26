package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Question;
import com.app.entity.Survey;
import com.app.service.QuestionService;
import com.app.service.SurveyService;


@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("api/question")
public class QuestionController {

	@Autowired
	private QuestionService service;
	
	@Autowired
	private SurveyService surveyService;
	
	@GetMapping("home")
	public String getHome() {
		return "Welcome Home";
	}
	
	
	@PostMapping("add/{id}")
	public Survey addQuestion(@PathVariable int id, @RequestBody Question question) {
		return surveyService.addQuestion(id,question);
	}
	
	@GetMapping 
	public List<Question> getAllQuestion() {
		return service.getAllQuestion();
	}
	
	
}
