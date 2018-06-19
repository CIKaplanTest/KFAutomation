package usermanagement_testCases;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import studentcenter_pages.Login_Page;
import wrappers.KaplanSpecificWrappers;

public class TC_001_LoginandLogout extends KaplanSpecificWrappers {

	@BeforeClass
	public void setData() {
		testCaseName = "TC_001_LoginandLogout";
		testDescription = "Login To MyKaplan User-management and Logout";
		browserName = "chrome,sysuserURl";
		dataSheetName = "UM_001_LoginandLogout";
		category = "Smoke";
		authors = "Sonia";
		
	}

	@Test(dataProvider = "fetchData")
	public void loginAndLogout(String userName, String password) throws InterruptedException {
		new Login_Page(driver, test).enterUserName(userName).enterPassword(password).clickLogin().clickSignOut();
	}
}
