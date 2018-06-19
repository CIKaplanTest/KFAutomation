package usermanagement_testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import usermanagement_pages.Login_Page;
import wrappers.KaplanSpecificWrappers;

public class TC_002_UserManagement_FN_Search extends KaplanSpecificWrappers {
	@BeforeClass
	public void setData() {
		testCaseName="TC_002_UserManagement_FN_Search";
		testDescription="Search UserManagement with FirstName";
		browserName="chrome";
		dataSheetName="UM_002_FN_Search";
		category="Smoke";
		authors="divya";
		}
	@Test(dataProvider="UMfetchData")
	public void enterFirstNameSearch(String userName, String password, String FN)
	{
	new Login_Page(driver,test)
	.enterUserName(userName)
	.enterPassword(password)
	.clickLogin()
	.enterFirstName(FN)
	.clickSearch()
	.clickSignOut();
	}

}