package Packages_Pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KaplanSpecificWrappers;

public class PackageSitting_Page extends KaplanSpecificWrappers
{
	public PackageSitting_Page(RemoteWebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
	}
	
	public StudyOptions_Page SelectRandomSitting()
	{
		clickRandomByClassName(objec.getProperty("Packages.SittingSelection.Class"));
		clickByXpath(objec.getProperty("Packages.ContinueButton.Xpath"));
		return new StudyOptions_Page(driver, test);
	}
}
