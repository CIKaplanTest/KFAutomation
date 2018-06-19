package retailweb_pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import wrappers.KaplanSpecificWrappers;

public class PaypalLogin_page  extends KaplanSpecificWrappers{
	
	//To check that we are on paypal login page
	public PaypalLogin_page(RemoteWebDriver driver, ExtentTest test){

		this.driver = driver;
		this.test = test;

		//if(!verifyTitle("PayPal Checkout - Log In")){
		//reportStep("This is not PaypalLogin Page", "FAIL");}
	}
	//To enter paypal email
	public PaypalLogin_page enterEmailPaypal(String paypalEmail) throws InterruptedException
	{
		Thread.sleep(5000);
//		driver.switchTo().frame("injectedUl");
		enterDataById(objec.getProperty("PaypalLogin.Email.Id"),paypalEmail);
		clickById(objec.getProperty("PaypalLogin.EmailContinue.Id"));
		return this;

	}
	//To enter paypal password
		public PaypalLogin_page enterPasswordPaypal(String paypalPassword)
		{
			enterDataById(objec.getProperty("PaypalLogin.Password.Id"),paypalPassword);
			return this;
}	
		//To click paypal login
				public PaypalReview_page clickLoginPaypal() throws InterruptedException
				{
					clickById(objec.getProperty("PaypalLogin.Login.Id"));
					Thread.sleep(3000);
					return new PaypalReview_page(driver, test);
		}	
}
