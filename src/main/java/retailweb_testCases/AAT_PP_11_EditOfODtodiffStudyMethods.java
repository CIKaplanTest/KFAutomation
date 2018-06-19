package retailweb_testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import retailweb_pages.KaplanHome_Page;
import retailweb_pages.SelectSubjects_Page;
import wrappers.KaplanSpecificWrappers;

public class AAT_PP_11_EditOfODtodiffStudyMethods extends KaplanSpecificWrappers {

		@BeforeClass
		public void setData() {
			testCaseName = "AAT_PP_11_EditOfODtodiffStudyMethods";
			testDescription = "Edit Of On Demand to AllStudyMethods";
			browserName = "chrome,sysRetailURL";
			dataSheetName = "AAT_PP_08";
			category = "Smoke";
			authors = "DivyaLakshmi";
			
		}

		@Test(dataProvider = "fetchData")
		public void AAT_PPic_11( String label) throws InterruptedException {
		new KaplanHome_Page(driver, test).
		clickCourses()
		.clickAtoZCourses()
		.clickAtoZCourseAATFoundation()
		.verifyPageLabel(label)
	    .selectPaper4()
	    .selectPaper2()
	    .selectPaper3()
	    .clickChooseStudyOptions()
	    .expandPaper1()
	    .clickChooseStudyMethodPaper1()
	    .chooseStudyMethodOnDemand()
		.editPaper1()
		.chooseStudyMethodClassroom()
		.selectLocationTwo()
		.expandPaper2()
		.clickChooseStudyMethodPaper2()
	    .chooseStudyMethodOnDemand()
		.editPaper2()
		.chooseStudyMethodLiveOnline()
		.expandPaper3()
		.clickChooseStudyMethodPaper3()
	    .chooseStudyMethodOnDemand()	
		.editPaper3()
		.chooseStudyMethodDistanceLearningPrinted();
		
	}
}