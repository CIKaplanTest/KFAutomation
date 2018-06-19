package retailweb_testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import retailweb_pages.KaplanHome_Page;
import retailweb_pages.SelectSubjects_Page;
import wrappers.KaplanSpecificWrappers;

public class AAT_PP_05_RemoveSubjects extends KaplanSpecificWrappers {

	@BeforeClass
	public void setData() {
		testCaseName = "AAT_PP_05_RemoveSubjects";
		testDescription = "AAT ProductPicker";
		browserName = "chrome,sysRetailURL";
		dataSheetName = "AAT_PP_08";
		category = "Smoke";
		authors = "DivyaLakshmi";

	}

	@Test(dataProvider = "fetchData")
	public void AAT_PPic_05(String label) throws InterruptedException {
		new KaplanHome_Page(driver, test).
		clickCourses()
		.clickAtoZCourses()
		.clickAtoZCourseAATFoundation()
		.verifyPageLabel(label)
		.selectPaper1()
		.selectPaper2()
		.selectPaper3()
		.clickChooseStudyOptions()
		.expandPaper1()
		.removePaper1()
		.expandPaper1()
		.clickChooseStudyMethodPaper2()
		.chooseStudyMethodClassroom()
		.selectLocationTwo()
		.removePaper2()
		.expandPaper1()
		.clickChooseStudyMethodPaper3()
		.chooseStudyMethodLiveOnline()
		.clickChooseStartDateThree()
		.chooseStartDateOne()
		.clickContinue()		
		.removePaper3();
	}
}
