package studentcenter_testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import studentcenter_pages.Login_Page;
import wrappers.KaplanSpecificWrappers;

public class TC_013_NewUserRegistration extends KaplanSpecificWrappers {
	@BeforeClass
	public void setData() {
		testCaseName="TC_013_NewUserRegistration";
		testDescription="New User Registration";
		browserName="chrome,sysLoginURL";
		dataSheetName="TC_013_NewUserRegistration";
		category="Smoke";
		authors="Sonia";
	}
	
	@Test(dataProvider="fetchData")
	public void NewUserRegistration(String email, String FN,String LN,String mobnum,String password) throws InterruptedException
	{
		new Login_Page(driver,test)
		.clickRegister()
		.enterEmail(email)
		.enterConfirmEmail(email)
		.clickRegisterButton()
		.enterFirstName(FN)
		.enterLastName(LN) 
		.enterMobileNumber(mobnum)
		.enterPassword(password)
		.enterConfirmPassword(password)
		.clickRegisterButton();
	}
}