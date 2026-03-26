package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Survey;
import com.app.service.SurveyService;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("api/survey")
public class SurveyController {

	@Autowired
	SurveyService service;
	
	@PostMapping
	public Survey addSurvey(@RequestBody Survey survey) {
		return service.addSurvey(survey);
	}
	
	@GetMapping
	public List<Survey> dispSurvey() {
		return service.displaySurvey();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteSurvey(@PathVariable int id) {
		return new ResponseEntity<>(service.deleteSurvey(id),HttpStatus.OK);
	}
}
