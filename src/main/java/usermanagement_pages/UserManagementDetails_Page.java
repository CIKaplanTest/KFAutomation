package usermanagement_pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import usermanagement_pages.Login_Page;
import wrappers.KaplanSpecificWrappers;

public class UserManagementDetails_Page extends KaplanSpecificWrappers {

	//Confirming that we are in User Management page
		public UserManagementDetails_Page(RemoteWebDriver driver, ExtentTest test){
			
			this.driver = driver;
			this.test = test;
			if(!verifyTitle("User Management")){
				reportStep("This is not Login Page", "FAIL");
			}
		}
		//Click Signout in the field
		public Login_Page clickSignOut()
		{
			clickByXpathNoSnap(objec.getProperty("UserManagement.Signout.Xpath"));
			return new Login_Page(driver,test);
			
		}
		//Enter FirstName in the field
		public UserManagementDetails_Page enterFirstName(String FN)
		{
			enterDataById(objec.getProperty("UserManagement.FirstName.Id"),FN);
			return this;
		}
		
		//Enter SurName in the field
		public UserManagementDetails_Page enterSurname(String LN)
		{
			enterDataById(objec.getProperty("UserManagement.LastName.Id"),LN);
			return this;
		}
		//Enter EmailID in the field
		public UserManagementDetails_Page enterEmailID(String ID)
		{
		enterDataById(objec.getProperty("UserManagement.EmailID.Id"),ID);
		return this;
		}		
				
		//Click Search in the field		
		public UserManagementDetails_Page clickSearch()
		{
		   clickByXpath(objec.getProperty("UserManagement.Search.Xpath"));
		   
		   return new UserManagementDetails_Page(driver,test);
		}
		//Click Search in the field		
		public UserManagementDetails_Page clickEditRoles()
		{
		 clickByXpath(objec.getProperty("UserManagement.EditRoles.LinkText"));
		 String editrolewindow = driver.getWindowHandle();
		 driver.switchTo().window(editrolewindow);
		 
			   
		 return new UserManagementDetails_Page(driver,test);
		}
}
