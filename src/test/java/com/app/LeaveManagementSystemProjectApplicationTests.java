package com.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LeaveManagementSystemProjectApplicationTests {

	private WebDriver webDriver;

	@BeforeEach
	public void declareWeb() {
		this.webDriver = new ChromeDriver();
	}

	@AfterEach
	public void close() {
		this.webDriver.close();
	}

	@Test
	void openSurveyHomeScreen() {
		webDriver.get("http://localhost:5173/");
		String s1 = webDriver.getCurrentUrl();
		assertEquals("http://localhost:5173/", s1);

	}

	@Test
	void enterAddSurveyButton() {
		webDriver.get("http://localhost:5173/");
		webDriver.findElement(By.id("addbtn")).click();
		assertEquals("http://localhost:5173/survey", webDriver.getCurrentUrl());

	}

//	@Test
//	void addSurvey() {
//		webDriver.get("http://localhost:5173/");
//		webDriver.findElement(By.id("addbtn")).click();
//		webDriver.findElement(By.name("surveyName")).sendKeys("Cars Survey");
//		webDriver.findElement(By.name("submitButton")).click();
//		assertEquals("http://localhost:5173/survey", webDriver.getCurrentUrl());
//	}

	@Test
	void viewSurvey() {
		webDriver.get("http://localhost:5173/survey");
		webDriver.findElement(By.id("viewSurveybtn")).click();
		assertEquals("http://localhost:5173/viewsurvey", webDriver.getCurrentUrl());
	}

//	@Test
//	void addQuestions() {
//		webDriver.get("http://localhost:5173/viewsurvey");
//		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		webDriver.findElement(By.name("addQuestionButton")).click();
//		webDriver.findElement(By.id("questionBtn")).sendKeys("What is the high priced car");
//		webDriver.findElement(By.id("OptionAbtn")).sendKeys("punch");
//		webDriver.findElement(By.id("OptionBbtn")).sendKeys("tiago");
//		webDriver.findElement(By.id("OptionCbtn")).sendKeys("rolls royce boat tail");
//		webDriver.findElement(By.id("OptionDbtn")).sendKeys("ferrari spyder");
//		webDriver.findElement(By.id("answer")).sendKeys("rolls royce boat tail");
//		webDriver.findElement(By.id("addQuestion")).click();
//		webDriver.switchTo().alert().accept();
//		assertEquals("http://localhost:5173/viewsurvey", webDriver.getCurrentUrl());
//	}

//	@Test
//	void viewQuestions() {
//		webDriver.get("http://localhost:5173/viewsurvey");
//		webDriver.findElement(By.id("viewQuestionBtn")).click();
//		assertEquals("http://localhost:5173/viewsurvey", webDriver.getCurrentUrl());
//	}
	
	@Test
	void RedirectFromViewSurveyToAddSurvey() {
		webDriver.get("http://localhost:5173/viewsurvey");
		webDriver.findElement(By.id("redirectAddSurveyBtn")).click();
		assertEquals("http://localhost:5173/survey", webDriver.getCurrentUrl());		
	}
	
	@Test
	void RedirectFromViewSurveyToHome() {
		webDriver.get("http://localhost:5173/viewsurvey");
		webDriver.findElement(By.id("redirectHome")).click();
		assertEquals("http://localhost:5173/", webDriver.getCurrentUrl());		
	}
	
	@Test
	void RedirectFromHomeToViewSurvey() {
		webDriver.get("http://localhost:5173/");
		webDriver.findElement(By.id("viewSurveyButton")).click();
		assertEquals("http://localhost:5173/viewsurvey", webDriver.getCurrentUrl());		
	}
	
	@Test
	void RedirectAddSurveyToViewSurvey() {
		webDriver.get("http://localhost:5173/survey");
		webDriver.findElement(By.id("viewSurveybtn")).click();
		assertEquals("http://localhost:5173/viewsurvey", webDriver.getCurrentUrl());			
	}
	
	@Test
	void RedirectAddSurveyToHome() {
		webDriver.get("http://localhost:5173/survey");
		webDriver.findElement(By.id("Homebtn")).click();
		assertEquals("http://localhost:5173/", webDriver.getCurrentUrl());			
		
	}
	
	
//	@Test
//	void deleteSurvey() {
//		webDriver.get("http://localhost:5173/viewsurvey");
//		webDriver.findElement(By.id("deleteSurveyBtn")).click();
//		assertEquals("http://localhost:5173/viewsurvey", webDriver.getCurrentUrl());
//		
//	}

//	@Test
//	void enterAddSurveyButton() {
//		webDriver.get("http://localhost:5174/");
//		webDriver.findElement(By.id("addbtn")).click();
//		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		String s2 = webDriver.getCurrentUrl();
//		assertEquals("http://localhost:5174/survey", s2); 
//	}
//	
//	@Test
//	void addSurveyInputField() {
//		webDriver.get("http://localhost:5174/");
//		webDriver.findElement(By.id("addbtn")).click();
//		webDriver.findElement(By.name("surveyName")).sendKeys("General Knowledge demo survey");
//		webDriver.findElement(By.name("submitButton")).click();
//		String s3=webDriver.getCurrentUrl();
//		assertEquals("http://localhost:5174/survey", s3);
//	}
}
