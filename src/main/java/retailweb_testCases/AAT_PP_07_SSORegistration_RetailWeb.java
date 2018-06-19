package retailweb_testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import retailweb_pages.KaplanHome_Page;
import retailweb_pages.SelectSubjects_Page;
import studentcenter_pages.Login_Page;
import wrappers.KaplanSpecificWrappers;

public class AAT_PP_07_SSORegistration_RetailWeb extends KaplanSpecificWrappers {

	@BeforeClass
	public void setData() {
		testCaseName = "AAT_PP_07";
		testDescription = "AAT ProductPicker SSORegistrationCheckout";
		browserName = "chrome,sysRetailURL";
		dataSheetName = "AAT_PP_07";
		category = "Smoke";
		authors = "Sonia";

	}

	@Test(dataProvider = "fetchData")
	public void ssoRegistrationCheckout(String email, String FN,String LN,String mobnum,String password) throws InterruptedException
	{
		new KaplanHome_Page(driver, test).
		 clickCourses()
		.clickAtoZCourses()
		.clickAtoZCourseAATFoundation()
		.selectPaper2()
		.clickChooseStudyOptions()
		.expandPaper1()
		.clickChooseStudyMethodPaper1()
		.chooseStudyMethodClassroom()
		.selectLocationTwo()
		.clickChooseStartDateOne()
		.chooseStartDateOne()
		.clickContinue()		
		.clickAddtoBasket()
		.clickSecureCheckoutNotLoggedInUser()
		.clickRegister() //- Not Picking the Locator
		.enterEmail(email)
		.enterConfirmEmail(email)
		.clickRegisterButton()
		.selectCheckboxSameEmailAddress()
		.selectTitle()
		.enterFirstName(FN)
		.enterLastName(LN)
		.enterMobileNumber(mobnum)
		.selectDay()
		.selectMonth()
		.selectYear()
		.selectQualification()
		.enterPassword(password)
		.enterConfirmPassword(password)
		.acceptRegistration()
		.clickRegisterButton();

	}
}
