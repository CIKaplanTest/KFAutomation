package retailweb_pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import wrappers.KaplanSpecificWrappers;

public class Checkout_page extends KaplanSpecificWrappers{

	public Checkout_page(RemoteWebDriver driver, ExtentTest test){

		this.driver = driver;
		this.test = test;

		//if(!verifyTitle("Course Builder | Kaplan UK | Checkout")){
		//	reportStep("This is not Checkout Page", "FAIL");
		//	}
	}
	//To click on secure checkout button
	public Checkout_page clickSecureCheckout()
	{
		clickById(objec.getProperty("CheckoutPage.SecureCheckout.ID"));
		return this;
	}

	//PayPal section
	public Checkout_page selectPayPal()
	{
		clickById(objec.getProperty("CheckoutPage.SelectPayPal.ID"));
		return this;
	}
	
	public Checkout_page acceptPayPalTerms()
	{
		clickById(objec.getProperty("CheckoutPage.PaypalTermsAcceptance.ID"));
		return this;
	}

	public PaypalLogin_page payWithPaypal()
	{
		clickById(objec.getProperty("CheckoutPage.PaywithPaypal.ID"));
		return new PaypalLogin_page(driver,test);
	}
	
	//Card section
	public Checkout_page SelectCard()
	{
		clickById(objec.getProperty("CheckoutPage.SelectCard.ID"));
		return this;
	}
	
	public Checkout_page EnterCreditCardNumber(String creditCardNumber)
	{
		driver.switchTo().frame(driver.findElement(By.id(objec.getProperty("CheckoutPage.CardFrame.ID"))));
		enterDataById(objec.getProperty("CheckoutPage.CreditCardNumber.ID"), creditCardNumber);
		return this;
	}
	
	public Checkout_page EnterSecurityCode(String securityCode)
	{
		enterDataById(objec.getProperty("CheckoutPage.SecurityCode.ID"), securityCode);
		return this;
	}
	
	public Checkout_page SelectExpiryMonth() throws InterruptedException
	{
		driver.switchTo().parentFrame();
		DropDownSelection(objec.getProperty("CheckoutPage.ExpiryMonth.Xpath"));
		Thread.sleep(1000);
		return this;
	}
	
	public Checkout_page SelectExpiryYear() throws InterruptedException
	{
		DropDownSelection(objec.getProperty("CheckoutPage.ExpiryYear.Xpath"));
		Thread.sleep(1000);
		return this;
	}
	
	public Checkout_page EnterNameOnCard(String CardName)
	{
		EnterDataByClass(objec.getProperty("CheckoutPage.NameOnCard.Class"), CardName);
		return this;
	}
	
	public Checkout_page SelectIssueNumber() throws InterruptedException
	{
		DropDownSelection(objec.getProperty("CheckoutPage.IssueNumber.Xpath"));
		Thread.sleep(1000);
		return this;
	}
	
	public BillingAddress_Page ClickContinue() throws InterruptedException
	{	
		clickById(objec.getProperty("CheckoutPage.Continue.ID"));
		return new BillingAddress_Page(driver, test);
	}
		
	public Checkout_page VerifyPaymentSubmit()
	{
		clickByXpath(objec.getProperty("CheckoutPage.SubmitPayment.Xpath"));
		return this;
	}
	
	//Invoice My Employer
	 //To click on Invoice My Employer Accordion
	 public Checkout_page SelectInvoiceEmployer()
	 {
	  clickByXpath(objec.getProperty("InvoiceMyEmployer.Accordion.Xpath"));
	  return this;
	 } 
	 
	 //To enter Company Name
	  public Checkout_page enterCompanyname(String CompName)
	  {
	   enterDataById(objec.getProperty("InvoiceMyEmployer.CompanyName.Id"),CompName);
	   return this;
	  }
	  //To enter Company Reg No
	    public Checkout_page enterCompanyRegNo(String regNo)
	    {
	     enterDataById(objec.getProperty("InvoiceMyEmployer.CompanyRegNo.Id"),regNo);
	     return this;
	    }
	    
