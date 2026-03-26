package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Question;
import com.app.entity.Survey;
import com.app.repository.QuestionRepository;
import com.app.repository.SurveyRepository;

@Service
public class SurveyService {

	@Autowired
	SurveyRepository repo;

	@Autowired
	private QuestionRepository questionRepo;

	public Survey addSurvey(Survey survey) {
		return repo.save(survey);
	}

	public List<Survey> displaySurvey() {
		return repo.findAll();
	}

	public String deleteSurvey(int surveyId) {
		try {
			Survey survey = repo.findById(surveyId).orElse(null);
			if (survey == null) {
				return "Id Not Found";
			}
			for (Question q : survey.getQuestions()) {
				questionRepo.delete(q);
			}
			repo.delete(survey);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "ok";
	}

	public Survey addQuestion(int id, Question question) {
		Survey survey = repo.findById(id).orElse(null);
		survey.addQuestion(question);
		question.setSurvey(survey);
		return repo.save(survey);
	}

}
