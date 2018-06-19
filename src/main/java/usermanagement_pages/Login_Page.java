package usermanagement_pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import usermanagement_pages.UserManagementDetails_Page;
import usermanagement_pages.Login_Page;
import wrappers.KaplanSpecificWrappers;

public class Login_Page extends KaplanSpecificWrappers {

	//Confirming that we are in Login Page
		public Login_Page(RemoteWebDriver driver, ExtentTest test){
			
			this.driver = driver;
			this.test = test;
			if(!verifyTitle("Log in")){
				reportStep("This is not Login Page", "FAIL");
			}
		}
		//Enter Username in the field
		public Login_Page enterUserName(String userName)
		{
			enterDataById(objec.getProperty("UserManagement.Login.EmailAddress.Id"),userName);
			return this;
		}
		//Enter Password in the field
		public Login_Page enterPassword(String password)
		{
			enterDataById(objec.getProperty("UserManagement.Login.Password.Id"),password);
			return this;
		}
		//Click on Login button
		public UserManagementDetails_Page clickLogin()
		{
			
		   clickByXpathNoSnap(objec.getProperty("UserManagement.Login.Loginbutton.Xpath"));
		   
		   return new UserManagementDetails_Page(driver,test);
		}
}
