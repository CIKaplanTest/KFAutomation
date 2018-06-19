package Packages_Pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KaplanSpecificWrappers;

public class Packages_Page extends KaplanSpecificWrappers
{
	public Packages_Page(RemoteWebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
		verifyTitleContains("Packagespage");
	}
	
	public Packages_Page VerifyPackageHeader()
	{
		verifyTextByClass(objec.getProperty("Packages.TitleHeader.Class"), "Choose package");
		return this;
	}
	
	// Blended Enhanced Region
	public Packages_Page ClickToExpandBlendedEnhancedAccordion()
	{
		clickByXpath(objec.getProperty("Packages.BlendedEnhancedAccordion.Xpath"));
		return this;
	}
	
	public PackageSitting_Page ChooseRandomLocationForBlendedEnhanced()
	{
		clickRandomByXpath(objec.getProperty("Packages.BlendedEnhancedLocations.Xpath"));
		return new PackageSitting_Page(driver, test);
	}
	
	//ClassRoom Enhanced Region
	public Packages_Page ClickToExpandClassRoomEnhancedAccordion()
	{
		clickByXpath(objec.getProperty("Packages.BlendedEnhancedAccordion.Xpath"));
		return this;
	}
	
	public PackageSitting_Page ChooseRandomLocationForClassRoomEnhanced()
	{
		clickRandomByXpath(objec.getProperty("Packages.BlendedEnhancedLocations.Xpath"));
		return new PackageSitting_Page(driver, test);
	}
	
	//TuitionPlus Region
	public Packages_Page ClickToExpandTuitionPlusAccordion()
	{
		clickByXpath(objec.getProperty("Packages.BlendedEnhancedAccordion.Xpath"));
		return this;
	}
			
	public PackageSitting_Page ChooseRandomLocationForTuitionPlus()
	{
		clickRandomByXpath(objec.getProperty("Packages.BlendedEnhancedLocations.Xpath"));
		return new PackageSitting_Page(driver, test);
	}
		
	
}
