package retailweb_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import wrappers.KaplanSpecificWrappers;

public class PaypalCompleted_Page  extends KaplanSpecificWrappers{
	
	//To check that we are on paypal completed page
	public PaypalCompleted_Page(RemoteWebDriver driver, ExtentTest test){

		this.driver = driver;
		this.test = test;

	//	if(!verifyTitle("PayPal Checkout - Payment completed!")){
		//reportStep("This is not PaypalCompleted Page", "FAIL");}
	}
	
		//To click paypal paynow button
				public PaypalCompleted_Page clickReturnToMerchant() throws InterruptedException
				{
					Thread.sleep(3000);
					//WebDriverWait wait=new WebDriverWait(driver,20);
					//wait.until(ExpectedConditions.elementToBeClickable(By.id(objec.getProperty("PaypalCompleted.ReturnToMerchant.Id"))));
					clickByXpath(objec.getProperty("PaypalLogin.ReturnToMerchant.Xpath"));
					return this;
		}	
}
