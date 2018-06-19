package retailweb_pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KaplanSpecificWrappers;

public class HPCIPaymentSecure_Page extends KaplanSpecificWrappers
{
	public HPCIPaymentSecure_Page(RemoteWebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("Course Builder | Kaplan UK | Checkout"))
		{
			reportStep("This is not HPCI payment secure Page", "FAIL");
		}
	}
	
	public HPCIPaymentSecure_Page ClickSubmit()
	{
		clickByXpath(objec.getProperty("HPCI.Heading.Xpath"));
		return this;
	}
}
