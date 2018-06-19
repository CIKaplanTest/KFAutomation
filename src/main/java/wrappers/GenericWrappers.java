package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.util.Strings;

import com.gargoylesoftware.htmlunit.javascript.host.Element;
import com.relevantcodes.extentreports.ExtentTest;

import DataBaseHelper.DBUrlHelper;
import utils.Reporter;

public class GenericWrappers extends Reporter implements Wrappers {

	public RemoteWebDriver driver;
	protected static Properties pro;
	public String sUrl, primaryWindowHandle, sHubUrl, sHubPort;
	protected String objecFile = "object.properties";
	private String propertyLocation = "resources/";
	protected static Properties objec = null;

	public GenericWrappers() {
		Properties pro = new Properties();
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			URL url = classLoader.getResource("configuration.properties");
			System.out.println("GW1: " + url);
			System.out.println("GW1: " + url.toURI());
			pro.load(new FileInputStream(new File(url.getFile())));
			sHubUrl = pro.getProperty("HUB");
			sHubPort = pro.getProperty("PORT");
			// String ActiveUrl=pro.getProperty("userURl");
			sUrl = pro.getProperty("userURl");
		} catch (FileNotFoundException e) {
			System.out.println("FNF in GW1");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO in GW1");
		}
	}

	public GenericWrappers(RemoteWebDriver driver, ExtentTest test) {

		this.driver = driver;
		this.test = test;

		Properties pro = new Properties();

		try {
			ClassLoader classLoader = getClass().getClassLoader();
			URL url = classLoader.getResource("configuration.properties");
			System.out.println("GW2: " + url);
			System.out.println("GW2: " + url.toURI());
			pro.load(new FileInputStream(new File(url.getFile())));
			sHubUrl = pro.getProperty("HUB");
			sHubPort = pro.getProperty("PORT");
			sUrl = pro.getProperty("URL");
		} catch (FileNotFoundException e) {
			System.out.println("FNF in GW2");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO in GW2");
		}

	}

	/*
	 * public void loadObjects() { Properties pro = new Properties(); try {
	 * //ClassLoader classLoader = getClass().getClassLoader(); //pro.load(new
	 * FileInputStream(new
	 * File(classLoader.getResource("object.properties").getFile())));
	 * pro.load(App.class.getClassLoader().getResourceAsStream("object.properties"))
	 * ; } catch (FileNotFoundException e) { e.printStackTrace(); } catch
	 * (IOException e) { e.printStackTrace(); } } objec = new Properties(); try {
	 * FileInputStream ip = new FileInputStream(propertyLocation + objectFile); try
	 * { objec.load(ip); System.out.println(objec); } catch (IOException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } } catch
	 * (FileNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */
	public void loadObjects() {
		objec = new Properties();
		try {
			// objec.load(ip);
			ClassLoader classLoader = getClass().getClassLoader();
			objec.load(new FileInputStream(new File(classLoader.getResource("object.properties").getFile())));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void unloadObjects() {
		// pro=null;
		// added
		objec = null;
	}

	/**
	 * This method will launch the browser in local machine and maximise the browser
	 * and set the wait for 30 seconds and load the url
	 * 
	 * @author Divya Suravarjula - Kaplan
	 * @param url
	 *            - The url with http or https
	 * 
	 */
	public void invokeApp(String browser, String strUrl) {
		sUrl = strUrl;
		invokeApp(browser);
	}

	public void invokeApp(String browser) {

		invokeApp(browser, false);
	}

	/**
	 * This method will take snapshot of the browser
	 * 
	 * @author Divya Suravarjula - Kaplan
	 */
	public long takeSnap() {
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE),
					new File("./reports/images/" + number + ".jpg"));
		} catch (WebDriverException e) {
			reportStep("The browser has been closed.", "FAIL");
		} catch (IOException e) {
			reportStep("The snapshot could not be taken", "WARN");
		}
		return number;
	}

	/**
	 * This method will launch the browser in grid node (if remote) and maximise the
	 * browser and set the wait for 30 seconds and load the url
	 * 
	 * @author Divya Suravarjula - Kaplan
	 * @param browser
	 *            - The browser of the application to be launched
	 * @param url
	 *            - The url with http or https
	 * @throws Exception
	 */

	public void invokeApp(String browser, boolean bRemote) {
		String[] arrBrowser = browser.split(",");
		Properties pro = new Properties();
		try {

			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName(arrBrowser[0]);
			dc.setPlatform(Platform.WINDOWS);

			// this is for grid run

			if (bRemote) {
				driver = new RemoteWebDriver(new URL("https://" + sHubUrl + ":" + sHubPort + "/wd/hub"), dc);
			}
			// This is for local run
			else {
				if (arrBrowser[0].equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
					driver = new ChromeDriver();
				} else {
					System.setProperty("webdriver.Firefox.driver", "./Drivers/geckodriver.exe");
					driver = new FirefoxDriver();
				}
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// if(arrBrowser.length>1)
			// {
			// String UrlName = arrBrowser[1];
			// sUrl=pro.getProperty(UrlName);
			// }

			driver.get(sUrl);
			primaryWindowHandle = driver.getWindowHandle();
			reportStep("The browser " + arrBrowser[0] + " is launched successfully", "PASS");
		} catch (Exception e) {
			e.printStackTrace();
			reportStep("The browser " + arrBrowser[0] + " is not launched", "FAIL");
		}

	}

	/**
	 * This method will close all browsers
	 * 
	 * @author Divya Suravarjula - Kaplan
	 */
	public void closeAllBrowsers() {
		try {
			driver.quit();
		} catch (Exception e) {
			reportStep("The browser could not be closed", "WARN");
		}
	}

	/**
	 * This method will close all browsers
	 * 
	 * @author Divya Suravarjula - Kaplan
	 */
	public void closeBrowser() {
		try {
			driver.close();
		} catch (Exception e) {

			reportStep("The browser could not be closed", "WARN");
		}
	}

	/**
	 * This method will enter the data in the text field using ID as locator
	 * 
	 * @author Divya Suravarjula - Kaplan
	 * @param IdValue
	 *            - The locator ID value of the web element
	 */
	public void enterDataById(String id, String text) {
		try {
			driver.findElement(By.id(id)).clear();
			driver.findElement(By.id(id)).sendKeys(text);
			reportStep("The data " + text + " is entered in " + id, "PASS");
		} catch (NoSuchElementException e) {
			reportStep("The data " + text + " could not be entered in " + id, "FAIL");
		}
	}
	
	public void EnterDataByIdIfValueNotExists(String id, String text) {
		try 
		{
			WebElement element = driver.findElement(By.id(id));
			if(Strings.isNullOrEmpty(element.getText()))
			{
				element.clear();
				element.sendKeys(text);
			}
			reportStep("The data " + text + " is entered in " + id, "PASS");
		}
		catch (NoSuchElementException e) 
		{
			reportStep("The data " + text + " could not be entered in " + id, "FAIL");
		}
	}
	
	public void enterDataByXpath(String xpath, String text) {
		try {
			driver.findElement(By.xpath(xpath)).clear();
			driver.findElement(By.xpath(xpath)).sendKeys(text);
			reportStep("The data " + text + " is entered in " + xpath, "PASS");
		} catch (NoSuchElementException e) {
			reportStep("The data " + text + " could not be entered in " + xpath, "FAIL");
		}
	}
	
	/**
	 * This method will enter the data in the text field using class name as locator
	 * 
	 * @author Bharath Jegadeesan - Kaplan
	 * @param classValue
	 *            - The locator class name of the web element
	 */
	public void EnterDataByClass(String classValue, String text) {
		try {
			driver.findElement(By.className(classValue)).clear();
			driver.findElement(By.className(classValue)).sendKeys(text);
			reportStep("The data " + text + " is entered in " + classValue, "PASS");
		} catch (NoSuchElementException e) {
			reportStep("The data " + text + " could not be entered in " + classValue, "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while entering " + text + "in " + classValue, "FAIL");
		}
	}
	
	/**
	 * This method will enter the data in the text field using xpath as locator
	 * 
	 * @author Bharath Jegadeesan - Kaplan
	 * @param classValue
	 *            - The locator xpath of the web element
	 */
	public void EnterDataByXpath(String XpathValue, String text) {
		try {
			driver.findElement(By.xpath(XpathValue)).clear();
			driver.findElement(By.xpath(XpathValue)).sendKeys(text);
			reportStep("The data " + text + " is entered in " + XpathValue, "PASS");
		} catch (NoSuchElementException e) {
			reportStep("The data " + text + " could not be entered in " + XpathValue, "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while entering " + text + "in " + XpathValue, "FAIL");
		}
	}
	
	/**
	 * This method will select the data in the dropdown using Xpath as locator
	 * 
	 * @author Bharath Jegadeesan - Kaplan
	 * @param classValue
	 *            - The locator class name of the web element
	 */
	public void DropDownSelection(String dropDownXpath) {
		try 
		{
			WebElement inputElement = driver.findElement(By.xpath(dropDownXpath));
			inputElement.click();
			List<WebElement> dropDownElements = driver.findElements(By.xpath(objec.getProperty("CheckoutPage.CurrentDropdown.Xpath")));
			Random rand = new Random();
			int randomProduct = rand.nextInt(dropDownElements.size()-1);
			dropDownElements.get(randomProduct).click();
		}
		catch (NoSuchElementException e)
		{
			reportStep("The data could not be selected ", "FAIL");
		}
		catch (Exception e) 
		{
			reportStep("Unknown exception occured while selection ", "FAIL");
		}
	}
	
	public void DropDownSelectionClassName(String dropDownClassNameValue) {
		  try 
		  {
		   WebElement inputElement = driver.findElement(By.className(dropDownClassNameValue));
		   inputElement.click();
		   List<WebElement> dropDownElements = driver.findElements(By.className((dropDownClassNameValue)));
		   Random rand = new Random();
		   int randomProduct = rand.nextInt(dropDownElements.size()-1);
		   dropDownElements.get(randomProduct).click();
		  }
		  catch (NoSuchElementException e)
		  {
		   reportStep("The data could not be selected ", "FAIL");
		  }
		  catch (Exception e) 
		  {
		   reportStep("Unknown exception occured while selection ", "FAIL");
		  }
		 }
	
	public void RandomDropDownSelectionById(String dropDownIdValue) {
		  try 
		  {
		   WebElement inputElement = driver.findElement(By.id(dropDownIdValue));
		   inputElement.click();
		   List<WebElement> dropDownElements = driver.findElements(By.id((dropDownIdValue)));
		   Random rand = new Random();
		   int randomProduct = rand.nextInt(dropDownElements.size()-1);
		   dropDownElements.get(randomProduct).click();
		  }
		  catch (NoSuchElementException e)
		  {
		   reportStep("The data could not be selected ", "FAIL");
		  }
		  catch (Exception e) 
		  {
		   reportStep("Unknown exception occured while selection ", "FAIL");
		  }
		 }
	
	public void OpenNewTabWindow(String emailId)
	{
		try
		{
			driver.executeScript("window.open('about:blank', '_blank');");

		    Set<String> tab_handles = driver.getWindowHandles();
		    int number_of_tabs = tab_handles.size();
		    int new_tab_index = number_of_tabs-1;
		    driver.switchTo().window(tab_handles.toArray()[new_tab_index].toString());
		  
		    driver.get(DBUrlHelper.GetApprovalURL(emailId));
		    //driver.get("http://sys.kaplan.co.uk/SponsoredRequest?OrderId=KF1228&approvalcode=fa170aa2-7d34-4f6e-a14c-834a2df224cc");
			//driver.get("http://only-testing-blog.blogspot.in/2014/05/form.html");
		}
		catch (Exception e)
		{
			reportStep("Can't open new tab", "FAIL");
		}
	}

	/**
	 * This method will click the web element by using linktext as an locator
	 * 
	 * @author Divya Suravarjula - Kaplan
	 * @param linkValue
	 *            - The linktext value of the web element
	 */
	public void clickBylinkText(String linkValue) {
		try {
			driver.findElement(By.linkText(linkValue)).click();
			reportStep("The web element " + linkValue + " is clicked", "PASS");
		} catch (NoSuchElementException e) {
			reportStep("The web element " + linkValue + " is not clickable", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while clicking " + linkValue, "FAIL");
		}
	}

	/**
	 * This method will click the web element by using Class as an locator
	 * 
	 * @author Divya Suravarjula - Kaplan
	 * @param classValue
	 *            - The class attribute value of the web element
	 */
	public void clickByClassName(String classValue) {
		try {

			driver.findElement(By.className(classValue)).click();
			reportStep("The web element " + classValue + " is clicked", "PASS");
		} catch (NoSuchElementException e) {
			reportStep("The web element " + classValue + " is not clickable", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while clicking " + classValue, "FAIL");
		}
	}

	/**
	 * This method will click the element using xpath as locator
	 * 
	 * @param xpathVal
	 *            The xpath (locator) of the element to be clicked
	 * @author Divya Suravarjula- Kaplan
	 */
	public void clickByXpath1(String xpathVal) {
		try {
			WebElement objWebElement1 = (WebElement) new Element();
			// new WebDriverWait(driver,
			// 50).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathVal)));
			Boolean flag = true;
			while (flag) {
				WebElement objWebElement2 = (WebElement) ExpectedConditions
						.visibilityOfElementLocated(By.xpath(xpathVal));
				if (objWebElement1 == objWebElement2) {
					flag = false;
					driver.findElement(By.xpath(xpathVal)).click();
				}
			}
			// System.out.println("The element with link name: "+name+" is clicked.");
			/*
			 * WebDriverWait wait = new WebDriverWait(driver, 50);
			 * //driver.findElement(By.xpath(xpathVal)).click(); WebElement element =
			 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVal)));
			 * element.click();
			 */
			// Thread.sleep(3000);
			reportStep("The element : " + xpathVal + " is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with xpath: " + xpathVal + " could not be clicked.", "FAIL");
		}
	}

	public void clickByXpath(String xpathVal) {
		try {

			// new WebDriverWait(driver,
			// 50).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathVal)));
			driver.findElement(By.xpath(xpathVal)).click();
			reportStep("The element : " + xpathVal + " is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with xpath: " + xpathVal + " could not be clicked.", "FAIL");
		}
	}
	
	public void clickRandomByXpath(String xpathVal) {
		try 
		{
			List<WebElement> items=driver.findElements(By.xpath(xpathVal));
			Random rn = new Random();
			int size = items.size()==1 ? 1 :items.size()-1;
			int rand = rn.nextInt(size);
			WebElement selectedItem = items.get(rand);
			selectedItem.click();
			
			reportStep("The element : " + xpathVal + " is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with xpath: " + xpathVal + " could not be clicked.", "FAIL");
		}
	}
	
	public void clickRandomByClassName(String className)
	{
		try 
		{
			List<WebElement> items=driver.findElements(By.className(className));
			Random rn = new Random();
			int size = items.size()==1 ? 1 :items.size()-1;
			int rand = rn.nextInt(size);
			WebElement selectedItem = items.get(rand);
			selectedItem.click();
			
			reportStep("The element : " + className + " is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with Class Name: " + className + " could not be clicked.", "FAIL");
		}
	}

	public void clickByXpathNoSnap(String xpathVal) {
		try {
			driver.findElement(By.xpath(xpathVal)).click();
			reportStep("The element : " + xpathVal + " is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with xpath: " + xpathVal + " could not be clicked.", "FAIL");
		}
	}

	public void clickById(String idVal) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(idVal)));
			element.click();
			reportStep("The element : " + idVal + " is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with ID value: " + idVal + " could not be clicked.", "FAIL");
		}
	}

	/**
	 * This method will verify the title of the browser
	 * 
	 * @param title
	 *            - The expected title of the browser
	 * @author Divya Suravarjula - Kaplan
	 */
	public boolean verifyTitle(String title) {
		boolean titlestatus = false;
		try {
			if (driver.getTitle().equalsIgnoreCase(title)) {
				reportStep("The title of the page is matching with the value " + title, "PASS");
				titlestatus = true;
			} else {
				reportStep("The title of the page is not matching", "FAIL");
			}
		} catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
		return titlestatus;

	}

	/**
	 * This method will verify the title of the browser
	 * 
	 * @param title
	 *            - The expected title of the browser
	 * @author Divya Suravarjula - Kaplan
	 */
	public boolean verifyTitleContains(String title) {
		return verifyTitleContains(title, true, true);
	}

	public boolean verifyTitleContains(String title, Boolean bSnap, Boolean bLog) {
		boolean titlestatus = false;
		try {
			if (driver.getTitle().contains(title)) {
				reportStep("The title of the page is matching with the value " + title, "PASS", bSnap, bLog);
				titlestatus = true;
			} else {
				reportStep("The title of the page is not matching", "FAIL", bSnap, bLog);
				titlestatus = false;
			}
		} catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
		return titlestatus;
	}

	/**
	 * This method will verify the text of web element using locator class
	 * 
	 * @param title
	 *            - The expected text of the element
	 * @author Divya Suravarjula - Kaplan
	 */
	@SuppressWarnings("deprecation")
	public void verifyTextByClass(String classValue, String text) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 100);
			String eText = driver.findElement(By.className(classValue)).getText();
			WebElement wb = driver.findElement(By.className(classValue));
			// System.out.println(wb);
			// System.out.println("test value"+eText);
			wait.until(ExpectedConditions.textToBe(By.className(classValue), text));
			// WebDriverWait wait = new WebDriverWait(driver, 10);
			// WebElement element =
			// wait.until(ExpectedConditions.textToBePresentInElement(By.className(classValue),
			// text)));
			// String eText=element.getText();
			// System.out.println(eText);

			if (eText.contains(text)) {
				reportStep("The text " + eText + " matches with given text value " + text, "PASS");
			} else {
				reportStep("The text " + eText + " is not matching with given value " + text, "FAIL");
			}
		} catch (Exception e) {

			System.out.println("this is excep" + e.getMessage());
			reportStep("Unknown exception occured while verifying the text", "FAIL");
		}
	}
	
	public boolean VerifyTextByClass(String classValue, String text) {
		try 
		{
			String eText = driver.findElement(By.className(classValue)).getText();

			if (eText.contains(text)) {
				reportStep("The text " + eText + " matches with given text value " + text, "PASS");
				return true;
			} else {
				reportStep("The text " + eText + " is not matching with given value " + text, "FAIL");
				return false;
			}
		} catch (Exception e) {

			System.out.println("this is excep" + e.getMessage());
			reportStep("Unknown exception occured while verifying the text", "FAIL");
			return false;
		}
	}

	public void verifyTextByXPath(String xPathValue, String text) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			String eText = driver.findElement(By.xpath(xPathValue)).getText();
			// WebElement wb=driver.findElement(By.className(xPathValue));
			// System.out.println(wb);
			// System.out.println("test value"+eText);
			// wait.until(ExpectedConditions.textToBe(By.className(xPathValue), text));
			// WebDriverWait wait = new WebDriverWait(driver, 10);
			// WebElement element =
			// wait.until(ExpectedConditions.textToBePresentInElement(By.className(classValue),
			// text)));
			// String eText=element.getText();
			// System.out.println(eText);

			if (eText.contains(text)) {
				reportStep("The text " + eText + "matches with given text value " + text, "PASS");
			} else {
				reportStep("The text " + eText + "is not matching with given value " + text, "FAIL");
			}
		} catch (Exception e) {

			System.out.println("this is excep" + e.getMessage());
			reportStep("Unknown exception occured while verifying the text", "FAIL");
		}
	}
	
	public boolean IsElementExistsByXpath(String XPath)
	{
		try
		{
			driver.findElement(By.xpath(XPath));
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	
	public boolean IsElementExistsByID(String elementID)
	{
		try
		{
			driver.findElement(By.id(elementID));
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}

	public String getTextById(String idVal) {
		String bReturn = "";
		try {
			return driver.findElementById(idVal).getText();
		} catch (Exception e) {
			reportStep("The element with id: " + idVal + " could not be found.", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method will accept the alert opened
	 * 
	 * @author Divya - Kaplan
	 */
	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
			reportStep("The alert is accepted", "PASS");
		} catch (NoAlertPresentException e) {
			reportStep("The alert could not be found.", "FAIL");
		} catch (Exception e) {
			reportStep("The alert could not be accepted.", "FAIL");
		}
	}

	/**
	 * This method will return the text of the alert
	 * 
	 * @author Divya Suravarjula - Kaplan
	 */
	public String getAlertText() {
		String text = null;
		try {
			text = driver.switchTo().alert().getText();
		} catch (NoAlertPresentException e) {
			reportStep("The alert could not be found.", "FAIL");
		} catch (Exception e) {
			reportStep("The alert could not be accepted.", "FAIL");
		}
		return text;
	}

	public void selectVisibileTextByXPath(String xpath, String value) {
		try {
			new Select(driver.findElement(By.xpath(xpath))).selectByVisibleText(value);
			reportStep("The element with xpath: " + xpath + " is selected with value :" + value, "PASS");
		} catch (Exception e) {
			reportStep("The value: " + value + " could not be selected.", "FAIL");
		}
	}

	public void getTextFromTable(String xpath, String text) {
		WebElement table = driver.findElement(By.xpath(xpath));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int rowcnt = rows.size();
		for (int i = 0; i < rowcnt; i++) {
			List<WebElement> clmns = table.findElements(By.tagName("tr"));
			int clmcnt = clmns.size();
			for (int j = 0; j < clmcnt; j++) {
				String clntext = clmns.get(j).getText();
				if (clntext.contentEquals(text)) {
					reportStep("The text " + text + " is matching with " + clntext, "PASS");
				} else {
					reportStep("The text " + text + " is not matching with " + clntext, "FAIL");
				}
			}
		}
	}
	public void clicklink(int index) {
		
		try {
			List<WebElement> links =driver.findElementsByTagName("a");
			links.get(index).click();
			System.out.println(links.size());
			System.out.println(links.get(index).getText());
			/*System.out.println(links.get(1).getText());
			System.out.println(links.get(2).getText());
			System.out.println(links.get(3).getText());
			System.out.println(links.get(4).getText());
			
			System.out.println(links.get(5).getText());System.out.println(links.get(16).getText());
			
			System.out.println(links.get(6).getText());
			System.out.println(links.get(7).getText());
			System.out.println(links.get(8).getText());
			
			System.out.println(links.get(9).getText());
			System.out.println(links.get(10).getText());
			System.out.println(links.get(11).getText());
			
			System.out.println(links.get(12).getText());
			System.out.println(links.get(13).getText());
			System.out.println(links.get(14).getText());
			
			System.out.println(links.get(15).getText());*/
			
			reportStep("The element with link: " + index + " is clicked" , "PASS");
		} catch (Exception e) {
			reportStep("The element with link: " + index + " is not clicked" , "FAIL");
		}
	}
}