package retailweb_pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KaplanSpecificWrappers;

public class ChooseStudyMethod_Page extends KaplanSpecificWrappers {

	//Confirming that we are in Choose Study Method Page

	public ChooseStudyMethod_Page(RemoteWebDriver driver, ExtentTest test){

		this.driver = driver;
		this.test = test;

		//if(!verifyTitleContains("Course Builder | Kaplan UK | Study method")){
		//			reportStep("This is not Choose Study Method Page", "FAIL");
		//	}
	}

	//To Select a classroom study method for Selected Subjects
	public ChooseStudyMethod_Page chooseStudyMethodClassroom()
	{
		try {
			clickByXpath(objec.getProperty("SelectAStudyMethod.Classroom.Xpath"));
//			String classroom =  driver.findElementById((objec.getProperty("SelectAStudyMethod.Classroom.ID"))).getText();
//			String studyMethodClassroom = classroom.substring(0,5);
//			System.out.println("The Substring value" +studyMethodClassroom);

			reportStep("The element is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element could not be clicked.", "FAIL");
		}
		return this;

	}

	//To Select Location1 Under Classroom
	public Selectsubjectteditstudyoptions_Page selectLocationOne()
	{
		try {
			clickByXpath(objec.getProperty("SelectAStudyMethod.Locationone.Xpath"));
			//	String locationOne =  driver.findElementByXPath((objec.getProperty("SelectAStudyMethod.Locationone.Xpath"))).getText();
			//	String actualLocationOne = locationOne.substring(0,5);
			//	System.out.println("The Substring value" +actualLocationOne);
			reportStep("The element is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element could not be clicked.", "FAIL");
		}
		return new Selectsubjectteditstudyoptions_Page(driver, test);

	}
	//To Select Location2 Under Classroom
	public Selectsubjectteditstudyoptions_Page selectLocationTwo()
	{
		try {
			clickByXpath(objec.getProperty("SelectAStudyMethod.Locationtwo.Xpath"));
			//String locationTwo =  driver.findElementByXPath((objec.getProperty("SelectAStudyMethod.Locationtwo.Xpath"))).getText();
			//String actualLocationTwo = locationTwo.substring(0,5);
			//System.out.println("The Substring value" +actualLocationTwo);
			reportStep("Location two is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element could not be clicked.", "FAIL");
		}
		return new Selectsubjectteditstudyoptions_Page(driver, test);

	}
	//To Select Location3 Under Classroom
	public Selectsubjectteditstudyoptions_Page selectLocationThree()
	{
		try {
			clickByXpath(objec.getProperty("SelectAStudyMethod.Locationthree.Xpath"));

			reportStep("The element is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element could not be clicked.", "FAIL");
		}
		return new Selectsubjectteditstudyoptions_Page(driver, test);

	}

	//To Select Location4 Under Classroom
	public Selectsubjectteditstudyoptions_Page selectLocationFour()
	{
		try {
			clickByXpath(objec.getProperty("SelectAStudyMethod.Locationfour.Xpath"));

			reportStep("The element is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element could not be clicked.", "FAIL");
		}
		return new Selectsubjectteditstudyoptions_Page(driver, test);

	}
	
	public Selectsubjectteditstudyoptions_Page selectRandomLocation()
	{
		try 
		{
			clickRandomByXpath(objec.getProperty("SelectAStudyMethod.RandomLocation.Xpath"));

			reportStep("The random element is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element could not be clicked.", "FAIL");
		}
		return new Selectsubjectteditstudyoptions_Page(driver, test);

	}

	//To Select a OnDemand study method for Selected Subjects
	public Selectsubjectteditstudyoptions_Page chooseStudyMethodOnDemand()
	{
		try {
			clickByXpath(objec.getProperty("SelectAStudyMethod.OnDemand.Xpath"));
			reportStep("The element is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element could not be clicked.", "FAIL");
		}
		return new Selectsubjectteditstudyoptions_Page(driver, test);

	}
	//To Select a LiveOnline study method for Selected Subjects
	public Selectsubjectteditstudyoptions_Page chooseStudyMethodLiveOnline()
	{
		try {
			clickByXpath(objec.getProperty("SelectAStudyMethod.LiveOnline.Xpath"));
			reportStep("The element is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element could not be clicked.", "FAIL");
		}
		return new Selectsubjectteditstudyoptions_Page(driver, test);

	}