	    //To enter purchaseOrderNo
	    public Checkout_page enterPurchaseOrderNo(String purchaseOrderNo )
	    {
	     enterDataById(objec.getProperty("InvoiceMyEmployer.PurchaseOrderNo.Id"),purchaseOrderNo);
	     return this;
	    }
	    
	    //To enter Training Manager Name
	    public Checkout_page TrainingMgrName(String trainingMgrName )
	    {
	     enterDataById(objec.getProperty("InvoiceMyEmployer.TrainingMgrName.Id"),trainingMgrName);
	     return this;
	    }
	    //To enter Training Manager Email
	    public Checkout_page TrainingMgrEmail(String trainingMgrEmail )
	    {
	     enterDataById(objec.getProperty("InvoiceMyEmployer.TrainingMgrEmail.Id"),trainingMgrEmail);
	     enterDataById(objec.getProperty("InvoiceMyEmployer.ConfirmTrainingMgrEmail.Id"),trainingMgrEmail);
	     return this;
	    }
	 
	    //To enter Addreesline1
	    public Checkout_page addLine1(String addline1 )
	    {
	     enterDataById(objec.getProperty("InvoiceMyEmployer.AddressLine1.Id"),addline1);
	     return this;
	    }
	    //To enter Addreesline2
	    public Checkout_page addLine2(String addline2 )
	    {
	     enterDataById(objec.getProperty("InvoiceMyEmployer.AddressLine2.Id"),addline2);
	     return this;
	    }
	    
	    //To enter City
	    public Checkout_page enterCity(String city )
	    {
	     enterDataById(objec.getProperty("InvoiceMyEmployer.City.Id"),city);
	     return this;
	    }
	    
	    //To enter Postcode
	    
	    public Checkout_page enterPostCode(String postcode )
	    {
	     enterDataById(objec.getProperty("InvoiceMyEmployer.PostCode.Id"),postcode);
	     return this;
	    }
	    
	    public Checkout_page CheckInvoiceAddress()
	    {
	    	clickByXpath(objec.getProperty("InvoiceMyEmployer.CheckboxInvoiceAddress.Xpath"));
	    	return this;
	    }
	  //To enter Invoice Addreesline1
	    public Checkout_page InvoiceAddLine1(String addline1 )
	    {
	     enterDataById(objec.getProperty("InvoiceMyEmployer.InvoiceAddressLine1.Id"),addline1);
	     return this;
	    }
	    //To enter Invoice Addreesline2
	    public Checkout_page InvoiceAddLine2(String addline2 )
	    {
	     enterDataById(objec.getProperty("InvoiceMyEmployer.InvoiceAddressLine2.Id"),addline2);
	     return this;
	    }
	    
	    //To enter Invoice City
	    public Checkout_page InvoiceEnterCity(String city )
	    {
	     enterDataById(objec.getProperty("InvoiceMyEmployer.InvoiceCity.Id"),city);
	     return this;
	    }
	    
	    //To enter Invoice Postcode
	    
	    public Checkout_page InvoiceEnterPostCode(String postcode )
	    {
	     enterDataById(objec.getProperty("InvoiceMyEmployer.InvoicePostCode.Id"),postcode);
	     return this;
	    }
	    
	    //To click accept conditions
	    public Checkout_page clickAcceptConditions ()
	    {
	     clickById(objec.getProperty("InvoiceMyEmployer.AcceptConditions.ID"));
	     return this;
	    }
	    //To click Confirm and Pay
	    public Checkout_page clickConfirmandPay () throws InterruptedException
	    {
	     clickById(objec.getProperty("InvoiceMyEmployer.ConfirmAndPay.id"));
	     Thread.sleep(5000);
	     return this;
	    }    
	    
	    public Checkout_page GoToApprovalPage()
	    {
	    	OpenNewTabWindow("gopaldhiyashri29@gmail.com");
	    	return this;
	    }
}


