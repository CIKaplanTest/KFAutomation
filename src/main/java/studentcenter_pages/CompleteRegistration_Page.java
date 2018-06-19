package studentcenter_pages;


import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;

import retailweb_pages.Checkout_page;
import wrappers.KaplanSpecificWrappers;

public class CompleteRegistration_Page extends KaplanSpecificWrappers
{
	//Confirming that we are in Complete Registration Page
	public CompleteRegistration_Page(RemoteWebDriver driver, ExtentTest test){

		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Complete registration")){
			reportStep("This is not Complete Registration Page", "FAIL");
		}
	}

	//Select Checkbox SameAsMyWorkEmailAddress
	public CompleteRegistration_Page selectCheckboxSameEmailAddress()
	{
		clickById(objec.getProperty("CompleteRegistration.WorkEmail.Id"));
		return this;
	}
	//Select The Title
	public CompleteRegistration_Page selectTitle()
	{
		//Select dropdown = new Select(driver.findElement(By.xpath("//button[@data-id='Title']")));
		//dropdown.selectByIndex(2);
		List<WebElement> Title = driver.findElements(By.xpath("//button[@data-id='Title']"));
		Random rand = new Random();
		int randomProduct = rand.nextInt(Title.size());
		Title.get(randomProduct).click();
		return this;
	}
	//Select Date of Birth
	public CompleteRegistration_Page selectDay()
	{
		List<WebElement> day = driver.findElements(By.xpath("//button[@data-id='Day']"));
		Random rand = new Random();
		int randomProduct = rand.nextInt(day.size());
		day.get(randomProduct).click();
		return this;
	}

	public CompleteRegistration_Page selectMonth()
	{
		List<WebElement> Month = driver.findElements(By.xpath("//button[@data-id='Month']"));
		Random rand = new Random();
		int randomProduct = rand.nextInt(Month.size());
		Month.get(randomProduct).click();
		return this;
	}

	public CompleteRegistration_Page selectYear()
	{
		List<WebElement> Year = driver.findElements(By.xpath("//button[@data-id='Year']"));
		Random rand = new Random();
		int randomProduct = rand.nextInt(Year.size());
		Year.get(randomProduct).click();
		return this;
	}


	//Select Preferred qualification
	public CompleteRegistration_Page selectQualification()
	{
		List<WebElement> Year = driver.findElements(By.xpath("//button[@data-id='PreferredProducts']"));
		Random rand = new Random();
		int randomProduct = rand.nextInt(Year.size());
		Year.get(randomProduct).click();
		return this;
	
	}

	//Select Or Accept Registration
	public CompleteRegistration_Page acceptRegistration()
	{
		clickById(objec.getProperty("CompleteRegistration.AcceptRegistration.Id"));
		return this;
	}




	//Enter FirstName in the field
	public CompleteRegistration_Page enterFirstName(String FN)
	{
		enterDataById(objec.getProperty("CompleteRegistration.FirstName.Id"),FN);
		return this;
	}
	//Enter LastName in the field
	public CompleteRegistration_Page enterLastName(String LN)
	{
		enterDataById(objec.getProperty("CompleteRegistration.LastName.Id"),LN);
		return this;
	}
	//Enter MobileNumber in the field
	public CompleteRegistration_Page enterMobileNumber(String mobnum)
	{
		enterDataById(objec.getProperty("CompleteRegistration.MobileNumber.Id"),mobnum);
		return this;
	}
	//Enter Password in the field
	public CompleteRegistration_Page enterPassword(String password)
	{
		enterDataById(objec.getProperty("CompleteRegistration.Password.Id"),password);
		return this;
	}
	//Enter confirm Password in the field
	public CompleteRegistration_Page enterConfirmPassword(String password)
	{
		enterDataById(objec.getProperty("CompleteRegistration.ConfirmPassword.Id"),password);
		return this;
	}

	//Click on Register button
	public Checkout_page clickRegisterButton()
	{
		clickByXpath(objec.getProperty("CompleteRegistration.Register.xpath"));
		return new Checkout_page(driver, test);
	}





}
