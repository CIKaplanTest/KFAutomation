package retailweb_pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import wrappers.KaplanSpecificWrappers;

public  class Selectsubjectteditstudyoptions_Page extends KaplanSpecificWrappers {

	public String paperText1,pap1amt,pap2amt,pap3amt,pap4amt,pap5amt,pap6amt,pap7amt;

	public Selectsubjectteditstudyoptions_Page(RemoteWebDriver driver, ExtentTest test){

		this.driver = driver;
		this.test = test;

		//if(!verifyTitle("Course Builder | Kaplan UK | Subject summary")){
		//reportStep("This is not Subject Summary Page", "FAIL");
	}
	//To verify the edit page label

	public Selectsubjectteditstudyoptions_Page verifyEditPageLabel (String label)
	{
		verifyTextByClass(objec.getProperty("EditStudyOptions.clickAccordion1.Class"),label);
		return this;
	}

	//To verify the Total Amount

	public Selectsubjectteditstudyoptions_Page verifySubTotal (String tot)
	{
		verifyTextByClass(objec.getProperty("EditStudyOptions.clickAccordion1.Class"),tot);
		return this;
	}
	//To verify the Paper1 Amount

	/*public Selectsubjectteditstudyoptions_Page getpaper1amount ()
				{
					 pap1amt=getTextByClass(objec.getProperty("EditStudyOptions.clickAccordion1.Class"));
					 return this;
				}*/

	//To click on Choose Study Method of Paper1

	public ChooseStudyMethod_Page clickChooseStudyMethodPaper1()
	{
		try {
			clickById(objec.getProperty("EditStudyOptions.ChooseStudyMethodPaper1.ID"));
			reportStep("The element is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element could not be clicked.", "FAIL");
		}
		return new ChooseStudyMethod_Page(driver, test);
	}

	//To click on Choose Study Method of Paper2

	public ChooseStudyMethod_Page clickChooseStudyMethodPaper2()
	{
		try {
			clickById(objec.getProperty("EditStudyOptions.ChooseStudyMethodPaper2.ID"));
			reportStep("The element is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element could not be clicked.", "FAIL");
		}
		return new ChooseStudyMethod_Page(driver, test);
	}

	//To click on Choose Study Method of Paper3

	public ChooseStudyMethod_Page clickChooseStudyMethodPaper3()
	{
		try {
			clickById(objec.getProperty("EditStudyOptions.ChooseStudyMethodPaper3.ID"));
			reportStep("The element is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element could not be clicked.", "FAIL");
		}
		return new ChooseStudyMethod_Page(driver, test);
	}
	//To click on Choose Study Method of Paper4

	public ChooseStudyMethod_Page clickChooseStudyMethodPaper4()
	{
		try {
			clickById(objec.getProperty("EditStudyOptions.ChooseStudyMethodPaper4.ID"));
			reportStep("The element is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element could not be clicked.", "FAIL");
		}
		return new ChooseStudyMethod_Page(driver, test);
	}

	//To click on Choose Study Method of Paper5

	public ChooseStudyMethod_Page clickChooseStudyMethodPaper5()
	{
		try {
			clickById(objec.getProperty("EditStudyOptions.ChooseStudyMethodPaper5.ID"));
			reportStep("The element is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element could not be clicked.", "FAIL");
		}
		return new ChooseStudyMethod_Page(driver, test);
	}

	//To click on Choose Study Method of Paper6

	public ChooseStudyMethod_Page clickChooseStudyMethodPaper6()
	{
		try {
			clickById(objec.getProperty("EditStudyOptions.ChooseStudyMethodPaper6.ID"));
			reportStep("The element is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element could not be clicked.", "FAIL");
		}
		return new ChooseStudyMethod_Page(driver, test);
	}

	//To click on Choose Study Method of Paper7

	public ChooseStudyMethod_Page clickChooseStudyMethodPaper7()
	{
		try {
			clickById(objec.getProperty("EditStudyOptions.ChooseStudyMethodPaper7.ID"));
			reportStep("The element is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element could not be clicked.", "FAIL");
		}
		return new ChooseStudyMethod_Page(driver, test);
	}
	//To click on Choose Study Method of Paper8

	public ChooseStudyMethod_Page clickChooseStudyMethodPaper8()
	{
		try {
			clickById(objec.getProperty("EditStudyOptions.ChooseStudyMethodPaper8.ID"));
			reportStep("The element is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element could not be clicked.", "FAIL");
		}
		return new ChooseStudyMethod_Page(driver, test);
	}
	//To click on Choose Study Method of Paper9

	public ChooseStudyMethod_Page clickChooseStudyMethodPaper9()
	{
		try {
			clickById(objec.getProperty("EditStudyOptions.ChooseStudyMethodPaper9.ID"));
			reportStep("The element is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element could not be clicked.", "FAIL");
		}
		return new ChooseStudyMethod_Page(driver, test);
	}
	//To click on Choose Study Method of Paper10

	public ChooseStudyMethod_Page clickChooseStudyMethodPaper10()
	{
		try {
			clickById(objec.getProperty("EditStudyOptions.ChooseStudyMethodPaper10.ID"));
			reportStep("The element is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element could not be clicked.", "FAIL");
		}
		return new ChooseStudyMethod_Page(driver, test);
	}

