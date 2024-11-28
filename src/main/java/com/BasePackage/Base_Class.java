package com.BasePackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utility.Log;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {

	public static RemoteWebDriver driver = null;

	public WebDriver getDriver() {
		return driver;
	}


	private static By L_username = By.xpath("//input[@placeholder='User Name']");
	private static By L_password = By.xpath("//input[@placeholder='Password']");
	private static  By L_SignIn = By.xpath("//button[text()='LOGIN']");

	public static String Pagetitle;

	public static Properties configloader() throws IOException {
		FileInputStream File = new FileInputStream(".\\src\\test\\resources\\config.properties");
		Properties properties = new Properties();
		properties.load(File);
		return properties;
	}

	public  void SetUp() throws IOException, InterruptedException {

		String Browser = configloader().getProperty("Browser");
		String Url = configloader().getProperty("URL");
		String UserName = configloader().getProperty("UserName");
		String Password = configloader().getProperty("Password");
		switch (Browser.toUpperCase()) {

		case "CHROME":

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);		
			break;

		case "FIREFOX":

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();			
			break;

		default:
			System.err.println("The Driver is not defined");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		Log.info("Driver has initialized successfully for "+Browser+"browser");
		driver.get(Url);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		Thread.sleep(6000);
		Pagetitle = driver.getTitle();
		Log.info("Title is displayed : "+Pagetitle);
		input(L_username, UserName);
		input(L_password, Password);
		click(L_SignIn);
		Thread.sleep(4000);

	}
	
	public String writeDynamicEmail() {

        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890";

        String email = "";

        String emailDomain = "";

        String temp = RandomStringUtils.random(25, allowedChars);

        emailDomain = temp.substring(0, temp.length() - 15);

        email = temp.substring(0, temp.length() - 9) + "@" + "gmail.com";

        return email;      

         }

 public static String generatePhoneNumber() {

        Random rand = new Random();

        String phoneNumber = "7";

        for (int i = 0; i < 9; i++)

        {

               phoneNumber += rand.nextInt(10);
        }

        return phoneNumber;

 }

	public static  void input(By element, String Value) throws InterruptedException {


		WebDriverWait wait2 = new WebDriverWait(driver, 120);
		wait2.until(ExpectedConditions.presenceOfElementLocated(element)).sendKeys(Value);


	}

	public static  void click(By element) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();

	}

	public static void select(String value,By element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Select selWeekDayDropDown = new Select(driver.findElement(element));
		selWeekDayDropDown.selectByVisibleText(value);

	}


	public static void clear(By element)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
		Thread.sleep(2000);
	}


	public static void AcceptAlert()
	{
		driver.switchTo().alert().accept();
		//driver.switchTo().alert().dismiss();


	}

	public static  void INclick(By element) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
	}

	public static void SwitchToFrame(By frameName)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
	}

	public static void ScrollUntilElementVisible(By locator)
	{ 
		WebElement element = driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public static boolean ElementDisplayed(By locator)
	{   
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement element = driver.findElement(locator);
		Boolean flag = element.isDisplayed();
		return flag;
	}

	public static boolean ElementEnabled(By locator)
	{
		WebElement element = driver.findElement(locator);
		Boolean flag = element.isEnabled();
		return flag;
	}

	public static void UploadFile(By locator, String path)
	{
		WebElement uploadElement = driver.findElement(locator);
		String path1=System.getProperty("user.dir");
		Log.info("path is :" + path1);
		uploadElement.sendKeys(path1 + path);

	}


	//	public static void UploadFile(By locator)
	//	{
	//		WebElement uploadElement = driver.findElement(locator);
	//		 String path=System.getProperty("user.dir");
	//		 Log.info("path is :" + path);
	//		//System.out.Directory.GetParent(this.GetType().Assembly.Location).ToString();
	//		uploadElement.sendKeys(path);
	//		
	//		
	//	}
	public static boolean ElementEnableOrDisable(By locator)
	{
		WebElement element = driver.findElement(locator);
		Boolean flag = element.isEnabled();
		return flag;
	}

	public static boolean CheckElementDisable(By locator)
	{  
		//disable
		WebElement element = driver.findElement(locator);
		Boolean flag = element.isEnabled();	

		if (flag==false) {
			flag=true;
		}else if(flag==true)
			flag=false;

		return flag;
	}


	public static  void Hover(By element) throws InterruptedException {
		WebElement element1 = driver.findElement(element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element1).perform();



	}

	public void SelectActiveDropdown(By by, String value) throws InterruptedException {

		if (ElementDisplayed(by)) {
			//JavascriptExecutor Js=driver;
			//Js.executeScript("arguments[0].click();", by);
            click(by);

			Thread.sleep(2000); 

			By options = By.xpath("//*[text()='"+ value +"']//parent::li");

			if (ElementDisplayed(options)) {

				click(options);

				Log.info("Successfully user found and clicked on the " + value + " value inside the dropdown ");

			}else {
				waitVisibility(options);
				if (ElementDisplayed(options)) {

					click(options);

					Log.info("Successfully user found and clicked on the " + value + " value inside the dropdown ");

				}else {
					Log.error("Unsuccessfully user not able to find and clicked on the " + value + " value inside the dropdown ");
				}
				
			}

		} else {

			Log.info("UnSuccessfully user not found and clicked on the " + value + " value inside the dropdown ");

		}



	}
	
	
	public WebElement waitVisibility(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

}
