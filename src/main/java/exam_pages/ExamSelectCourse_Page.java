package exam_pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import retailweb_pages.Basket_page;
import retailweb_pages.Checkout_page;
import wrappers.KaplanSpecificWrappers;

public class ExamSelectCourse_Page extends KaplanSpecificWrappers
{
	public ExamSelectCourse_Page(RemoteWebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
		verifyTitleContains("ExamWidgetPage");
	}
	
	public ExamSelectCourse_Page SelectExamQualificationAndLevels() throws InterruptedException
	{
		List<WebElement> qualifications = driver.findElements(By.className(objec.getProperty("BookAnExam.QualificationAndLevels.Class")));
		Random rn = new Random();
		int size = qualifications.size()==1 ? 1 :qualifications.size()-1;
		int rand = rn.nextInt(size);
		WebElement selectedQualification = qualifications.get(1);		
		selectedQualification.click();
		
		if(VerifyTextByClass(objec.getProperty("BookAnExam.TitleHeader.Class"), "Select your course"))
		{
			List<WebElement> elements = driver.findElements(By.xpath(objec.getProperty("BookAnExam.Levels.Xpath")));
			int elementIndex = rn.nextInt(qualifications.size()==1 ? 1 :qualifications.size()-1);
			WebElement selectedLevel = elements.get(elementIndex);
			selectedLevel.click();
			Thread.sleep(1000);
		}
		
		return this;
	}
	
	public ExamSelectCourse_Page SelectSubjects() throws InterruptedException
	{
		if(VerifyTextByClass(objec.getProperty("BookAnExam.TitleHeader.Class"), "Select subjects to sit"))
		{
			List<WebElement> subjects = driver.findElements(By.className(objec.getProperty("BookAnExam.CheckSubjects.Class")));
			Random rn = new Random();
			int size = subjects.size()==1 ? 1 :subjects.size()-1;
			int rand = rn.nextInt(size);
			WebElement selectedSubject = subjects.get(rand);
			selectedSubject.click();
		}
		return this;
	}
	
	public ExamSelectCourse_Page ChooseStudyOptions() throws InterruptedException
	{
		clickById(objec.getProperty("SelectSubjects.ChooseStudyOptions.Id"));	
		return this;
	}
	
	public ExamSelectCourse_Page SelectSubjectForExam() throws InterruptedException
	{
		if(VerifyTextByClass(objec.getProperty("BookAnExam.TitleHeader.Class"), "Select a subject to choose exam location and date"))
		{
			List<WebElement> subjectsForExam = driver.findElements(By.className(objec.getProperty("BookAnExam.SubjectForExam.Class")));
			for(int i=0; i<subjectsForExam.size();i++)
			{
				subjectsForExam.get(i).click();
				
				// Selecting location
				String buttonXpath = new StringBuilder("//button[@data-id='").append(i+1).append("']").toString(); 
				clickByXpath(buttonXpath);
				
				List<WebElement> locations = driver.findElements(By.xpath(objec.getProperty("BookAnExam.Locations.Xpath")));
				Random rn = new Random();
				int size = locations.size()==1 ? 1 :locations.size()-1;
				int rand = rn.nextInt(size);
				WebElement selectedLocation = locations.get(rand);
				selectedLocation.click();
				Thread.sleep(1000);
				
				//Validate Add to basket button should be disabled
				 if(!driver.findElement(By.id(objec.getProperty("BookAnExam.AddToBasket.ID"))).isEnabled())
				 {
					 //Selecting start date
					 clickByXpath(objec.getProperty("BookAnExam.StartDate.Xpath"));
				
					 List<WebElement> examStartDates = driver.findElements(By.xpath(objec.getProperty("BookAnExam.PickStartDate.Xpath")));
					 WebElement selectedExamStartDate = examStartDates.get(rn.nextInt(examStartDates.size()==1 ? 1 :examStartDates.size()-1));
					 selectedExamStartDate.click();
				}
			}
		}
		return this;
	}
	
	public ExamSelectCourse_Page ClickContinue() throws InterruptedException
	{
		clickById(objec.getProperty("BookAnExam.ContinueBtn.ID"));
		return this;
	}
	
	private String PriceInfo;
	public Basket_page MoveToBasketPage() throws InterruptedException
	{
		PriceInfo = driver.findElement(By.className(objec.getProperty("BookAnExam.Price.Class"))).getText();
		if(driver.findElement(By.id(objec.getProperty("BookAnExam.AddToBasket.ID"))).isEnabled())
		{
			clickById(objec.getProperty("BookAnExam.AddToBasket.ID"));
		}
		
		CheckTotalPrice();
		
		return new Basket_page(driver, test);
	}
	
	public void CheckTotalPrice() throws InterruptedException
	{
		VerifyTextByClass(objec.getProperty("BasketPage.TotalPrice.Class"), PriceInfo);
	}
}
 