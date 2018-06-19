package retailweb_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentTest;
import wrappers.KaplanSpecificWrappers;

public class PaypalReview_page  extends KaplanSpecificWrappers{
	
	//To check that we are on paypal review page
	public PaypalReview_page(RemoteWebDriver driver, ExtentTest test){

		this.driver = driver;
		this.test = test;

		//if(!verifyTitle("PayPal Checkout - Review your payment")){
		//reportStep("This is not PaypalReview Page", "FAIL");}
	}
	
		//To click paypal paynow button
				public PaypalCompleted_Page clickPaynow() throws InterruptedException
				{
					try
					{
						Thread.sleep(5000);
						
					
					if (driver.findElement(By.id(objec.getProperty("PaypalReview.Paynow.Id"))).isDisplayed() && driver.findElement(By.id(objec.getProperty("PaypalReview.Paynow.Id"))).isEnabled())
					//WebDriverWait wait=new WebDriverWait(driver, 30);
					//wait.until(ExpectedConditions.elementToBeClickable(By.id(objec.getProperty("PaypalReview.Paynow.Id"))));
					{clickById(objec.getProperty("PaypalReview.Paynow.Id"));}
					return new PaypalCompleted_Page(driver, test);
					}
					catch(Exception ex)
					{
						return new PaypalCompleted_Page(driver, test);
					}
		}	
				//To click paypal paynow button
				public PaypalReview_page clickCancelLink() throws InterruptedException
				{
					Thread.sleep(5000);
					clickById(objec.getProperty("PaypalReview.Cancel.Id"));
					return this;
		}	
}
