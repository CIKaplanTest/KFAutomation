package retailweb_testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import retailweb_pages.KaplanHome_Page;
import retailweb_pages.SelectSubjects_Page;
import wrappers.KaplanSpecificWrappers;

public class AAT_PP_08_EditOfClassroomtoDiffStudyMethodsanddifflocation extends KaplanSpecificWrappers {

		@BeforeClass
		public void setData() {
			testCaseName = "AAT_PP_08_EditOfAllStudyMethods";
			testDescription = "EditOfAllStudyMethods";
			browserName = "chrome,sysRetailURL";
			dataSheetName = "AAT_PP_08";
			category = "Smoke";
			authors = "DivyaLakshmi";
			
		}

		@Test(dataProvider = "fetchData")
		public void AAT_PPic_08( String label) throws InterruptedException {
		new KaplanHome_Page(driver, test).
		clickCourses()
		.clickAtoZCourses()
		.clickAtoZCourseAATFoundation()
		.verifyPageLabel(label)
	    .selectPaper3()
	    .selectPaper4()
	    .selectPaper5()
	    .selectPaper6()
	    .clickChooseStudyOptions()
	    .expandPaper1()
	    .clickChooseStudyMethodPaper1()
	    .chooseStudyMethodClassroom()
		.selectLocationTwo()
		.editPaper1()
		.selectLocationThree()
		.expandPaper2()
		.clickChooseStudyMethodPaper2()
	    .chooseStudyMethodClassroom()
		.selectLocationTwo()
		.editPaper2()
		.chooseStudyMethodClassroom()
		.chooseStudyMethodDistanceLearningPrinted()
		.expandPaper3()
		.clickChooseStudyMethodPaper3()
	    .chooseStudyMethodClassroom()
		.selectLocationOne()
		.editPaper3()
		.chooseStudyMethodClassroom()
		.chooseStudyMethodOnDemand()
		.expandPaper4()
		.clickChooseStudyMethodPaper4()
	    .chooseStudyMethodClassroom()
		.selectLocationFour()
		.editPaper4()
		.chooseStudyMethodClassroom()
		.chooseStudyMethodLiveOnline();
	}
}