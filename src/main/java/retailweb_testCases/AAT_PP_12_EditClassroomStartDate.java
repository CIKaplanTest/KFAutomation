package retailweb_testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import retailweb_pages.KaplanHome_Page;
import retailweb_pages.SelectSubjects_Page;
import wrappers.KaplanSpecificWrappers;

public class AAT_PP_12_EditClassroomStartDate extends KaplanSpecificWrappers {

		@BeforeClass
		public void setData() {
			testCaseName = "AAT_PP_12_EditClassroomStartDate";
			testDescription = "Editing Start Date of Classroom";
			browserName = "chrome,sysRetailURL";
			dataSheetName = "AAT_PP_01";
			category = "Smoke";
			authors = "DivyaLakshmi";
			
		}

		@Test(dataProvider = "fetchData")
		public void AAT_PP_12(String label ) throws InterruptedException {
		new KaplanHome_Page(driver, test).
		clickCourses()
		.clickAtoZCourses()
		.clickAtoZCourseAATFoundation()
		 .verifyPageLabel(label).
	     selectPaper4()
	    .clickChooseStudyOptions()
	    .expandPaper1()
	    .clickChooseStudyMethodPaper1()
	    .chooseStudyMethodClassroom()
		.selectLocationTwo()
		.clickChooseStartDateOne()
		.chooseStartDateOne()
		.clickContinue()		
		.editDatePaper1()
		.chooseStartDateThree()
		.clickContinue();
	}
}