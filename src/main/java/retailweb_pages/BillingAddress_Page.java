package retailweb_pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import wrappers.KaplanSpecificWrappers;

public class BillingAddress_Page  extends KaplanSpecificWrappers{
	public BillingAddress_Page(RemoteWebDriver driver, ExtentTest test){

		this.driver = driver;
		this.test = test;

		//if(!verifyTitle("Course Builder | Kaplan UK | Basket")){
		//reportStep("This is not AccountHome Page", "FAIL");}
	}
	
	public Reviewdetails_page AutomateBilingAddress(String lineOne, String lineTwo, String towncity, String postcode)
	{
		EnterBillingAddressLineOne(lineOne);
		EnterBillingAddressLineTwo(lineTwo);
		EnterBillingAddressTownCity(towncity);
		EnterBillingAddressCountry();
		EnterDeliveryAddressPostcode(postcode);
		ClickBillingAddressContinue();
		
		return new Reviewdetails_page(driver,test);
	}
	
	//Enter AddressLineOne Value
	private BillingAddress_Page EnterBillingAddressLineOne(String lineOne)
	{
		enterDataById(objec.getProperty("BillingAddress.AddresslineOne.Id"), lineOne);
		return this;
	}
	
	private BillingAddress_Page EnterBillingAddressLineTwo(String lineTwo)
	{
		enterDataById(objec.getProperty("BillingAddress.AddresslineTwo.Id"), lineTwo);
		return this;
	}
	
	private BillingAddress_Page EnterBillingAddressTownCity(String towncity)
	{
		enterDataById(objec.getProperty("BillingAddress.TownCity.Id"), towncity);
		return this;
	}
	
	private BillingAddress_Page EnterBillingAddressCountry()
	{
		DropDownSelectionClassName(objec.getProperty("BillingAddress.Country.Class"));
		return this;
	}
	public BillingAddress_Page ClickBillingAddressBacktoPayment()
	{
		clickById(objec.getProperty("BillingAddress.BacktoPayment.Id"));
		return this;
	}
	
	private BillingAddress_Page EnterDeliveryAddressPostcode(String postcode)
	{
		enterDataById(objec.getProperty("BillingAddress.Postcode.Id"), postcode);
		return this;
	}
	
	private Reviewdetails_page ClickBillingAddressContinue()
	{
		clickById(objec.getProperty("BillingAddress.Continue.Id"));
		return new Reviewdetails_page(driver,test);
	}
	
	
}
