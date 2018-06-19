package retailweb_pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import studentcenter_pages.Login_Page;
import wrappers.KaplanSpecificWrappers;

public class Basket_page  extends KaplanSpecificWrappers{
	public Basket_page(RemoteWebDriver driver, ExtentTest test){

		this.driver = driver;
		this.test = test;

		//if(!verifyTitle("Course Builder | Kaplan UK | Basket")){
		//reportStep("This is not AccountHome Page", "FAIL");}
	}
	//To click on secure checkout button for already logged in user
	public DeliveryAddress_Page clickSecureCheckoutLoggedInUser()
	{
		clickById(objec.getProperty("BasketPage.SecureCheckout.ID"));
		return new DeliveryAddress_Page(driver, test);

	}
	//To click on secure checkout button for not logged in user
		public Login_Page clickSecureCheckoutNotLoggedInUser()
		{
			clickById(objec.getProperty("BasketPage.SecureCheckout.ID"));
			return new Login_Page(driver, test);

		}
	//To verify the basket text
	public Basket_page basketTextCheck(String basket)
	{
		verifyTextByClass(objec.getProperty("BasketPage.CheckoutText.Class"), basket);
		return this;
	}
	//To verify the basket count
	public Basket_page basketCountCheck(String count)
	{
		try {
			String cnt=driver.findElementByClassName((objec.getProperty("BasketPage.CheckoutText.Class"))).getText();
			String[] str=cnt.split("(");
			String bcnt=str[1].substring(1,1);
			//verifyTextByClass((objec.getProperty("BasketPage.CheckoutText.Class")),count);
			if(bcnt.contentEquals(count))
			{
				reportStep("The basket count is matching", "PASS");
			}
			else
			{
				reportStep("The basket count is not matching", "FAIL");
			}
		} catch (Exception e) {

			reportStep("Unknown exception occured while verifying the title", "FAIL");

		}
		return this;
	}
	
	//To Click on the Preferential Terms and click on VerifyEmail
	
	public Basket_page expandPreferentialTerms()
	{
	clickByXpath(objec.getProperty("BasketPage.Preferentialterms.xpath"));
		return this;
		
	}
	
	public CorporateDiscount_Page clickVerifyEmail()
	{
	clickBylinkText(objec.getProperty("Preferentialterms.verifyemail.Linktext "));
		return new CorporateDiscount_Page(driver, test);
	}
	
	
	
}
