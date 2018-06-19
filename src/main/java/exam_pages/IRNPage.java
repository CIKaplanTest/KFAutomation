package exam_pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import retailweb_pages.DeliveryAddress_Page;
import wrappers.KaplanSpecificWrappers;

public class IRNPage extends KaplanSpecificWrappers
{
	public IRNPage(RemoteWebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
		if(!verifyTitleContains("InstituteRegistrationNumber"))
		  {
		     reportStep("This is not InstituteRegistrationNumber", "FAIL");
		  }
	}

	public IRNPage verifyPageHeading() 
	{
	   verifyTextByClass(objec.getProperty("IRN.PageHeading.Class"), "Institute Registration Number");
	   return this;
	}
	
	public IRNPage InsertOrVerifyIRNNumber(String IRN)
	{
		EnterDataByIdIfValueNotExists(objec.getProperty("IRN.NumberText.Id"), IRN);
		return this;
	}
	
	public IRNPage SelectDOBDetails() 
	{
		RandomDropDownSelectionById(objec.getProperty("IRN.DOBDay.Id"));
		RandomDropDownSelectionById(objec.getProperty("IRN.DOBMonth.Id"));
		RandomDropDownSelectionById(objec.getProperty("IRN.DOBYear.Id"));
		return this;
	}
	
	public IRNPage CheckIfDontHaveIRNNumber()
	{
		clickByXpath(objec.getProperty("IRN.CheckIfNotHaveIRN.Xpath"));
		return this;
	}
	
	public IRNPage InsertOrVerifyMobileNumber(String mobileNumber)
	{
		EnterDataByIdIfValueNotExists(objec.getProperty("IRN.MobileNumber.Id"), mobileNumber);
		return this;
	}
	
	public IRNPage InsertOrVerifyWorkNumber(String workNumber)
	{
		EnterDataByIdIfValueNotExists(objec.getProperty("IRN.WorkNumber.Id"), workNumber);
		return this;
	}
	
	public DeliveryAddress_Page ClickContinue() 
	{
		clickById(objec.getProperty("IRN.ContinueButton.Id"));
		return new DeliveryAddress_Page(this.driver, this.test);
	}
}