	//To Select a DistanceLearning study method for Selected Subjects
	public Selectsubjectteditstudyoptions_Page chooseStudyMethodDistanceLearningPrinted()
	{
		try {
			clickByXpath(objec.getProperty("SelectAStudyMethod.DistanceLearning.Xpath"));
			if(verifyTitleContains("Course Builder | Kaplan UK | Study method")) 
			{
				clickPrinted();
			}
			
			reportStep("The element is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element could not be clicked.", "FAIL");
		}
		return new Selectsubjectteditstudyoptions_Page(driver, test);

	}
	public Selectsubjectteditstudyoptions_Page chooseStudyMethodDistanceLearningOnline()
	{
		try {
			clickByXpath(objec.getProperty("SelectAStudyMethod.DistanceLearning.Xpath"));
			if(verifyTitleContains("Course Builder | Kaplan UK | Study method")) 
			{
				clickOnline();
			}
		} catch (Exception e) {
			reportStep("The element could not be clicked.", "FAIL");
		}
		return new Selectsubjectteditstudyoptions_Page(driver, test);

	}

	// To click on Printed under distance learning
	public Selectsubjectteditstudyoptions_Page clickPrinted()
	{
		try {
			clickById(objec.getProperty("SelectAStudyMethod.DistanceLearningPrinted.ID"));
		} catch (Exception e) {
			reportStep("The element Printed could not be clicked.", "FAIL");
		}
		return new Selectsubjectteditstudyoptions_Page(driver, test);
	}
	// To click on Online under distance learning
	public Selectsubjectteditstudyoptions_Page clickOnline()
	{
		try {
			clickById(objec.getProperty("SelectAStudyMethod.DistanceLearningOnline.ID"));
		} catch (Exception e) {
			reportStep("The element Online could not be clicked.", "FAIL");
		}
		return new Selectsubjectteditstudyoptions_Page(driver, test);
	}

	//Classroom Study Method_Sitting, CourseType and StartDate Dynamic Selection 
	public Selectsubjectteditstudyoptions_Page chooseStudyMethodClassroom01() 
	{
		try {	
			
			chooseStudyMethodClassroom();
			selectRandomLocation();
			
			if(verifyTitleContains("Course Builder | Kaplan UK | Sitting")) 
			{
				List<WebElement> sittingDates = driver.findElements(By.className("radio-label"));
				Random rn = new Random();
				int size = sittingDates.size()==1 ? 1 :sittingDates.size()-1;
				int rand = rn.nextInt(size);
				sittingDates.get(rand).click();
				clickByXpath(objec.getProperty("Sitting.Continue.Xpath"));
			}

			if(verifyTitleContains("Course Builder | Kaplan UK | Subject summary")) 
			{		
				clickRandomByXpath(objec.getProperty("CourseType.RandomSelection.Xpath"));
				clickByXpath(objec.getProperty("CourseType.Continue.Xpath"));
				clickByXpath(objec.getProperty("SelectStartDate.ChooseStartDateButton.Xpath"));
			}
			else
			{
				return  new Selectsubjectteditstudyoptions_Page(driver, test);
			}

			if (verifyTitleContains("Course Builder | Kaplan UK | Subject summary"))
			{
				Selectsubjectteditstudyoptions_Page csd1 =new Selectsubjectteditstudyoptions_Page(driver,test);
				csd1.clickChooseStartDateOne();
				//clickById(objec.getProperty("SelectSubjectChooseStartDate.ChooseStartDateOne.ID"));
			}

			if(verifyTitleContains("Course Builder | Kaplan UK | Start date"))
			{
				SelectStartDate_Page ctsd= new SelectStartDate_Page(driver,test);
				clickRandomByXpath(objec.getProperty("SelectStartDate.StartDateSelection.Xpath"));
				//ctsd.CourseTypeStartDates();
				ctsd.clickContinue();
			}

		}catch (Exception e) {
			reportStep("The date could not be found.", "FAIL");
		}
		return  new Selectsubjectteditstudyoptions_Page(driver, test);
	}
	
