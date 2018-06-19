package usermanagement_testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import usermanagement_pages.Login_Page;
import wrappers.KaplanSpecificWrappers;

public class TC_004_UserManagement_EmailID_Search extends KaplanSpecificWrappers {
	
@BeforeClass
public void setData() {
		testCaseName="TC_004_UserManagement_EmailID_Search";
		testDescription="Search UserManagement with EmailID";
		browserName="chrome";
		dataSheetName="UM_004_Email_Search";
		category="Smoke";
		authors="divya";
		}
@Test(dataProvider="UMfetchData")
public void enterFirstNameSearch(String userName, String password, String EmailID)
{
new Login_Page(driver,test)
.enterUserName(userName)
.enterPassword(password)
.clickLogin()
.enterFirstName(EmailID)
.clickSearch()
.clickSignOut();
}
}