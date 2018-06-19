package retailweb_pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KaplanSpecificWrappers;
import retailweb_pages.*;

public class SelectStartDate_Page extends KaplanSpecificWrappers{

	//Confirming that we are in Start Date Page

	public SelectStartDate_Page(RemoteWebDriver driver, ExtentTest test){

		this.driver = driver;
		this.test = test;

		if(!verifyTitleContains("Course Builder | Kaplan UK | Start date")){
					reportStep("This is not Select a start Date Page", "FAIL");
				}
	}
	
	//To verify the paper is displayed in header
	
	public SelectStartDate_Page verifyPaperHeading() throws InterruptedException
	{
		//String paperText= Selectsubjectteditstudyoptions_Page.this.paperText1.toString();
		Selectsubjectteditstudyoptions_Page page= new Selectsubjectteditstudyoptions_Page(driver,test);
	    page.paper1Text();
		String paperText=page.paperText1;
        verifyTextByXPath(objec.getProperty("SelectSubjectChooseStartDate.Paperheader.Class"), paperText);
		return this;
	}
	
	//// To select start date of first subject
	public SelectStartDate_Page CourseTypeStartDates()
	{
		
			List<WebElement> Startdate =driver.findElements(By.className("radio-label"));
			Random rn = new Random();
		    int rand = rn.nextInt(Startdate.size()==1 ? 1 :Startdate.size()-1);
		    Startdate.get(rand).click();
		    return this;
		}
	
	
	
	// To select start date of first subject
	public SelectStartDate_Page chooseStartDateOne ()
	{
		try {
			List<WebElement> date =driver.findElements(By.className("radio-label"));
			date.get(0).click();
			String dateone = driver.findElementById((objec.getProperty("SelectStartDate.StartDateOne.xpath"))).getText();
			String actualdate = dateone.substring(0,5);
			System.out.println("The Substring value" +actualdate);
			reportStep("The date is found.", "PASS");

		} catch (Exception e) {
			reportStep("The date could not be found.", "FAIL");
		}
		return this;
	}

	// To select start date of second subject
	public SelectStartDate_Page chooseStartDateTwo ()
	{
		try {
			
			List<WebElement> date =driver.findElements(By.className("radio-label"));
			date.get(1).click();
			reportStep("The date is found.", "PASS");

		} catch (Exception e) {
			reportStep("The date could not be found.", "FAIL");
		}
		return this;
	}

	// To select start date of third subject
	public SelectStartDate_Page chooseStartDateThree ()
	{
		try {
			List<WebElement> date =driver.findElements(By.name("radStartDate"));
			
			date.get(2).click();
			reportStep("The date is found.", "PASS");

		} catch (Exception e) {
			reportStep("The date could not be found.", "FAIL");
		}
		return this;
	}

	// To select start date of fourth subject

	public SelectStartDate_Page chooseStartDateFour ()
	{
		try {
			List<WebElement> date =driver.findElements(By.name("radStartDate"));
			date.get(3).click();
			reportStep("The date is found.", "PASS");

		} catch (Exception e) {
			reportStep("The date could not be found.", "FAIL");
		}
		return this;
	}

	// To select start date of fifth subject
	public SelectStartDate_Page chooseStartDateFive ()
	{
		try {
			List<WebElement> date =driver.findElements(By.name("radStartDate"));
			date.get(4).click();
			reportStep("The date is found.", "PASS");

		} catch (Exception e) {
			reportStep("The date could not be found.", "FAIL");
		}
		return this;
	}

	// To select start date of sixth subject

	public SelectStartDate_Page chooseStartDateSix ()
	{
		try {
			List<WebElement> date =driver.findElements(By.name("radStartDate"));
			date.get(5).click();
			reportStep("The date is found.", "PASS");

		} catch (Exception e) {
			reportStep("The date could not be found.", "FAIL");
		}
		return this;
	}

	// To click on continue button
	public Selectsubjectteditstudyoptions_Page clickContinue()
	{
		clickById(objec.getProperty("SelectStartDate.Continue.ID"));
		return new Selectsubjectteditstudyoptions_Page(driver, test);
	}

}

