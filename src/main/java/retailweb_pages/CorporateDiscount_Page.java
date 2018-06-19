package retailweb_pages;


import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.google.common.base.Verify;
import com.relevantcodes.extentreports.ExtentTest;

import studentcenter_pages.CompleteRegistration_Page;
import studentcenter_pages.KaplanFinancialCourses_Page;
import studentcenter_pages.Login_Page;
import wrappers.KaplanSpecificWrappers;

public class CorporateDiscount_Page  extends KaplanSpecificWrappers
{


	public CorporateDiscount_Page(RemoteWebDriver driver, ExtentTest test)
	{

		this.driver = driver;
		this.test = test;

		if(!verifyTitle("CorporateDiscount"))
		{
		reportStep("This is not CorporateDiscount Page", "FAIL");
		}
	}
	
//Verify Existing WorkEmail Present
	public CorporateDiscount_Page verifyExistingWorkEmailStatus(String WorkEmail,String description,String status)
	{
		String WorkEmailtextBox =driver.findElement(By.id("workEmailAddress")).getText();
		String descsuccess =driver.findElement(By.className("verify-email-verified-messsage")).getText();
		String descfailure =driver.findElement(By.className("verify-email-warning-messsage")).getText();
		
		if((WorkEmail!= null && WorkEmail==WorkEmailtextBox))
		{
			descsuccess = description;
			reportStep(descsuccess, "PASS");
		}
		else 
		{
			if(descfailure.equals(description))
			{
				reportStep(descfailure,"FAIL");
			}
		}
		
		return this;
		}

	//Verify New WorkEmail FirstTime
		public CorporateDiscount_Page verifyNewWorkEmailStatus(String WorkEmail,String description,String status)
		{
			String WorkEmailtextBox =driver.findElement(By.id("workEmailAddress")).getText();
			
			String descfailure =driver.findElement(By.className("verify-email-warning-messsage")).getText();
			
			
			if(WorkEmailtextBox .isEmpty())
			{
				enterDataById((objec.getProperty("Corporate.WorkEmailAddress.ID")), WorkEmail);
				clickById((objec.getProperty("Corporate.VerifyEmailAddressButton.ID")));
				String descsuccess =driver.findElement(By.className("verify-email-verified-messsage")).getText();
				descsuccess = description;
				reportStep(descsuccess, "PASS");
				
			}
			else  {
				if(descfailure.equals(description))
				reportStep(descfailure,"FAIL");
			}
			return this;
			}	
//Edit the WorkEmail
		public CorporateDiscount_Page EditWorkEmail(String WorkEmail,String description,String status)
		{
			String WorkEmailtextBox =driver.findElement(By.id("workEmailAddress")).getText();
			
			String descfailure =driver.findElement(By.className("verify-email-warning-messsage")).getText();
			
			
			if(WorkEmailtextBox!= null)
			{
				
				clickById((objec.getProperty("Corporate.WorkEmailEditButton.ID")));
				enterDataById((objec.getProperty("Corporate.WorkEmailAddress.ID")), WorkEmail);
				clickById((objec.getProperty("Corporate.VerifyEmailAddressButton.ID")));
				String descsuccess =driver.findElement(By.className("verify-email-verified-messsage")).getText();
				descsuccess = description;
				reportStep(descsuccess, "PASS");
				
			}
			else  {
				if(descfailure.equals(description))
				reportStep(descfailure,"FAIL");
			}
			return this;
			}
}
