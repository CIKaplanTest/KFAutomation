package retailweb_E2Etestcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import retailweb_pages.KaplanHome_Page;
import retailweb_pages.SelectSubjects_Page;
import wrappers.KaplanSpecificWrappers;

public class AAT_PP_03_ChooseDistanceLearning extends KaplanSpecificWrappers {

		@BeforeClass
		public void setData() {
			testCaseName = "AAT_PP_01";
			testDescription = "AAT ProductPicker";
			browserName = "chrome,TestURLessentials";
			dataSheetName = "AAT_PP_01";
			category = "Smoke";
			authors = "DivyaLakshmi";
			
		}

		@Test(dataProvider = "fetchData")
		public void AAT_PPic_03(String userName,String password,String paypalUsername,String paypalPassword) throws InterruptedException {
		new KaplanHome_Page(driver, test).
		//verifyPageLabel(label)
		clickCourses()
		.clickAtoZCourses()
		.clickAtoZCourseAATFoundation()
	   // selectPaper1()
	    .selectPaper4()
	     /*.selectPaper3()
	    .selectPaper4()
	    .selectPaper5()
	    .selectPaper6()
	   .selectPaper7()
	    .selectPaper8()
	    .selectPaper9()*/
	    .clickChooseStudyOptions()
	    .expandPaper1()
	    .clickChooseStudyMethodPaper1()
	    //.chooseStudyMethodDistanceLearningOnline()
	    .chooseStudyMethodDistanceLearningO()
//	    .chooseStudyMethodDistanceLearningP()
	    //.expandPaper2()
	    //.clickChooseStudyMethodPaper2()
	    //.chooseStudyMethodDistanceLearningPrinted()
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
