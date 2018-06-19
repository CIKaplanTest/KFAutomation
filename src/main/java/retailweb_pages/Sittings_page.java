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

public class Sittings_page  extends KaplanSpecificWrappers {
	public Sittings_page(RemoteWebDriver driver, ExtentTest test){

		this.driver = driver;
		this.test = test;

		//if(!verifyTitle("Course Builder | Kaplan UK | Basket")){
		//reportStep("This is not AccountHome Page", "FAIL");}
	}
	//Click on Sitting Random Dates
	public Selectsubjectteditstudyoptions_Page selectSittingDate()
	{
		List<WebElement> date = driver.findElements(By.className("radio-label"));
		
		/*Random rand = new Random();
		int randomProduct = rand.nextInt(date.size());
		System.out.println("Print"+randomProduct);
		if (date.size() > 1)
		{
		date.get(randomProduct).click();
		}
		System.out.println("Print"+ date.get(randomProduct));*/
		return new Selectsubjectteditstudyoptions_Page(driver, test);
	}
	//Select Continue in Sittings
	public CourseType_page sittingDateclickContinue()
	{
		
		clickByXpath(objec.getProperty("Sitting.Continue.Xpath"));
		if(verifyTitleContains("Course Builder | Kaplan UK | Subject summary")) 
		{			
			CourseType_page ct=new CourseType_page(driver,test);
			ct.selectAllCourseType();
		}
				
		return new CourseType_page(driver,test); 
	}
	

	
}
