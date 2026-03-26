package com.app.service;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.app.entity.Question;
import com.app.entity.Survey;
import com.app.repository.QuestionRepository;
import com.app.repository.SurveyRepository;

@ExtendWith(MockitoExtension.class)
class SurveyServiceTest {

    @Mock
    private SurveyRepository repo;

    @Mock
    private QuestionRepository questionRepo;

    @InjectMocks
    private SurveyService surveyService;

    private Survey survey;

    @BeforeEach
    void setUp() {
        survey = new Survey();

        survey.setSurveyId(1);
        survey.setSurveyName("Customer Satisfaction");
        survey.setQuestions(new ArrayList<>());
    }

    @Test
    void addSurvey_shouldSaveAndReturnEntity() {
        when(repo.save(any(Survey.class))).thenAnswer(inv -> inv.getArgument(0));

        Survey saved = surveyService.addSurvey(survey);

        assertThat(saved).isNotNull();
        assertThat(saved.getSurveyName()).isEqualTo("Customer Satisfaction");
        verify(repo, times(1)).save(survey);
        verifyNoMoreInteractions(repo);
        verifyNoInteractions(questionRepo);
    }

    
    @Test
    void displaySurvey_shouldReturnAllSurveys() {
        Survey s1 = new Survey();
        s1.setSurveyId(1);
        s1.setSurveyName("S1");
        s1.setQuestions(new ArrayList<>());

        Survey s2 = new Survey();
        s2.setSurveyId(2);
        s2.setSurveyName("S2");
        s2.setQuestions(new ArrayList<>());

        when(repo.findAll()).thenReturn(Arrays.asList(s1, s2));

        List<Survey> result = surveyService.displaySurvey();

        assertThat(result).hasSize(2);
        assertThat(result.get(0).getSurveyName()).isEqualTo("S1");
        assertThat(result.get(1).getSurveyName()).isEqualTo("S2");
        verify(repo, times(1)).findAll();
        verifyNoMoreInteractions(repo);
        verifyNoInteractions(questionRepo);
        System.out.println(result);
    }

    @Test
    void deleteSurvey_whenSurveyExists_shouldDeleteQuestionsThenSurvey_andReturnOk() {
        int surveyId = 1;
        Question q1 = new Question();
        Question q2 = new Question();
        survey.setQuestions(Arrays.asList(q1, q2));

        when(repo.findById(surveyId)).thenReturn(Optional.of(survey));

        String result = surveyService.deleteSurvey(surveyId);

        assertThat(result).isEqualTo("ok");
        
        InOrder inOrder = inOrder(repo, questionRepo);
        inOrder.verify(repo).findById(surveyId);
        inOrder.verify(questionRepo).delete(q1);
        inOrder.verify(questionRepo).delete(q2);
        inOrder.verify(repo).delete(survey);

        verifyNoMoreInteractions(repo, questionRepo);
    }

   

    
}