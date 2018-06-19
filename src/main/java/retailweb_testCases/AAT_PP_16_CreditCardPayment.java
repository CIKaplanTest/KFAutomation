package retailweb_testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import retailweb_pages.KaplanHome_Page;
import wrappers.KaplanSpecificWrappers;


public class AAT_PP_16_CreditCardPayment extends KaplanSpecificWrappers
{

	@BeforeClass
	public void setData()
	{
		testCaseName = "AAT_PP_16_CheckoutModes";
		testDescription = "AAT ProductPicker";
		browserName = "chrome,sysRetailURL";
		dataSheetName = "AAT_PP_09";
		category = "Smoke";
		authors = "Bharath";
	}
	
	@Test(dataProvider = "fetchData")
	public void CheckoutModes_AAT_PP_16(String userName,String password,String creditCardNumber,String securityCode,
			String nameOnCard) throws InterruptedException
	{
		new KaplanHome_Page(driver, test)
		.clickCourses()
		.clickAtoZCourses()
		.clickAtoZCourseAATFoundation()
		.selectPaper2()
	    .clickChooseStudyOptions()
	    .expandPaper1()
	    .clickChooseStudyMethodPaper1()
	    //.chooseStudyMethodLiveOnline()
		//.clickChooseStartDateOne()
	    .chooseStudyMethodClassroom01()
	    .clickChooseStartDateOne()
	    .verifyPaperHeading()
		.chooseStartDateOne()
		.clickContinue()
		.clickAddtoBasket()
		.clickSecureCheckoutNotLoggedInUser()
		.enterUserName(userName)
		.enterPassword(password)
		.clickLoginRetailweb()
		.AutomateDeliveryAddress("line1","line2","city","10010")
		.SelectCard()
		.EnterCreditCardNumber(creditCardNumber)
		.EnterSecurityCode(securityCode)
		.SelectExpiryMonth()
		.SelectExpiryYear()
		.EnterNameOnCard(nameOnCard)
		.SelectIssueNumber()
		.ClickContinue()
		.AutomateBilingAddress("lineOne", "lineTwo", "towncity", "B1 1AA")
		.verifyPageHeading()
		.verifyBillingDetailsHeading()
		.verifyDeliveryDetailsHeading()
		.verifyPaymentDetailsHeading()
		.clickAcceptcheckBox()
		.clickConfirmAndPay()
		.ClickSubmit();
	}
}
