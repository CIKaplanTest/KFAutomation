package usermanagement_testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import usermanagement_pages.Login_Page;
import wrappers.KaplanSpecificWrappers;

public class TC_003_UserManagement_LN_Search extends KaplanSpecificWrappers {
		// TODO Auto-generated method stub
	@BeforeClass
	public void setData() {
			testCaseName="TC_003_UserManagement_LN_Search";
			testDescription="Search UserManagement with SurName";
			browserName="chrome";
			dataSheetName="UM_003_LN_Search";
			category="Smoke";
			authors="divya";
			}
	@Test(dataProvider="UMfetchData")
	public void enterFirstNameSearch(String userName, String password, String LN)
	{
	new Login_Page(driver,test)
	.enterUserName(userName)
	.enterPassword(password)
	.clickLogin()
	.enterFirstName(LN)
	.clickSearch()
	.clickSignOut();
	}
}

