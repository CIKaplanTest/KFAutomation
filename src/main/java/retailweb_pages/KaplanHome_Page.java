package retailweb_pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import exam_pages.ExamSelectCourse_Page;
import wrappers.KaplanSpecificWrappers;


public class KaplanHome_Page extends KaplanSpecificWrappers {
	
	
	//Confirming that we are in Select Kaplan Home Page
	public KaplanHome_Page(RemoteWebDriver driver, ExtentTest test){
		
		this.driver = driver;
		this.test = test;
		//if(!verifyTitle("Course Builder | Kaplan UK | Subjects")){
		//	reportStep("This is not Select your subjects Page", "FAIL");
		}
	

		//To Click Courses
	
	public KaplanHome_Page clickCourses()throws InterruptedException
	{
		 //Thread.sleep(5000);
		 clickBylinkText(objec.getProperty("Kaplan.Courses.Link"));
		 return this;
	}
     
	public KaplanHome_Page clickAtoZCourses()throws InterruptedException
	{
		 //Thread.sleep(5000);
		 clickBylinkText(objec.getProperty("Kaplan.AtoZCourses.Link"));
		 return this;
	}
	
	public SelectSubjects_Page clickAtoZCourseAATFoundation()throws InterruptedException
	{
		 //Thread.sleep(5000);
		 clickBylinkText(objec.getProperty("Kaplan.AATFoundation.Link"));
		 return new SelectSubjects_Page(driver,test);
	}
	
	public ExamSelectCourse_Page ClickBookAnExam()throws InterruptedException
	{
		 clickBylinkText(objec.getProperty("Kaplan.BookAnExam.Link"));
		 return new ExamSelectCourse_Page(driver, test);
	}
	
	


}
