package com.test.user.UserManagementModule;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
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
	


	private static By userDropDown = By.xpath("//button[@class='btn dropdown-toggle']");
	private static By L_signout = By.xpath("//a[text()='Logout']");
	
	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("UserManagementModule");
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
				
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");
				Base_Class.SetUp();
				//ExtentTestManager.getTest().log(Status.PASS,
						//"Application Login" + com.BasePackage.Base_Class.Pagetitle);
				Log.info("Login successful !");
			
				boolean flag1 = collectionAgency.ClickSecurityManagement();
				Log.info("clicked Security Management Menu : " + flag1);
				
				ExtentTestManager.startTest("TestScenario01 :Verify Role Management Page Navigation");
				collectionAgency.RoleNameSearchField();
				assertEquals(Base_Class.driver.getCurrentUrl(), "http://192.168.32.33:8597/Collection/Admin/LevelPermissions");
				/*ExtentTestManager.getTest().log(Status.PASS, "Clicked SelectUserManagementMenu : " + flag2);
				Log.info("clicked UserManagementMenu : " + flag2);*/
				
				ExtentTestManager.startTest("TestScenario02 :Verify Role Management Page Elements Visibility");
				boolean flag3  = collectionAgency.RoleMngmtEltsVisibility(); 
				ExtentTestManager.getTest().log(Status.PASS, "Role Management Page Elements" + " is displayed : " + flag3);
				Log.info("Role Management Page Elements is displayed:" + flag3);
				
				ExtentTestManager.startTest("TestScenario03 :Add New Role - Validation for Empty Role Name");
				collectionAgency.ClickRoleSaveBtn();
				boolean flag4  = collectionAgency.RoleNameErrorMsg(); 
				ExtentTestManager.getTest().log(Status.PASS, "Validation for Empty Role Name" + " is displayed : " + flag4);
				Log.info("Validation for Empty Role Name is displayed:" + flag4);
				
				ExtentTestManager.startTest("TestScenario04 :Cancel Role Addition");
				boolean flag5  = collectionAgency.ClickCancelRole();
				ExtentTestManager.getTest().log(Status.PASS, "Cancel Role Addition" + " is successful : " + flag5);
				Log.info("Cancel Role Addition is successful:" + flag5);



               	 
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