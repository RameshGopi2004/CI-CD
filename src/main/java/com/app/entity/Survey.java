package com.app.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Survey {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int surveyId;
	private String surveyName;

	@OneToMany(mappedBy = "survey",cascade = CascadeType.ALL)
	private List<Question> questions;

	public List<Question> getQuestions() {
		return questions;
	}
	

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public String getSurveyName() {
		return surveyName;
	}

	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}


	public void addQuestion(Question question) {
		this.questions.add(question);
	}
}