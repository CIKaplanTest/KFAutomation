package retailweb_testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import retailweb_pages.KaplanHome_Page;
import retailweb_pages.SelectSubjects_Page;
import wrappers.KaplanSpecificWrappers;

public class AAT_PP_09_EditOfLOLtoDiffStudyMethods extends KaplanSpecificWrappers {

	@BeforeClass
	public void setData() {
		testCaseName = "AAT_PP_09_EditOfLOLtoDiffStudyMethods";
		testDescription = "Edit Of LOL to AllStudyMethods";
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
		.selectPaper4()
		.selectPaper5()
		.selectPaper6()
		.clickChooseStudyOptions()
		.expandPaper1()
		.clickChooseStudyMethodPaper1()
		.chooseStudyMethodLiveOnline()
		.editPaper1()
		.chooseStudyMethodClassroom()
		.selectLocationTwo()
		.expandPaper2()
		.clickChooseStudyMethodPaper2()
		.chooseStudyMethodLiveOnline()
		.editPaper2()
		.chooseStudyMethodDistanceLearningOnline()
		.expandPaper3()
		.clickChooseStudyMethodPaper3()
		.chooseStudyMethodLiveOnline()
		.clickChooseStartDateOne()
		.chooseStartDateOne()
		.clickContinue()	
		.editPaper3()
		.chooseStudyMethodOnDemand();

	}
}