package retailweb_pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KaplanSpecificWrappers;

public class Reviewdetails_page extends KaplanSpecificWrappers 
{
 
 public Reviewdetails_page(RemoteWebDriver driver, ExtentTest test)
 {

  this.driver = driver;
  this.test = test;
  if(!verifyTitleContains("ReviewDetails"))
  {
     reportStep("This is not Select a review details Page", "FAIL");
  }
 }
 //To verify the Page heading displayed 
 
  public Reviewdetails_page verifyPageHeading() 
  {
   verifyTextByXPath(objec.getProperty("ReviewDetailsPage.PageHeading.Xpath"), "Review your details");
   return this;
  }
 //To verify the Payment details section is displayed 
  
  public Reviewdetails_page verifyPaymentDetailsHeading() 
  {
      verifyTextByXPath(objec.getProperty("ReviewDetailsPage.PaymentDetailsPageHeading.Xpath"), "Payment details:");
   return this;
  }
 //To verify the Billing details section is displayed 
  
  public Reviewdetails_page verifyBillingDetailsHeading() 
  {
   verifyTextByXPath(objec.getProperty("ReviewDetailsPage.BillingAddressHeading.Xpath"), "Billing address:");
   return this;
   }
  //To verify the Delivery address details section is displayed 
  
    public Reviewdetails_page verifyDeliveryDetailsHeading() 
    {
     verifyTextByXPath(objec.getProperty("ReviewDetailsPage.DeliveryHeading.Xpath"), "Delivery address:");
     return this;
     }  
    //To click on edit button of card details 
    
    public Reviewdetails_page clickEditCard()
    {
     clickById(objec.getProperty("ReviewDetailsPage.EditCard.Id"));
     return this;
     }
    //To click on edit button of Billing Address 
    
    public Reviewdetails_page editBillingAddress()
    {
     clickById(objec.getProperty("ReviewDetailsPage.EditBilling.Id"));
     return this;
     }  
    
    //To Click on edit button of Delivery Address
    
    public Reviewdetails_page editDeliveryAddress()
    {
     clickById(objec.getProperty("ReviewDetailsPage.EditDelivery.Id"));
     return this;
     }     
  
    //To click on confirm and Pay
    
    public HPCIPaymentSecure_Page clickConfirmAndPay()
    {
     clickById(objec.getProperty("ReviewDetailsPage.ConfirmAndPay.Id"));
     return new HPCIPaymentSecure_Page(driver, test);
     }  
    
    //To click on Back To Billing
    
    public Reviewdetails_page clickBacktoBilling()
    {
     clickById(objec.getProperty("ReviewDetailsPage.BacktoBilling.Id"));
     return this;
     } 
   
    //To verify by card text
    
    public Reviewdetails_page verifyCardText(String text)
    {
     text="By Card";
     verifyTextByXPath(objec.getProperty("ReviewDetailsPage.Cardtext.Xpath"),text);
     return this;
     }
   
    //To click on accept checkbox
    
    public Reviewdetails_page clickAcceptcheckBox()
    {
     clickByXpath(objec.getProperty("ReviewDetailsPage.AcceptCheckbox.Xpath"));
     return this;
    }
    
  //To verify error message if not clicking on accept conditions
    public Reviewdetails_page verifyErrorMessage(String text)
    {
     text="You must check the Terms and Conditions before you can proceed";
     verifyTextByXPath(objec.getProperty("ReviewDetailsPage.ErrorMessage.Xpath"),text);
     return this;
     }
   }   