	public SelectStartDate_Page clickChooseStartDateOne() throws InterruptedException
	{
		Thread.sleep(2000);
		clickById(objec.getProperty("SelectSubjectChooseStartDate.ChooseStartDateOne.ID"));
		return new SelectStartDate_Page(driver,test);
	}
	public SelectStartDate_Page clickChooseStartDateTwo() throws InterruptedException
	{
		Thread.sleep(5000);
		clickById(objec.getProperty("SelectSubjectChooseStartDate.ChooseStartDateTwo.ID"));
		return new SelectStartDate_Page(driver,test);
	}

	public SelectStartDate_Page clickChooseStartDateThree() throws InterruptedException
	{
		Thread.sleep(5000);
		clickById(objec.getProperty("SelectSubjectChooseStartDate.ChooseStartDateThree.ID"));
		return new SelectStartDate_Page(driver,test);
	}

	public SelectStartDate_Page clickChooseStartDateFour() throws InterruptedException
	{
		Thread.sleep(5000);
		clickById(objec.getProperty("SelectSubjectChooseStartDate.ChooseStartDateFour.ID"));
		return new SelectStartDate_Page(driver,test);
	}

	public SelectStartDate_Page clickChooseStartDateFive() throws InterruptedException
	{
		Thread.sleep(5000);
		clickById(objec.getProperty("SelectSubjectChooseStartDate.ChooseStartDateFive.ID"));
		return new SelectStartDate_Page(driver,test);
	}


	public SelectStartDate_Page clickChooseStartDateSix() throws InterruptedException
	{
		Thread.sleep(5000);
		clickById(objec.getProperty("SelectSubjectChooseStartDate.ChooseStartDateSix.ID"));
		return new SelectStartDate_Page(driver,test);
	}



	//To click on Add to Basket Button

	public Basket_page clickAddtoBasket() throws InterruptedException
	{
		Thread.sleep(2000);
		if (driver.findElement(By.id(objec.getProperty("EditStudyOptions.AddToBasket.ID"))).isDisplayed() && driver.findElement(By.id(objec.getProperty("EditStudyOptions.AddToBasket.ID"))).isEnabled())
		{
			clickById(objec.getProperty("EditStudyOptions.AddToBasket.ID"));
		}
		return new Basket_page(driver,test);
	}

	//To expand paper1 accordion

	public Selectsubjectteditstudyoptions_Page expandPaper1() throws InterruptedException
	{
		//Thread.sleep(2000);
		// paperText1=driver.findElementByXPath(objec.getProperty("EditStudyOptions.clickAccordion1.Xpath")).getText();
		clickByXpath(objec.getProperty("EditStudyOptions.clickAccordion1.Xpath"));
		return this;
	}
	public Selectsubjectteditstudyoptions_Page paper1Text() throws InterruptedException
	{
		Thread.sleep(2000);
		String papnum=driver.findElementByXPath(objec.getProperty("EditStudyOptions.Paper1Number.Class")).getText();
		String papname=driver.findElementByXPath(objec.getProperty("EditStudyOptions.Paper1Name.Class")).getText();
		paperText1=papnum+". "+papname;
		return this;
	}

	//To expand paper2 accordion

	public Selectsubjectteditstudyoptions_Page expandPaper2() throws InterruptedException
	{
		Thread.sleep(5000);
		clickByXpath(objec.getProperty("EditStudyOptions.clickAccordion2.Xpath"));
		return this;
	}

	//To expand paper3 accordion

	public Selectsubjectteditstudyoptions_Page expandPaper3() throws InterruptedException
	{
		Thread.sleep(5000);
		clickByXpath(objec.getProperty("EditStudyOptions.clickAccordion3.Xpath"));
		return this;
	}

	//To expand paper4 accordion

	public Selectsubjectteditstudyoptions_Page expandPaper4() throws InterruptedException
	{
		Thread.sleep(5000);
		clickByXpath(objec.getProperty("EditStudyOptions.clickAccordion4.Xpath"));
		return this;
	}
	//To expand paper5 accordion

	public Selectsubjectteditstudyoptions_Page expandPaper5() throws InterruptedException
	{
		Thread.sleep(5000);
		clickByXpath(objec.getProperty("EditStudyOptions.clickAccordion5.Xpath"));
		return this;
	}
	//To expand paper6 accordion

	public Selectsubjectteditstudyoptions_Page expandPaper6() throws InterruptedException
	{
		Thread.sleep(5000);
		clickByXpath(objec.getProperty("EditStudyOptions.clickAccordion6.Xpath"));
		return this;
	}
	//To expand paper7 accordion

	public Selectsubjectteditstudyoptions_Page expandPaper7() throws InterruptedException
	{
		Thread.sleep(5000);
		clickByXpath(objec.getProperty("EditStudyOptions.clickAccordion7.Xpath"));
		return this;
	}
	//To expand paper8 accordion

