package com.test.user.UserManagementModule;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.BasePackage.Collection_Class;
import com.BasePackage.Common;
import com.BasePackage.Login_Class;
import com.Page_Repositary.UserManagement;
import com.Pages_UserManagementModule.Collection_CollectionAgencyRoleManagementModule;
import com.Pages_UserManagementModule.User_UserManagment;
import com.Utility.FakerValue;
import com.Utility.Log;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;
import static org.junit.Assert.assertTrue;
import com.Page_Repositary.UserManagement;

public class  AllScenarios_CollectionAgencyRoleMangement extends Base_Class {
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;
	Collection_CollectionAgencyRoleManagementModule collectionAgency;
	Collection_Class CollectionAppLogin;
	
	private static By userDropDown = By.xpath("//button[@class='btn dropdown-toggle']");
	private static By L_signout = By.xpath("//a[text()='Logout']");
	
	@BeforeSuite
	public void reference() {
		
		CollectionAppLogin = new Collection_Class();
		ExcelReader = new com.Utility.ExcelReader("CollectionAgency");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
		collectionAgency= new Collection_CollectionAgencyRoleManagementModule();
	}
	

	@Test(dataProvider = "TestData")
	public void RUNALL(Map<Object, Object> testdata, ITestContext context) throws IOException, InterruptedException {

		try {

			if (testdata.get("Run").toString().equalsIgnoreCase("Yes")) {
				
				//ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");
				Base_Class.SetUp("Collection");
				//ExtentTestManager.getTest().log(Status.PASS,
						//"Application Login" + com.BasePackage.Base_Class.Pagetitle);
				Log.info("Login successful !");
			
				String RoleName = testdata.get("Role Name").toString();
				String AlphanumericName= testdata.get("AlphanumericName").toString();
				String specialCharacters= testdata.get("specialCharacters").toString();
				FakerValue newData = new FakerValue();
				String username = newData.getFirstName();
				
				ExtentTestManager.startTest("Verify Role Management Page Navigation");
				boolean flag1 = collectionAgency.ClickSecurityManagement();
				Log.info("clicked Security Management Menu : " + flag1);
			    ExtentTestManager.getTest().log(Status.PASS, "1. Navigate to Security Management main menu");
				boolean flag2 =false;
				String URL = "Admin/LevelPermissions";
				String CurrentUrl =Base_Class.driver.getCurrentUrl();
				System.out.println(CurrentUrl+"---CurrentUrl");
				if(CurrentUrl.contains(URL)) {
					flag2 =true;
					ExtentTestManager.getTest().log(Status.PASS, "Role Management page is displayed with application link as Admin/LevelPermissions:" + flag2);
					Log.info("Application link with Admin/LevelPermissions is displayed:" + flag2);
				}else {
					flag2=false;
					ExtentTestManager.getTest().log(Status.PASS, "Role Management page isn't displayed with application link as Admin/LevelPermissions:" + flag2);
					Log.info("Application link with Admin/LevelPermissions isn't displayed:" + flag2);
				}
				
				
				ExtentTestManager.startTest("Verify Role Management Page Elements Visibility");
				boolean flag3  = collectionAgency.RoleMngmtEltsVisibility(); 
				ExtentTestManager.getTest().log(Status.PASS, "1. Observe the Role name search field.");
				ExtentTestManager.getTest().log(Status.PASS, "2. Observe the Search button.");
				ExtentTestManager.getTest().log(Status.PASS, "3. Observe the Add New Role button");
				ExtentTestManager.getTest().log(Status.PASS, "All specified fields and buttons are visible : " + flag3);
				Log.info("Role Management Page Elements is displayed:" + flag3);
				
				ExtentTestManager.startTest("Add New Role - Validation for Empty Role Name");
				collectionAgency.RolePermissionPopup();
				ExtentTestManager.getTest().log(Status.PASS, "1. Click on Add New Role button.");
				ExtentTestManager.getTest().log(Status.PASS, "2. Without entering a role name, select functionalities checkboxes.");
				collectionAgency.RolePermissionSave();
				ExtentTestManager.getTest().log(Status.PASS, "3. Click on Save button.");
				boolean flag4  = collectionAgency.RoleNameErrorMsg(); 
				ExtentTestManager.getTest().log(Status.PASS, "Warning message \"Enter Role Name\" is displayed: " + flag4);
				Log.info("Validation for Empty Role Name is displayed:" + flag4);
				
				ExtentTestManager.startTest("Cancel Role Addition");
				collectionAgency.zoomOut(driver);
				Thread.sleep(2000);
				boolean flag5  = collectionAgency.ClickCancelRole();
				ExtentTestManager.getTest().log(Status.PASS, "1. Click on Cancel button within the role permission pop-up.");
				ExtentTestManager.getTest().log(Status.PASS, "The pop-up is closed and user is redirected back to Role Management page: " + flag5);
				Log.info("Cancel Role Addition is successful:" + flag5);
				
				ExtentTestManager.startTest("Add New Role with Valid Data");
				collectionAgency.AddNewRoleName(username);
				ExtentTestManager.getTest().log(Status.PASS, "1. Click on Add New Role button.");
				ExtentTestManager.getTest().log(Status.PASS, "2. Enter Role Name ");
				ExtentTestManager.getTest().log(Status.PASS, "3. Select all functionalities");
				collectionAgency.ClickAllCheckbox();
				collectionAgency.RolePermissionSave();
				ExtentTestManager.getTest().log(Status.PASS, "4. Click Save button.");
				boolean flag6  = collectionAgency.RoleNameSuccessMsg();
				ExtentTestManager.getTest().log(Status.PASS, "Success message \"Record saved successfully\" is displayed and user is redirected to Role Management page : " + flag6);
				Log.info("New Role with Valid Date is displayed:" + flag6);
				
				ExtentTestManager.startTest("Search for Existing Role");
				collectionAgency.InputSearchField(RoleName);
				ExtentTestManager.getTest().log(Status.PASS, "1. Enter Role5 in the Role name search field");
				collectionAgency.clickRoleSearchField();
				ExtentTestManager.getTest().log(Status.PASS, "2. Click Search button.");
				boolean flag7  = collectionAgency.DisplayAddedRoleName();
				ExtentTestManager.getTest().log(Status.PASS, "Role5 is displayed in Role name column with an Action column containing a three-dot button : " + flag7);
				Log.info("Existing Role is displayed:" + flag7);
				
				ExtentTestManager.startTest("Verify Edit Option for Role");
				boolean flag8  = collectionAgency.DisplayEditOption();
				ExtentTestManager.getTest().log(Status.PASS, "1. Click on the three-dot button beside Role5");
				ExtentTestManager.getTest().log(Status.PASS, "2. Verify the presence of Edit option");
				ExtentTestManager.getTest().log(Status.PASS, "Edit option is visible after clicking the three-dot button : " + flag8);
				Log.info("Edit Option is displayed:" + flag8);
				Thread.sleep(2000);
				
				ExtentTestManager.startTest("Edit Role and Save Changes");
				collectionAgency.EditRole();
				ExtentTestManager.getTest().log(Status.PASS, "1. Click on Edit option for Role5");
				ExtentTestManager.getTest().log(Status.PASS, "2. Uncheck \"Agent Account Allocation\" and \"Disposition\" checkboxes.");
				collectionAgency.RolePermissionSave();
				ExtentTestManager.getTest().log(Status.PASS, "3. Click Save button.");
				boolean flag9  = collectionAgency.UpdateRoleSuccessMsg();
				//Common.waitForSpinnerToDisappear(driver, "Loading Spinner", PageRepositry.waitSpinner);
				//fluentWait("Next Btn", PageRepositry.NextBtn);
				Thread.sleep(3000);
				ExtentTestManager.getTest().log(Status.PASS, "Success message \"Records updated successfully\" is displayed : " + flag9);
				Log.info("Updated Role Name Success message is displayed:" + flag9);
				//Thread.sleep(10000);
				
				ExtentTestManager.startTest("Role Name Field - ECP Validations");
				Random rand = new Random();
		        int randomNumber = rand.nextInt(100); 
				String Alphanumeric = newData.getFirstName()+randomNumber;
				collectionAgency.AddNewRoleName(Alphanumeric);
				ExtentTestManager.getTest().log(Status.PASS, "1. For Role Name, use inputs with Alphanumeric characters.");
				collectionAgency.ClickCheckbox();
				Thread.sleep(6000);
				boolean flag10  = collectionAgency.RolePermissionSave();
				ExtentTestManager.getTest().log(Status.PASS, "2. Click Save button.");
				ExtentTestManager.getTest().log(Status.PASS, "Alphanumeric inputs are allowed : " + flag10);
				Log.info("Alphanumeric Role Name is displayed:" + flag10);
				Thread.sleep(2000);
				
				ExtentTestManager.startTest("Error guessing - Empty Roles Search");
				collectionAgency.clickSearchButton();
				ExtentTestManager.getTest().log(Status.PASS, "1. Leave the Role name search field empty");
				ExtentTestManager.getTest().log(Status.PASS, "2. Click Search button.");
				boolean flag11  = collectionAgency.ValidatingTheRows();
				Thread.sleep(2000);
				ExtentTestManager.getTest().log(Status.PASS, "Should list of all roles: " + flag11);
				Log.info("Empty Roles Search:" + flag11);
				
				
				ExtentTestManager.startTest("Error guessing - Invalid Character in Role Name");
				int wordLength = 10;  // Set the desired length for the random word
				String randomSpecialWord = generateRandomSpecialWord(wordLength);
                System.out.println("Random word with special characters: " + randomSpecialWord);
				collectionAgency.inputRoleNameSearchField(randomSpecialWord);
				ExtentTestManager.getTest().log(Status.PASS, "1. Enter special characters in Role name search field");
				collectionAgency.clickSearchButton();
				ExtentTestManager.getTest().log(Status.PASS, "2. Click Search button.");
				boolean flag12  = collectionAgency.NoRecordsMsg();
				ExtentTestManager.getTest().log(Status.PASS, "Should show no records to display: " + flag12);
				Log.info("No Records to display:" + flag12);
               	 
			// Logout  
			//ExtentTestManager.startTest("Application Logout Initiated.");
			context.setAttribute("fileName", "Logout");
			click(userDropDown);
			click(L_signout);
			Thread.sleep(2000);
			driver.quit();
			//ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
			Log.info("Logout is done!");

			// EndTest
			System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
			Log.info("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");

			}

		} catch (Exception e) {
			System.out.println("*** Test execution " + testdata.get("TestScenario").toString() + " failed...");
			Log.error("*** Test execution " + testdata.get("TestScenario").toString() + " failed...");
			Log.error("" + e.getMessage());
			String fileName = (String) context.getAttribute("fileName");

			try {
				File file = new com.Utility.ScreenShot(driver).takeScreenShot(fileName,
						testdata.get("TestScenario").toString());
				ExtentTestManager.getTest().fail(e.getMessage(),
						MediaEntityBuilder.createScreenCaptureFromPath(file.toString()).build());
			} catch (Exception e1) {
				System.out.println("File not found " + e1);
			}
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");

			// Logout
			context.setAttribute("fileName", "Logout");
			click(userDropDown);
			click(L_signout);
			Thread.sleep(2000);
			driver.quit();
			ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
			Log.info("Logout is done");

			// EndTest
			System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
			Log.info("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");
		} catch (AssertionError e) {
			System.out.println("*** Test execution " + testdata.get("TestScenario").toString() + " failed...");
			Log.error("*** Test execution " + testdata.get("TestScenario").toString() + " failed...");
			Log.error("" + e.getMessage());
			String fileName = (String) context.getAttribute("fileName");

			try {
				File file = new com.Utility.ScreenShot(driver).takeScreenShot(fileName,
						testdata.get("TestScenario").toString());
				ExtentTestManager.getTest().fail(e.getMessage(),
						MediaEntityBuilder.createScreenCaptureFromPath(file.toString()).build());
			} catch (Exception e1) {
				System.out.println("File not found " + e1);
			}
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");

			//Logout
			context.setAttribute("fileName", "Logout");
			driver.quit();
			ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
			Log.info("Logout is done");

			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
			Log.info("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");
		}

	}

	@DataProvider(name = "TestData")
	public static Object[][] gettestdate() throws IOException {

		Object[][] objectarry = null;
		java.util.List<Map<String, String>> completedata = com.Utility.ExcelReader.getdata();

		objectarry = new Object[completedata.size()][1];

		for (int i = 0; i < completedata.size(); i++) {
			objectarry[i][0] = completedata.get(i);
		}
		return objectarry;
	}
	
	

	
}