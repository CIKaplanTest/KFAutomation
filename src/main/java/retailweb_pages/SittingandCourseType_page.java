package retailweb_pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import studentcenter_pages.CompleteRegistration_Page;
import studentcenter_pages.Login_Page;
import wrappers.KaplanSpecificWrappers;

public class SittingandCourseType_page  extends KaplanSpecificWrappers{
	public SittingandCourseType_page(RemoteWebDriver driver, ExtentTest test){

		this.driver = driver;
		this.test = test;

		//if(!verifyTitle("Course Builder | Kaplan UK | Basket")){
		//reportStep("This is not AccountHome Page", "FAIL");}
	}
/*	//Click on Sitting Random Dates
	public Selectsubjectteditstudyoptions_Page selectSittingDate()
	{
		List<WebElement> date = driver.findElements(By.className("radio-label"));
		
		Random rand = new Random();
		int randomProduct = rand.nextInt(date.size());
		System.out.println("Print"+randomProduct);
		if (date.size() > 1)
		{
		date.get(randomProduct).click();
		}
		System.out.println("Print"+ date.get(randomProduct));
		return new Selectsubjectteditstudyoptions_Page(driver, test);
	}
	//Select Continue in Sittings
	public Selectsubjectteditstudyoptions_Page sittingDateclickContinue()
	{
		
		clickByXpath(objec.getProperty("Sitting.Continue.Xpath"));
		if(verifyTitleContains("Select a course type for")) 
		{			
			selectCourseTypes();
		}
				
		return new Selectsubjectteditstudyoptions_Page(driver,test);
	}
*/
	

	//To Select Course Type  - Tution
	public SittingandCourseType_page selectCourseTypeTution()
	{
		clickById(objec.getProperty("CourseType.Tution.Id"));
		return this;
	}

	//To Select Course Type  - Revision
	public SittingandCourseType_page selectCourseTypeRevision()
	{
		clickById(objec.getProperty("CourseType.Revision.Id"));
		return this;
	}
	//To Select Course Type  - Question Based Day
	public SittingandCourseType_page selectCourseTypeQBD()
	{
		clickById(objec.getProperty("CourseType.QBD.Id"));
		return this;
	}

	//To Select Course Type  - Select All CourseType
	public SittingandCourseType_page selectAllCourseType()
	{
		clickById(objec.getProperty("CourseType.SelectAll.Id"));
		return this;
	}
	
	//Click Continue on CourseType
	public Selectsubjectteditstudyoptions_Page courseTypeContinue()
	{
		clickById(objec.getProperty("CourseType.Continue.Id"));
		return new Selectsubjectteditstudyoptions_Page(driver, test);
	}
	
	
}
