package retailweb_testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import retailweb_pages.KaplanHome_Page;
import retailweb_pages.SelectSubjects_Page;
import wrappers.KaplanSpecificWrappers;

public class AAT_PP_13_EditLOLStartDate extends KaplanSpecificWrappers {

		@BeforeClass
		public void setData() {
			testCaseName = "AAT_PP_13_EditLOLStartDate";
			testDescription = "Editing Start Date of Live Online";
			browserName = "chrome,sysRetailURL";
			dataSheetName = "AAT_PP_08";
			category = "Smoke";
			authors = "DivyaLakshmi";
			
		}

		@Test(dataProvider = "fetchData")
		public void AAT_PP_13(String label ) throws InterruptedException {
		new KaplanHome_Page(driver, test).
		clickCourses()
		.clickAtoZCourses()
		.clickAtoZCourseAATFoundation()
		 .verifyPageLabel(label).
	     selectPaper4()
	    .clickChooseStudyOptions()
	    .expandPaper1()
	    .clickChooseStudyMethodPaper1()
	    .chooseStudyMethodLiveOnline()
		.clickChooseStartDateOne()
		.chooseStartDateOne()
		.clickContinue()		
		.editDatePaper1()
		.chooseStartDateFour()
		.clickContinue();
	}
}