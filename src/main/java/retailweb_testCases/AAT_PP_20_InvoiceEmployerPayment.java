package retailweb_testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import retailweb_pages.KaplanHome_Page;
import wrappers.KaplanSpecificWrappers;

public class AAT_PP_20_InvoiceEmployerPayment extends KaplanSpecificWrappers
{
	@BeforeClass
	public void setData()
	{
		testCaseName = "AAT_PP_20_InvoiceEmployerPayment";
		testDescription = "AAT ProductPicker";
		browserName = "chrome,sysRetailURL";
		dataSheetName = "AAT_PP_09";
		category = "Smoke";
		authors = "Bharath";
	}
	
	@Test(dataProvider = "fetchData")
	public void InvoiceEmployerPayment(String userName,String password,String creditCardNumber,String securityCode,
			String nameOnCard) throws InterruptedException
	{
		new KaplanHome_Page(driver, test)
		.clickCourses()
		.clickAtoZCourses()
		.clickAtoZCourseAATFoundation()
		.selectPaper6()
	    .clickChooseStudyOptions()
	    .expandPaper1()
	    .clickChooseStudyMethodPaper1()
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
		.SelectInvoiceEmployer()
		.enterCompanyname("Test Company")
		.enterCompanyRegNo("12345")
		.enterPurchaseOrderNo("98468")
		.TrainingMgrName("Bharath")
		.TrainingMgrEmail("bharath.jegadeesan@kaplan.co.uk")
		.addLine1("Street 1")
		.addLine2("Street 2")
		.enterCity("Test City")
		.enterPostCode("B1 1AA")
		.CheckInvoiceAddress()
		.InvoiceAddLine1("Invoice Street 1")
		.InvoiceAddLine2("Invoice Street 2")
		.InvoiceEnterCity("Invoice Test City")
		.InvoiceEnterPostCode("B1 1AA")
		.clickAcceptConditions()
		.clickConfirmandPay()
		.GoToApprovalPage();
	}
	
}
