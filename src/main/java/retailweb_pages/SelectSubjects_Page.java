package retailweb_pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import wrappers.KaplanSpecificWrappers;


public class SelectSubjects_Page extends KaplanSpecificWrappers {
	
	
	//Confirming that we are in Select your subjects Page
	public SelectSubjects_Page(RemoteWebDriver driver, ExtentTest test){
		
		this.driver = driver;
		this.test = test;
		//if(!verifyTitle("Course Builder | Kaplan UK | Subjects")){
		//	reportStep("This is not Select your subjects Page", "FAIL");
		}
	
	
	//To select All Papers check box
	
	public SelectSubjects_Page selectAllPapers()
	{
    List<WebElement> subjects=driver.findElements(By.id("all-subjects-chk-AAT"));
    subjects.get(0).click();
	return this;
	}
	
	//To select Paper1 check box

	public SelectSubjects_Page selectPaper1() throws InterruptedException
	{
		Thread.sleep(3000);
		 List<WebElement> subjects= driver.findElements(By.className("checkbox-label"));
		 subjects.get(1).click();
		 return this;
	}
	public SelectSubjects_Page selectPaper2() throws InterruptedException
	{
		Thread.sleep(3000);
		 List<WebElement> subjects= driver.findElements(By.className("checkbox-label"));
		 subjects.get(2).click();
		 return this;
	}
	
	//To select Paper2 check box

	public SelectSubjects_Page selectRandom() throws InterruptedException
	{
    //List<WebElement> subjects=driver.findElements(By.className("checkbox"));
	Thread.sleep(4000);
	WebDriverWait wait=new WebDriverWait(driver, 30);
	List<WebElement> subjects= wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("checkbox-label")));
    Random rnd=new Random();
    //List<WebElement> subject= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By.className("checkbox"))));
    System.out.println(subjects.size()); 
    int cnt1=   rnd.nextInt(subjects.size()-1);
  //  subjects.get(rnd.nextInt(subjects.size()-1)).click();
    if(cnt1==0)
    {
    	 subjects.get(1).click();	
    }
    else
    {
    	 subjects.get(rnd.nextInt(subjects.size()-1)).click();
    }
	return this;
	}
	
	//To select Paper3 check box

	public SelectSubjects_Page selectPaper3()
	{
    List<WebElement> subjects=driver.findElements(By.className("checkbox-label"));
    subjects.get(3).click();
	return this;
	}
	
	//To select Paper4 check box
	
	public SelectSubjects_Page selectPaper4()
	{
    List<WebElement> subjects=driver.findElements(By.className("checkbox-label"));
    subjects.get(4).click();
	return this;
	}
	
	//To select Paper5 check box
	
		public SelectSubjects_Page selectPaper5()
		{
	    List<WebElement> subjects=driver.findElements(By.className("checkbox-label"));
	    subjects.get(5).click();
		return this;
		}
		
		//To select Paper6 check box
		
			public SelectSubjects_Page selectPaper6()
			{
		    List<WebElement> subjects=driver.findElements(By.className("checkbox-label"));
		    subjects.get(6).click();
			return this;
			}
	
		//To select Paper7 check box
			
			public SelectSubjects_Page selectPaper7()
			{
				List<WebElement> subjects=driver.findElements(By.className("checkbox-label"));
			    subjects.get(7).click();
				return this;
			}
			
      //To select Paper8 check box
			
			public SelectSubjects_Page selectPaper8()
			{
		    List<WebElement> subjects=driver.findElements(By.className("checkbox-label"));
		    subjects.get(8).click();
			return this;
			}  
			
       //To select Paper9 check box
			
			public SelectSubjects_Page selectPaper9() throws InterruptedException
			{
		    Thread.sleep(2000);
		    List<WebElement> subjects=driver.findElements(By.className("checkbox-label"));
		    WebDriverWait wait=new WebDriverWait(driver, 30);
		    wait.until(ExpectedConditions.elementToBeSelected(subjects.get(9)));
		    subjects.get(9).click();
			return this;
			}
	//To click on Choose Study Options Button

	public Selectsubjectteditstudyoptions_Page clickChooseStudyOptions () throws InterruptedException
	{
		Thread.sleep(2000);
		 clickById(objec.getProperty("SelectSubjects.ChooseStudyOptions.Id"));
		 return new Selectsubjectteditstudyoptions_Page(driver, test);
	}

	//To verify the page label
	
	public SelectSubjects_Page verifyPageLabel (String label)
	{
		 verifyTextByClass(objec.getProperty("SelectSubjects.ScreenLabel.Class"),label);
		 return this;
	}


	



}
