package exam_testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import retailweb_pages.KaplanHome_Page;
import wrappers.KaplanSpecificWrappers;

public class Exam_PP_01_SelectCourseAndLevel extends KaplanSpecificWrappers
{
	@BeforeClass
	public void setData()
	{
		testCaseName = "Exam_PP_01_SelectCourseAndLevel";
		testDescription = "Exam ProductPicker";
		browserName = "chrome,sysRetailURL";
		dataSheetName = "AAT_PP_09";
		category = "Smoke";
		authors = "Bharath";
	}
	
	@Test(dataProvider = "fetchData")
	public void Exam_SelectCourseAndLevel(String userName,String password,String creditCardNumber,String securityCode,
			String nameOnCard) throws InterruptedException
	{
		new KaplanHome_Page(driver, test)
		.clickCourses()
		.ClickBookAnExam()
		.SelectExamQualificationAndLevels()
		.SelectSubjects()
		.ChooseStudyOptions()
		.SelectSubjectForExam()
		.ClickContinue()
		.MoveToBasketPage()
		.clickSecureCheckoutNotLoggedInUser()
		.enterUserName(userName)
		.enterPassword(password)
		.clickLoginRetailwebForExam()
		.verifyPageHeading()
		.InsertOrVerifyIRNNumber("1234567890")
//		.SelectDOBDetails()
		.CheckIfDontHaveIRNNumber()
		.InsertOrVerifyMobileNumber("9876543210")
		.InsertOrVerifyWorkNumber("123")
		.ClickContinue()
		.AutomateDeliveryAddress("line1","line2","city","10010")
		.SelectCard()
		.EnterCreditCardNumber(creditCardNumber)
		.EnterSecurityCode(securityCode)
		.SelectExpiryMonth()
		.SelectExpiryYear()
		.EnterNameOnCard(nameOnCard)
		.SelectIssueNumber()
		.ClickContinue();
	}
	
	
}
