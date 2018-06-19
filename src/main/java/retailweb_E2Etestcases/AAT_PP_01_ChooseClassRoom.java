package retailweb_E2Etestcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import retailweb_pages.*;
import org.testng.annotations.Test;

import retailweb_pages.SelectSubjects_Page;
import wrappers.KaplanSpecificWrappers;

public class AAT_PP_01_ChooseClassRoom extends KaplanSpecificWrappers {

		@BeforeClass
		public void setData() {
			testCaseName = "AAT_PP_01";
			testDescription = "AAT ProductPicker";
			browserName = "chrome,sysRetailURL";
			dataSheetName = "AAT_PP_01";
			category = "Smoke";
			authors = "DivyaLakshmi";
			
		}

		@Test(dataProvider = "fetchData")
		public void AAT_PPic_01(String userName,String password,String paypalUsername,String paypalPassword ) throws InterruptedException {
		new KaplanHome_Page(driver, test).
		//verifyPageLabel(label)
		clickCourses()
		.clickAtoZCourses()
		.clickAtoZCourseAATFoundation()
	     .selectPaper1()
	    .clickChooseStudyOptions()
	    .expandPaper1()
	    .clickChooseStudyMethodPaper1()
//	    .chooseStudyMethodClassroom()	    
//		.selectRandomLocation()
//		.clickChooseStartDateOne()
//	    .verifyPaperHeading()
//		.chooseStartDateOne()
//		.clickContinue()
	    .chooseStudyMethodClassroom01()
		/*.getpaper1amount()*/
		.clickAddtoBasket()
		.clickSecureCheckoutNotLoggedInUser()
		.enterUserName(userName)
		.enterPassword(password)
		.clickLoginRetailweb()
		.AutomateDeliveryAddress("line1","line2","city","10010")
		/*.clickProceedtoCheckout()*/
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