package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Question;
import com.app.entity.Survey;
import com.app.repository.QuestionRepository;
import com.app.repository.SurveyRepository;

@Service
public class QuestionService {

	@Autowired
	QuestionRepository questionRepo;
	@Autowired
	SurveyRepository surveyRepository;
	
	

	public List<Question> getAllQuestion() {
		return questionRepo.findAll();
	}

	

}