	//
	public Selectsubjectteditstudyoptions_Page chooseStudyMethodLiveOnline01() 
	{
	try {		
			clickById(objec.getProperty("SelectAStudyMethod.LiveOnline.ID"));
					
			if(verifyTitleContains("Course Builder | Kaplan UK | Sitting")) 
			{
				List<WebElement> date = driver.findElements(By.className("radio-label"));
				Random rn = new Random();
				int rand = rn.nextInt(date.size()-1);
				date.get(rand).click();
				clickByXpath(objec.getProperty("Sitting.Continue.Xpath"));
			}else {
				return  new Selectsubjectteditstudyoptions_Page(driver, test);
			}

			if(verifyTitleContains("Course Builder | Kaplan UK | Subject summary")) 
			{		
//				CourseType_page ct=new CourseType_page(driver,test);
//				/*ct.selectCourseTypes();*/
//									ct.selectCourseTypeRevision();
//									ct.courseTypeContinue();
//				/*clickByXpath(objec.getProperty("CourseType.Revision.Xpath"));
//				clickByXpath(objec.getProperty("CourseType.Continue.Xpath"));*/
			}else {
				return  new Selectsubjectteditstudyoptions_Page(driver, test);
			}

			if (verifyTitleContains("Course Builder | Kaplan UK | Subject summary"))
			{
				Selectsubjectteditstudyoptions_Page csd1 =new Selectsubjectteditstudyoptions_Page(driver,test);
				csd1.clickChooseStartDateOne();
				//clickById(objec.getProperty("SelectSubjectChooseStartDate.ChooseStartDateOne.ID"));
			}

			if(verifyTitleContains("Course Builder | Kaplan UK | Start date"))
			{
				SelectStartDate_Page ctsd= new SelectStartDate_Page(driver,test);
				ctsd.CourseTypeStartDates();
				ctsd.clickContinue();
			}
	}
		
 catch (Exception e) {
			reportStep("The date could not be found.", "FAIL");
}
		return  new Selectsubjectteditstudyoptions_Page(driver, test);
	}
	
	public Selectsubjectteditstudyoptions_Page chooseStudyMethodDistanceLearningO() 
	 {
	  try
	  { 

	   clickByXpath(objec.getProperty("SelectAStudyMethod.DistanceLearning.Xpath"));
	   if(verifyTitleContains("Course Builder | Kaplan UK | Study method")) 
	   {
	    clickOnline();
	   }
	    
	   if(verifyTitleContains("Course Builder | Kaplan UK | Sitting")) 
	   {
	    if (driver.findElement(By.className(objec.getProperty("Sittings.SitingDate.Class"))).isDisplayed() && (driver.findElement(By.className(objec.getProperty("Sittings.SitingDate.Class"))).isEnabled()))
	    {
	     clickByXpath(objec.getProperty("Sitting.Continue.Xpath"));
	    }
	    else 
	    {
	     List<WebElement> date = driver.findElements(By.className("radio-label"));
	     Random rn = new Random();
	     int rand = rn.nextInt(date.size()-1);
	     date.get(rand).click();
	     clickByXpath(objec.getProperty("Sitting.Continue.Xpath"));
	    }
	   }

	  }
	  catch (Exception e) 
	  {
	   reportStep("The date could not be found.", "FAIL");
	  }
	  return  new Selectsubjectteditstudyoptions_Page(driver, test);
	 }
	
	public Selectsubjectteditstudyoptions_Page chooseStudyMethodDistanceLearningP() 
	 {
	  try
	  { 

	   clickByXpath(objec.getProperty("SelectAStudyMethod.DistanceLearning.Xpath"));
	   if(verifyTitleContains("Course Builder | Kaplan UK | Study method")) 
	   {
	    clickPrinted();
	   }
	    
	   if(verifyTitleContains("Course Builder | Kaplan UK | Sitting")) 
	   {
	    if (driver.findElement(By.className(objec.getProperty("Sittings.SitingDate.Class"))).isDisplayed() && (driver.findElement(By.className(objec.getProperty("Sittings.SitingDate.Class"))).isEnabled()))
	    {
	     clickByXpath(objec.getProperty("Sitting.Continue.Xpath"));
	    }
	    else 
	    {
	     List<WebElement> date = driver.findElements(By.className("radio-label"));
	     Random rn = new Random();
	     int rand = rn.nextInt(date.size()-1);
	     date.get(rand).click();
	     clickByXpath(objec.getProperty("Sitting.Continue.Xpath"));
	    }
	   }

	  }
	  catch (Exception e) 
	  {
	   reportStep("The date could not be found.", "FAIL");
	  }
	  return  new Selectsubjectteditstudyoptions_Page(driver, test);
	 }
	
}








