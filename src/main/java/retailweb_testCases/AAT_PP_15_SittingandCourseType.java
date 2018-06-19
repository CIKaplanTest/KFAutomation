package retailweb_testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import retailweb_pages.KaplanHome_Page;
import retailweb_pages.SelectSubjects_Page;
import wrappers.KaplanSpecificWrappers;

public class AAT_PP_15_SittingandCourseType extends KaplanSpecificWrappers {

		@BeforeClass
		public void setData() {
			testCaseName = "AAT_PP_15_SittingandCourseType";
			testDescription = "AAT ProductPicker";
			browserName = "chrome,sysRetailURL";
			dataSheetName = "AAT_PP_01";
			category = "Smoke";
			authors = "Sonia";
			
		}

		@Test(dataProvider = "fetchData")
		public void AAT_PPic_05(String userName,String password,String paypalUsername,String paypalPassword) throws InterruptedException {
		new KaplanHome_Page(driver, test).
		clickCourses()
		.clickAtoZCourses()
		.clickAtoZCourseAATFoundation()
		//.selectPaper3()//FullFlow -ACCA-Options)
		.selectPaper6()//ACCA-Skills-F7-Skipping Sittings and Coursetype)
		//.selectPaper2()
	    .clickChooseStudyOptions()
	    .expandPaper1()
	    .clickChooseStudyMethodPaper1()
	    .chooseStudyMethodClassroom01()
	    /*.selectLocationTwo()	    
	    //.chooseStudyMethodLiveOnline()
	    //.selectSittingDate()
	    .sittingDateclickContinue()
	    .selectCourseTypes()
	    .courseTypeContinue()*/
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
		.clickSecureCheckout()
		.selectPayPal()
		.acceptPayPalTerms()
		.payWithPaypal()
		.enterEmailPaypal(paypalUsername)
		.enterPasswordPaypal(paypalPassword)
		.clickLoginPaypal()
		//.clickCancelLink();
		.clickPaynow()
		.clickReturnToMerchant();
	    }
	}
