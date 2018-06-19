package studentcenter_pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import exam_pages.IRNPage;
import retailweb_pages.Checkout_page;
import retailweb_pages.DeliveryAddress_Page;
import wrappers.KaplanSpecificWrappers;

public class Login_Page extends KaplanSpecificWrappers
{
	//Confirming that we are in Login Page
	public Login_Page(RemoteWebDriver driver, ExtentTest test){
		
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Log in")){
			reportStep("This is not Login Page", "FAIL");
		}
	}
	//Enter Username in the field
	public Login_Page enterUserName(String userName) throws InterruptedException
	{
		String xpath = objec.getProperty("Login.Test.Xpath");
		Thread.sleep(2000);
 		enterDataByXpath(xpath, userName);
		return this;
	}
	//Enter Password in the field
	public Login_Page enterPassword(String password) throws InterruptedException
	{
		String id = objec.getProperty("Login.Password.ID");
		Thread.sleep(2000);
		enterDataById(id ,password);
		return this;
	}
		
	//Click on Login button
	public MyDetails_Page clickLogin()
	{
		
	   clickByXpathNoSnap(objec.getProperty("Login.Loginbutton.Xpath"));
	   //clickByXpath("//button[@type='submit']");
		 //clickByXPath("//button[@value='Login']");
	return new MyDetails_Page(driver,test);
	}
	
	public Homepage_CIMABooks_BS_Page clickBSLogin()
	{
		 clickByXpathNoSnap(objec.getProperty("Login.Loginbutton.Xpath"));
		 return new Homepage_CIMABooks_BS_Page(driver,test);
	}
	public Login_Page clickLoginInvalidUser()
	{
		 clickByXpath(objec.getProperty("Login.Loginbutton.Xpath"));
		 return this;
	}

	public Login_Page invalidUserLogin(String errortext)
	{
		//WebDriverWait wait = new WebDriverWait(driver, 10); 
		//WebElement element = wait.until(ExpectedConditions.elementT(objec.getProperty("Login.ErrorMessage.Class"))));
		//element.click();
		//String eText=driver.findElement(By.className("text-danger")).getText();
		//System.out.println(eText);
		verifyTextByXPath(objec.getProperty("Login.ErrorMessage.Xpath"), errortext);
		return this;
	}
	//To click on addabook link
	public Login_Page clickAddBook() throws InterruptedException
	{
		Thread.sleep(5000); 
		clickBylinkText(objec.getProperty("Login.AddaBook.Link"));
		 return this;
	}
	
	//To click on Register button
		public Register_Page clickRegister() throws InterruptedException
		{

			if (driver.findElement(By.linkText(objec.getProperty("Login.Register.Link"))).isDisplayed() && driver.findElement(By.linkText(objec.getProperty("Login.Register.Link"))).isEnabled())
			clickBylinkText(objec.getProperty("Login.Register.Link"));
			 return new Register_Page(driver, test);
		}
		
		public DeliveryAddress_Page clickLoginRetailweb()
		{
			 clickByXpath(objec.getProperty("Login.Loginbutton.Xpath"));
			 return new DeliveryAddress_Page(driver,test);
		}
		
		public IRNPage clickLoginRetailwebForExam()
		{
			 clickByXpath(objec.getProperty("Login.Loginbutton.Xpath"));
			 return new IRNPage(driver,test);
		}
}