	public Selectsubjectteditstudyoptions_Page expandPaper8() throws InterruptedException
	{
		Thread.sleep(5000);
		clickByXpath(objec.getProperty("EditStudyOptions.clickAccordion8.Xpath"));
		return this;
	}
	//To expand paper9 accordion

	public Selectsubjectteditstudyoptions_Page expandPaper9() throws InterruptedException
	{
		Thread.sleep(5000);
		clickByXpath(objec.getProperty("EditStudyOptions.clickAccordion9.Xpath"));
		return this;
	}
	//To expand paper10 accordion

	public Selectsubjectteditstudyoptions_Page expandPaper10() throws InterruptedException
	{
		Thread.sleep(5000);
		clickByXpath(objec.getProperty("EditStudyOptions.clickAccordion10.Xpath"));
		return this;
	}

	//To Collapse Paper1 accordion
	public Selectsubjectteditstudyoptions_Page collapsePaper1(String studyMethodClassroom, String actualLocationOne, String actualdate, String studyMethodLiveOnline, String studyMethodOnDemand, String studyMethodDistanceLearning) throws InterruptedException
	{
		try {
			Thread.sleep(5000);
			clickById(objec.getProperty("EditStudyOptions.collapseAccordion1.ID"));
			String finalSelection =driver.findElementByClassName((objec.getProperty("SelectSubjectChooseStartDate.selected-location-date.Class"))).getText();
			String verifyCR = studyMethodClassroom+ "." +actualLocationOne+ "."+actualdate;
			String verifyLOL = studyMethodLiveOnline+"."+actualdate;
			String verifyOnDmnd = studyMethodOnDemand;
			String verifyDL = studyMethodDistanceLearning;

			if(verifyCR.contentEquals(finalSelection))
			{ 
				reportStep("The selected-ClassRoomLocationDate is matched", "PASS");
			}
			else if (verifyLOL.contentEquals(finalSelection))
			{ 
				reportStep("The selected-LiveOnline and Date is matched", "PASS");
			}
			else if (verifyOnDmnd.contentEquals(finalSelection))
			{ 
				reportStep("The selected-studyMethodOnDemand is matched", "PASS");
			}
			else if(verifyDL.contentEquals(finalSelection))
			{ 
				reportStep("The selected-studyMethodDistanceLearning is matched", "PASS");
			}
			else
			{
				reportStep("The selected-studyMethodis not matched", "FAIL");
			}

		} catch (Exception e) {

			reportStep("Unknown exception occured while verifying the Selection", "FAIL");

		}
		return this;
	}













	//To remove paper 1

	public Selectsubjectteditstudyoptions_Page removePaper1() throws InterruptedException
	{
		clickById(objec.getProperty("EditStudyOptions.RemoveSubject1.ID"));
		return this;
	}
	//To remove paper 2

	public Selectsubjectteditstudyoptions_Page removePaper2() throws InterruptedException
	{
		clickById(objec.getProperty("EditStudyOptions.RemoveSubject2.ID"));
		return this;
	}
	//To remove paper 3

	public Selectsubjectteditstudyoptions_Page removePaper3() throws InterruptedException
	{
		clickById(objec.getProperty("EditStudyOptions.RemoveSubject3.ID"));
		return this;
	}
	//To edit paper 1

	public ChooseStudyMethod_Page editPaper1() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objec.getProperty("EditStudyOptions.Edit1.Xpath"))));
		clickByXpath(objec.getProperty("EditStudyOptions.Edit1.Xpath"));
		return new ChooseStudyMethod_Page(driver, test);
	}
	//To edit paper 2

	public ChooseStudyMethod_Page editPaper2() throws InterruptedException
	{
		clickByXpath(objec.getProperty("EditStudyOptions.Edit2.Xpath"));
		return new ChooseStudyMethod_Page(driver, test);
	}
	//To edit paper 3

	public ChooseStudyMethod_Page editPaper3() throws InterruptedException
	{
		clickByXpath(objec.getProperty("EditStudyOptions.Edit3.Xpath"));
		return new ChooseStudyMethod_Page(driver, test);
	}
	//To edit paper 4

	public ChooseStudyMethod_Page editPaper4() throws InterruptedException
	{
		clickByXpath(objec.getProperty("EditStudyOptions.Edit4.Xpath"));
		return new ChooseStudyMethod_Page(driver, test);
	}
	//Edit Date Paper1

	public SelectStartDate_Page editDatePaper1() throws InterruptedException
	{
		Thread.sleep(2000);
		clickByXpath(objec.getProperty("EditStudyOptions.EditDatePaper1.Xpath"));
		return new SelectStartDate_Page(driver, test);
	}
	//Edit Date Paper2

	public SelectStartDate_Page editDatePaper2() throws InterruptedException
	{
		clickByXpath(objec.getProperty("EditStudyOptions.EditDatePaper2.Xpath"));
		return new SelectStartDate_Page(driver, test);
	}


	// To click on continue button from Start date window
		public Selectsubjectteditstudyoptions_Page clickContinue()
		{
			clickById(objec.getProperty("SelectStartDate.Continue.ID"));
			return new Selectsubjectteditstudyoptions_Page(driver, test);
		}
	}

