package Packages_Pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import retailweb_pages.Basket_page;
import wrappers.KaplanSpecificWrappers;

public class StudyOptions_Page extends KaplanSpecificWrappers 
{
	public StudyOptions_Page(RemoteWebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
	}
	
	public StudyOptions_Page ExpandSelectedPackageAccordion() 
	{
		clickByClassName(objec.getProperty("Packages.PackageAccordion.Class"));
		return this;
	}
	
	public StudyOptions_Page SelectStudyMethods() 
	{
		if(IsElementExistsByXpath(objec.getProperty("Packages.TuitionStartDateButton.Xpath")))
		{
			SelectStartDateAndClickContinueByXPath(objec.getProperty("Packages.TuitionStartDateButton.Xpath"));
		}
		
		if(IsElementExistsByXpath(objec.getProperty("Packages.RevisionStartDateButton.Xpath")))
		{
			SelectStartDateAndClickContinueByXPath(objec.getProperty("Packages.RevisionStartDateButton.Xpath"));
		}
		
		if(IsElementExistsByXpath(objec.getProperty("Packages.SchweserMockStartDateButton.Xpath")))
		{
			SelectMockExamAndClickContinue();
		}
		
		if(IsElementExistsByXpath(objec.getProperty("Packages.OptionalCourseExtrasStartDateButton.Xpath")))
		{
			SelectOptionalCourseOptionsAndClickContinue();
		}
		return this;
	}
	
	public void SelectStartDateAndClickContinueByXPath(String Xpath)
	{
		clickByXpath(Xpath);
		clickRandomByXpath(objec.getProperty("Packages.StartDateSelection.Xpath"));
		clickById(objec.getProperty("Packages.StartDateContinueButton.ID"));
	}
	
	public void SelectMockExamAndClickContinue()
	{
		clickByXpath(objec.getProperty("Packages.SchweserMockStartDateButton.Xpath"));
		clickRandomByXpath(objec.getProperty("Packages.MockExamTypes.Xpath"));
		clickById(objec.getProperty("Packages.MockExamTypeContinueButton.ID"));
	}
	
	public void SelectOptionalCourseOptionsAndClickContinue()
	{
		clickByXpath(objec.getProperty("Packages.OptionalCourseExtrasStartDateButton.Xpath"));
		clickRandomByXpath(objec.getProperty("Packages.OptionalCourseItems.Xpath"));
		clickById(objec.getProperty("Packages.OptionalCourseContinueButton.ID"));
	}
	
	public Basket_page ClickOnAddToBasket()
	{
		clickById(objec.getProperty("Packages.AddToBasketButton.ID"));
		return new Basket_page(driver, test);
	}
}
