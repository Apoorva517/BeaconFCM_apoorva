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

import org.apache.commons.text.RandomStringGenerator;
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
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.Page_Repositary.LoginPageRepo;
import com.Utility.Log;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

public class Base_Class {

	public static RemoteWebDriver driver = null;

	public WebDriver getDriver() {
		return driver;
	}


	public static By L_username = By.xpath("//input[@placeholder='User Name']");
	public static By L_password = By.xpath("//input[@placeholder='Password']");
	public static  By L_SignIn = By.xpath("//button[text()='LOGIN']");
	

	public static String Pagetitle;

	public static Properties configloader() throws IOException {
		FileInputStream File = new FileInputStream(".\\src\\test\\resources\\config.properties");
		Properties properties = new Properties();
		properties.load(File);
		return properties;
	}

	public  void SetUp(String User) throws IOException, InterruptedException {

		String Browser = configloader().getProperty("Browser");
		switch (Browser.toUpperCase()) {

		case "CHROME":

			ChromeOptions options = new ChromeOptions();
			//options.addArguments("--disable-extensions");
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
		//driver.manage().deleteAllCookies();
		String Url=configloader().getProperty(User+"URL");
		driver.get(configloader().getProperty(User+"URL"));
		Log.info("Driver has initialized successfully for "+Browser+"browser");
		String UserName=null;
		String Password=null;
		if(Url.contains("collection")) {
			
			 UserName = configloader().getProperty("CollectionUserName");
			 Password = configloader().getProperty("CollectionPassword");
//			loginStep(UserName, Password);
			
		} else {
//			driver.get(configloader().getProperty(User+"URL"));
			 UserName = configloader().getProperty("UserName");
			 Password = configloader().getProperty("Password");
			
		}
		System.out.println("Username:-"+UserName);
		System.out.println("Password:-"+Password);
		loginStep(UserName, Password);
		

	}
	
	public static void loginStep(String username, String password) throws IOException, InterruptedException {
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		Thread.sleep(6000);
		Pagetitle = driver.getTitle();
		Log.info("Title is displayed : "+Pagetitle);
		input(L_username, username);
		input(L_password, password);
		click(L_SignIn);
		Thread.sleep(4000);
	}
	
	public static void jsClick(By locator) {

        WebElement element = driver.findElement(locator);

        JavascriptExecutor js = driver;

        js.executeScript("arguments[0].click();", element);

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
 
//Method to generate a random word with only special characters
 public static String generateRandomSpecialWord(int length) {
     // Define the special characters
     String specialCharacters = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
     StringBuilder randomWord = new StringBuilder();
    
     Random random = new Random();
    
     // Generate the random word by choosing from special characters
     for (int i = 0; i < length; i++) {
         int index = random.nextInt(specialCharacters.length());
         randomWord.append(specialCharacters.charAt(index));
     }
    
     return randomWord.toString();
 }

 public static String generateRandomNumber() {

     Random rand = new Random();

     String NeededLengthNumber = "7";

     for (int i = 0; i < 4; i++)

     {
 
    	 NeededLengthNumber += rand.nextInt(10);
     }

     return NeededLengthNumber;

}
 
 
 public static void ElementToBeVisible(By element) throws InterruptedException{
	 WebDriverWait wait = new WebDriverWait(driver,200);
	 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
 }
 

	public static void input(By element, String Value) throws InterruptedException {


		WebDriverWait wait2 = new WebDriverWait(driver, 180);
		wait2.until(ExpectedConditions.presenceOfElementLocated(element)).sendKeys(Value);


	}

	public static  void click(By element) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 180);
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
		WebDriverWait wait = new WebDriverWait(driver, 60000);
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
	
	public WebElement waitVisibility(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 12000);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	/*public void HandlingLoginPopup(By by, String value) throws InterruptedException {
	{

	try:
	    yes_button = WebDriverWait(driver, 5).until(
	        EC.presence_of_element_located((By.XPATH, "//button[contains(text(), 'Yes')]"));
	    )
	    
	    if yes_button:
	        print("Popup 'Already Logged In' detected. Clicking 'Yes'.");
	        yes_button.click();
	        time.sleep(3);
			private static By username = By.xpath("//input[@placeholder='User Name']");
			private static By password = By.xpath("//input[@placeholder='Password']");

	except:
	 
	    try:
	       
	        username_field = WebDriverWait(driver, 5).until()
	            EC.presence_of_element_located((By.NAME, "User Name"));  # Change as per your form's field names
	)
	        password_field = WebDriverWait(driver, 5).until(
	            EC.presence_of_element_located((By.NAME, "Password"));  # Change as per your form's field names
	        )
	        
	        //If login fields are found, enter credentials
	        if username_field and password_field:
	            print("Login form detected. Entering credentials.");
	            username_field.send_keys("your_username");
	            password_field.send_keys("your_password");
	            
	           // Find the login button and click it
	            login_button = driver.find_element(By.XPATH, "//button[@type='submit']");  // Adjust XPath as needed
	            login_button.click();
	            
	            // Wait for the login to process (or page to load)
	            time.sleep(5);''
	            
	    except:
	        print("No login form or 'Already Logged In' popup detected.");
	    		
	}*/

	public void SelectActiveDropdown(By by, String value) throws InterruptedException {

		if (ElementDisplayed(by)) {
			//JavascriptExecutor Js=driver;
			//Js.executeScript("arguments[0].click();", by);
            click(by);

			Thread.sleep(3000); 

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
	
	/*public class Common {
		
		 private static WebDriver driver; // Make WebDriver a global variable

		    public static void setDriver(WebDriver webDriver) {
		        driver = webDriver;
		    }*/

	    public static void fluentWait(String WebElementName, By element) {
	        try {
	            System.out.println("Fluent wait started for: " + WebElementName);
	            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	                    .withTimeout(Duration.ofMinutes(10))
	                    .ignoring(NullPointerException.class)
	                    .ignoring(StaleElementReferenceException.class)
	                    .ignoring(NoSuchElementException.class)
	                    .ignoring(ElementNotInteractableException.class)
	                    .ignoring(WebDriverException.class)
	                    .pollingEvery(Duration.ofMillis(5));	            
	            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	            wait.until(ExpectedConditions.elementToBeClickable(element));
	            System.out.println("Fluent wait ended element is clickable: " + WebElementName);
	        } catch (Exception e) {
	            System.out.println("Error during fluent wait: " + e.getMessage());
	        }
	    }
	    
	    
	    public static void waitForSpinnerToDisappear(WebDriver driver, String WebElementName, By element) {
	        // Define the FluentWait
	        FluentWait<WebDriver> wait = new FluentWait<>(driver)
	                .withTimeout(Duration.ofSeconds(120)) // Maximum wait time
	                .pollingEvery(Duration.ofMillis(500)) // Polling interval
	                .ignoring(Exception.class); // Ignore exceptions like NoSuchElementException

	        // Wait until the spinner disappears
	        wait.until(driverInstance -> {
	            try {
	                WebElement spinner = driverInstance.findElement(element);
	                return !spinner.isDisplayed(); // Return true if spinner is not displayed
	            } catch (Exception e) {
	                return true; // Return true if spinner is not found
	            }
	        });
	    }

	    public String GetElementText(By locator) throws InterruptedException {    	 

            String stxt = null;

            waitVisibility(locator);

            WebElement element = driver.findElement(locator);

            if (element.isDisplayed()) {

                   stxt = element.getText();

                   Log.info("System able to found the element :" + locator);

            } else {

                   Log.error("System not able to found the element :" + locator);

            }

            return stxt;

   
     }
	    
	    public String generateRandomText4() {

            // Create a generator using Apache Commons Text

            RandomStringGenerator generator = new RandomStringGenerator.Builder()

                         .withinRange('a', 'z')

                         .build();

            // Generate a random word of length 8

            String randomWord = generator.generate(4);

            System.out.println("Random Word: " + randomWord);

            return randomWord;
            

     }

		public void SetUp() throws IOException, InterruptedException {
			
			String Browser = configloader().getProperty("Browser");
			String Url = configloader().getProperty("URL");
			
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
			Log.info("Driver has initialized successfully for "+Browser+" browser");
			driver.get(Url);
	        Common.setDriver(driver);
	        Common.fluentWait("LoginHyperlink2Banner",LoginPageRepo.LoginHyperlink2Banner);
	        
			Thread.sleep(9000);
			Pagetitle = driver.getTitle();
			Log.info("Title is displayed : "+Pagetitle);
		}

		public static Connection OracleDBConnection() throws IOException {
			
			Connection connection = null;
	        try {
	        	String DB_URL = configloader().getProperty("DatabaseURL");
	        	String DB_UserName = configloader().getProperty("DB_UserName");
	        	String DB_Password = configloader().getProperty("DB_Password");
	        	
	            // JDBC URL for Oracle database
	            String URL = "jdbc:oracle:thin:@"+ DB_URL.trim();
	            String username = DB_UserName.trim();
	            String password = DB_Password.trim();
	            // Establish connection
	            System.out.println("URL="+URL);
	            System.out.println("username="+username);
	            System.out.println("password="+password);
	            connection = DriverManager.getConnection(URL, username, password);
	            
	            if (connection != null) {
	                System.out.println("Connected to the database!");
	            } else {
	                System.out.println("Failed to make connection!");
	            }
	        } catch (SQLException e) {
	            System.err.println("Connection failed!");
	            e.printStackTrace();
	        } 
			return connection;
			
		}
		
		public static void ForLoopClick(By ClickElement) {
			
			try {
				for(int i=0; i<60; i++) {
					try {
						WebElement element = driver.findElement(ClickElement);
						if (element.isDisplayed() == true) {
							element.click();
							element.click();
							System.out.println("ForLoopWaitPlusClick: Element clicked");
							break;
						} else {
							System.out.println("Element to be click is not found");
						}
					}catch (Exception e1) {
						System.out.println("Catch exception");
					}
				}
			} catch(Exception e) {
				System.out.println("Error occurred: " + e);
			}
		  
		}
	
		
}
    
		
	 
