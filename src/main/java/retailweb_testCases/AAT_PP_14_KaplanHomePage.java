package retailweb_testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import retailweb_pages.KaplanHome_Page;
import retailweb_pages.SelectSubjects_Page;
import wrappers.KaplanSpecificWrappers;

public class AAT_PP_14_KaplanHomePage extends KaplanSpecificWrappers {

	@BeforeClass
	public void setData() {
		testCaseName = "AAT_PP_14";
		testDescription = "KaplanHomePage to AAT ProductPicker";
		browserName = "chrome,sysRetailURL";
		dataSheetName = "AAT_PP_01";
		category = "Smoke";
		authors = "Sonia";

	}

	@Test(dataProvider = "fetchData")
	public void KaplanHomePage_AAT_PP_14(String userName,String password,String paypalUsername,String paypalPassword)  throws InterruptedException
	{
		new KaplanHome_Page(driver, test).
		clickCourses()
		.clickAtoZCourses()
		.clickAtoZCourseAATFoundation();
		
	}
}

