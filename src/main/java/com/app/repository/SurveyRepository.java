package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Survey;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Integer> {

}
