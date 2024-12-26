
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
import com.Pages_UserManagementModule.Add_AddNewAgent;
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


public class  AllScenarios_AddNewAgent extends Base_Class {
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;
	Collection_CollectionAgencyRoleManagementModule collectionAgency;
	//AddNewAgent_Class AddNewAgentLogin;
	
	private static By userDropDown = By.xpath("//button[@class='btn dropdown-toggle']");
	private static By L_signout = By.xpath("//a[text()='Logout']");
	
	@BeforeSuite
	public void reference() {
		
		//AddNewAgentLogin = new AddNewAgent_Class();
		ExcelReader = new com.Utility.ExcelReader("CollectionAgency");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
		AddNewAgent= new Add_AddNewAgent();
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
				String URL = "http://192.168.32.33:8597/Collection/Admin/LevelPermissions";
				String CurrentUrl =Base_Class.driver.getCurrentUrl();
				System.out.println(CurrentUrl+"---CurrentUrl");
				if(CurrentUrl.contains(URL)) {
					assertEquals(CurrentUrl, URL);
					
					flag2 =true;
				}else {
					flag2=false;
				}
				ExtentTestManager.getTest().log(Status.PASS, "Role Management page is displayed with application link as Admin/LevelPermissions:" + flag2);
				Log.info("Application link with Admin/LevelPermissions is displayed:" + flag2);
