package retailweb_testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import retailweb_pages.KaplanHome_Page;
import retailweb_pages.SelectSubjects_Page;
import wrappers.KaplanSpecificWrappers;

public class AAT_PP_06_AllStudyMethods extends KaplanSpecificWrappers {

		@BeforeClass
		public void setData() {
			testCaseName = "AAT_PP_06_SelectingAllStudyMethods";
			testDescription = "SelectingAllStudyMethods";
			browserName = "chrome,sysRetailURL";
			dataSheetName = "AAT_PP_01";
			category = "Smoke";
			authors = "DivyaLakshmi";
			
		}

		@Test(dataProvider = "fetchData")
		public void AAT_PPic_06(String userName,String password,String paypalUsername,String paypalPassword ) throws InterruptedException {
			new KaplanHome_Page(driver, test).
			clickCourses()
			.clickAtoZCourses()
			.clickAtoZCourseAATFoundation()
	   .selectPaper1()
	    //selectPaper7()
		//.selectPaper8()
		//.selectPaper9()
		//.selectPaper6()
	     .selectPaper3()
	    .selectPaper4()
	  //  .selectPaper5()
	    .selectPaper6()
	  // .selectPaper7()
	   // .selectPaper8()
	  // .selectPaper9()
	    .clickChooseStudyOptions()
		.expandPaper4()
		.clickChooseStudyMethodPaper4()
		.chooseStudyMethodOnDemand()
		.expandPaper3()
		.clickChooseStudyMethodPaper3()
		.chooseStudyMethodDistanceLearningPrinted()
		.expandPaper2()
		.clickChooseStudyMethodPaper2()
		.chooseStudyMethodLiveOnline()
		.clickChooseStartDateTwo()
		.chooseStartDateThree()
		.clickContinue()
		.expandPaper1()
	    .clickChooseStudyMethodPaper1()
	    .chooseStudyMethodClassroom()
		.selectLocationTwo()
		.clickChooseStartDateOne()
		.chooseStartDateOne()
		.clickContinue()
		.clickAddtoBasket()
		.clickSecureCheckoutNotLoggedInUser()
		.enterUserName(userName)
		.enterPassword(password)
		.clickLoginRetailweb()
		.AutomateDeliveryAddress("line1","line2","city","10010")
		//.clickProceedtoCheckout()
		.selectPayPal()
		.acceptPayPalTerms()
		.payWithPaypal()
		.enterEmailPaypal(paypalUsername)
		.enterPasswordPaypal(paypalPassword)
		.clickLoginPaypal()
		.clickPaynow()
		.clickReturnToMerchant();
	}
}