package retailweb_pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import studentcenter_pages.Login_Page;
import wrappers.KaplanSpecificWrappers;

public class DeliveryAddress_Page  extends KaplanSpecificWrappers{
	public DeliveryAddress_Page(RemoteWebDriver driver, ExtentTest test){

		this.driver = driver;
		this.test = test;

		//if(!verifyTitle("Course Builder | Kaplan UK | Basket")){
		//reportStep("This is not AccountHome Page", "FAIL");}
	}
	//Enter AddressLineOne Value
	public DeliveryAddress_Page EnterDeliveryAddressLineOne(String lineOne)
	{
		enterDataById(objec.getProperty("DeliveryAddress.AddresslineOne.Id"), lineOne);
		return this;
	}
	
	public DeliveryAddress_Page EnterDeliveryAddressLineTwo(String lineTwo)
	{
		enterDataById(objec.getProperty("DeliveryAddress.AddresslineTwo.Id"), lineTwo);
		return this;
	}
	
	public DeliveryAddress_Page EnterDeliveryAddressTownCity(String towncity)
	{
		enterDataById(objec.getProperty("DeliveryAddress.TownCity.Id"), towncity);
		return this;
	}
	
	public DeliveryAddress_Page EnterDeliveryAddressCountry()
	{
		DropDownSelectionClassName(objec.getProperty("DeliveryAddress.Country.Class"));
		return this;
	}
	public DeliveryAddress_Page EnterDeliveryAddressPostcode(String postcode)
	{
		enterDataById(objec.getProperty("DeliveryAddress.Postcode.Id"), postcode);
		return this;
	}
	
	public DeliveryAddress_Page ClickDeliveryAddressSaveas()
	{
		clickById(objec.getProperty("DeliveryAddress.Save.Id"));
		return this;
	}
	
	public Checkout_page ClickDeliveryAddressContinue()
	{
		clickById(objec.getProperty("DeliveryAddress.Continue.Id"));
		return new Checkout_page(driver,test);
	}
	
	public Checkout_page AutomateDeliveryAddress(String addressLineOne, String addressLineTwo, String townCity, String postCode)
	{
		if(verifyTitle("DeliveryAddress"))
		{
			EnterDataByIdIfValueNotExists(objec.getProperty("DeliveryAddress.AddresslineOne.Id"), addressLineOne);
			EnterDataByIdIfValueNotExists(objec.getProperty("DeliveryAddress.AddresslineTwo.Id"), addressLineTwo);
			EnterDataByIdIfValueNotExists(objec.getProperty("DeliveryAddress.TownCity.Id"), townCity);
			DropDownSelectionClassName(objec.getProperty("DeliveryAddress.Country.Class"));
			EnterDataByIdIfValueNotExists(objec.getProperty("DeliveryAddress.Postcode.Id"), postCode);
			
			clickById(objec.getProperty("DeliveryAddress.Save.Id"));
			
			clickById(objec.getProperty("DeliveryAddress.Continue.Id"));
		}
		
		return new Checkout_page(driver, test);
	}
	
}
