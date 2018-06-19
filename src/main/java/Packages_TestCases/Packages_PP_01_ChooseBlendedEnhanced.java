package Packages_TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Packages_Pages.Packages_Page;
import wrappers.KaplanSpecificWrappers;

public class Packages_PP_01_ChooseBlendedEnhanced extends KaplanSpecificWrappers
{
	@BeforeClass
	public void setData()
	{
		testCaseName = "Packages_PP_01_ChooseBlendedEnhanced";
		testDescription = "Packages ProductPicker";
		browserName = "chrome,SysPackagesURL";
		dataSheetName = "AAT_PP_09";
		category = "Smoke";
		authors = "Bharath";
	}

	@Test(dataProvider = "fetchData")
	public void Packages_ChooseBlendedEnhanced(String userName,String password,String creditCardNumber,String securityCode,
			String nameOnCard) throws InterruptedException
	{
		new Packages_Page(driver, test)
		.VerifyPackageHeader()
		.ClickToExpandBlendedEnhancedAccordion()
		.ChooseRandomLocationForBlendedEnhanced()
		.SelectRandomSitting()
		.ExpandSelectedPackageAccordion()
		.SelectStudyMethods()
		.ClickOnAddToBasket()
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
		.verifyPaymentDetailsHeading()
		.verifyBillingDetailsHeading()
		.verifyDeliveryDetailsHeading()
		.clickAcceptcheckBox()
		.clickConfirmAndPay();
	}
}



