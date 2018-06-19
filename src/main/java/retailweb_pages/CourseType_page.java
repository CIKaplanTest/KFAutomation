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

public class CourseType_page  extends KaplanSpecificWrappers{
	public CourseType_page(RemoteWebDriver driver, ExtentTest test){

		this.driver = driver;
		this.test = test;

		//if(!verifyTitle("Course Builder | Kaplan UK | Basket")){
		//reportStep("This is not AccountHome Page", "FAIL");}
	}

	//To Select Course Type  - selectCourseTypes with condition 
	public CourseType_page selectCourseTypes()
	{
				{List<WebElement> CourseType = driver.findElements(By.className("checkbox-label"));
				Random rn = new Random();
				int rand = rn.nextInt(CourseType.size()-1);
				CourseType.get(rand).click();
				
				}
	return this;
}
	/*if(driver.getPageSource().contains("Tuition"))
		{
			clickByXpath(objec.getProperty("CourseType.Tution.Xpath"));
		}
		else if (driver.getPageSource().contains("Revision"))
		{
			clickByXpath(objec.getProperty("CourseType.Revision.Xpath"));
		}
		else if (driver.getPageSource().contains("QBD"))
		{
			clickByXpath(objec.getProperty("CourseType.QBD.Xpath"));
		}
		else
		{
			reportStep("There is no selection made for course type", "FAIL");
		}
		return this;
	}    
*/
	
	//To Select Course Type  - Tution
	public CourseType_page selectCourseTypeTution()
	{
		clickByXpath(objec.getProperty("CourseType.Tution.Xpath"));
		return this;
	}

	//To Select Course Type  - Revision
	public CourseType_page selectCourseTypeRevision()
	{
		clickByXpath(objec.getProperty("CourseType.Revision.Xpath"));
		return this;
	}
	//To Select Course Type  - Question Based Day
	public CourseType_page selectCourseTypeQBD()
	{
		clickByXpath(objec.getProperty("CourseType.QBD.Xpath"));
		return this;
	}

	//To Select Course Type  - Select All CourseType
	public CourseType_page selectAllCourseType()
	{
		clickById(objec.getProperty("CourseType.SelectAll.Id"));
		return this;
	}
	
	//Click Continue on CourseType
	public Selectsubjectteditstudyoptions_Page courseTypeContinue()
	{
		clickByXpath(objec.getProperty("CourseType.Continue.Xpath"));
		return new Selectsubjectteditstudyoptions_Page(driver, test);
	}
	
	
}
