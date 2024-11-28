package com.test.user.UserManagementModule;

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
import com.Pages_UserManagementModule.User_UserManagment;
import com.Utility.Log;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;
import static org.junit.Assert.assertTrue;

public class AllScenarios_UserManagementModule extends Base_Class {
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;
	User_UserManagment User_UserManagementPage;


	private static By userDropDown = By.xpath("//button[@class='btn dropdown-toggle']");
	private static By L_signout = By.xpath("//a[text()='Logout']");
	
	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("UserManagementModule");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
		User_UserManagementPage= new User_UserManagment();
	}

	@Test(dataProvider = "TestData")
	public void RUNALL(Map<Object, Object> testdata, ITestContext context) throws IOException, InterruptedException {

		try {

			if (testdata.get("Run").toString().equalsIgnoreCase("Yes")) {
				
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");
				Base_Class.SetUp();
				ExtentTestManager.getTest().log(Status.PASS,
						"Application Login" + com.BasePackage.Base_Class.Pagetitle);
				Log.info("Login successful !");
				Thread.sleep(3000);
			
			
				ExtentTestManager.startTest(" User Management Page");
				Thread.sleep(2000);
				boolean flag1 = User_UserManagementPage.GoCollection();
				ExtentTestManager.getTest().log(Status.PASS, "Clicked Go collection button : " + flag1);
				Log.info("Clicked Go Collection");
				boolean flag2 = User_UserManagementPage.SelectSecurityManagementMenu();
				ExtentTestManager.getTest().log(Status.PASS, "Clicked SecurityManagementMenu : " + flag2);
				Log.info("Clicked Security Management Menu : " + flag2);
				boolean flag3 = User_UserManagementPage.SelectUserManagementMenu();
				ExtentTestManager.getTest().log(Status.PASS, "Clicked SelectUserManagementMenu : " + flag3);
				Log.info("clicked UserManagementMenu : " + flag3);
				
				ExtentTestManager.startTest("TestScenario001 :Checking all elements in UserManagementPage displayed ");
				boolean flag4 = User_UserManagementPage.LocatorDisplayed();
				ExtentTestManager.getTest().log(Status.PASS, "ElementEnabled " + flag4);
				Log.info("All elements in UserManagementPage displayed : " + flag4);
				
				ExtentTestManager.startTest("TestScenario02 :Checking IsActive Checkbox Selected by default ");
				boolean flag5 = User_UserManagementPage.isIsActiveCheckboxSelected();
				ExtentTestManager.getTest().log(Status.PASS, "isIsActiveCheckboxSelected : " + flag5);
				Log.info("IsActive Checkbox Selected by default : " + flag5);
				
				
			    ExtentTestManager.startTest("TestScenario03 :Checking Pagination displayed or not ");
  			    Thread.sleep(1000);
				boolean flag6 = User_UserManagementPage.DisplayUserManagementPreviousBtn();
				ExtentTestManager.getTest().log(Status.PASS, "Displayed UserManagement PreviousBtn : " + flag6);
				Log.info("Displayed UserManagement PreviousBtn : " + flag6);
				boolean flag7 = User_UserManagementPage.DisplayUserManagementFirstPageBtn();
				ExtentTestManager.getTest().log(Status.PASS, "Displayed UserManagement FirstPageBtn : " + flag7);
				Log.info("Displayed UserManagement FirstPageBtn : " + flag7);
				boolean flag8 = User_UserManagementPage.DisplayUserManagementSecondPageBtn();
				ExtentTestManager.getTest().log(Status.PASS, "Displayed UserManagement SecondPageBtn : " + flag8);
				Log.info("Displayed UserManagement SecondPageBtn : " + flag8);
				boolean flag9 = User_UserManagementPage.DisplayUserManagementNextBtn();
				ExtentTestManager.getTest().log(Status.PASS, "Displayed UserManagement NextBtn : " + flag9);
				Log.info("Displayed UserManagement NextBtn : " + flag9);
				boolean flag10 = User_UserManagementPage.DisplayUserManagementLastArrowBtn();
				ExtentTestManager.getTest().log(Status.PASS, "Displayed UserManagement LastArrowBtn : " + flag10);
				Log.info("Displayed UserManagement LastArrowBtn :" + flag10);
				
				ExtentTestManager.startTest("TestScenario04 :Clicking on the '2nd' Page button in pagination ");
				boolean flag11 = User_UserManagementPage.ClickUserManagementSecondPageBtn();
				ExtentTestManager.getTest().log(Status.PASS, "Clicked UserManagement SecondPageBtn : " + flag11);
				Log.info("Clicked '2nd'page button in pagination :" + flag11);
				
				ExtentTestManager.startTest("TestScenario05 :Clicking on the '>>' button in pagination ");
				boolean flag12 = User_UserManagementPage.ClickUserManagementLastArrowBtn();
				ExtentTestManager.getTest().log(Status.PASS, "Clicked UserManagement LastArrowBtn : " + flag12);
				Log.info("Clicked on the '>>' button in pagination" + flag12);
				
				ExtentTestManager.startTest("TestScenario06 :Clicking on the'Previous' button in pagination ");
				boolean flag13 = User_UserManagementPage.ClickUserManagementPreviousArrowBtn();
				ExtentTestManager.getTest().log(Status.PASS, "Clicked UserManagement PreviousArrowBtn : " + flag13);
				Log.info("Clicked on the'Previous' button in pagination :" + flag13);
				
				ExtentTestManager.startTest("TestScenario07 :Checking AddNewUserPage Elements displayed or not ");
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
  			    Thread.sleep(1000);
  			    boolean flag14 = User_UserManagementPage.AddNewUserPageElementsDisplayed();
				ExtentTestManager.getTest().log(Status.PASS, "Add New UserPage Elements Displayed or not: " + flag14);
				Log.info("Add New UserPage Elements Displayed :" + flag14);
				
				ExtentTestManager.startTest("TestScenario08 :Checking Head office dropdown field displayed or not ");
				String AddNewUserNameBtn = testdata.get("Name").toString();
				String AddNewUserEmailBtn = testdata.get("Email").toString();
				String AddNewUserPhoneNumberBtn = testdata.get("Phonenumber").toString();
				String AddNewUserRole = testdata.get("Testrole").toString();
				String AddNewUserOrganizationType = testdata.get("OrganizationType").toString();
				String AddNewUserOrganizationType2 = testdata.get("OrganizationType2").toString();
				String AddNewUserOrganizationType3 = testdata.get("OrganizationType3").toString();
				String AddNewUserOrganizationType4 = testdata.get("OrganizationType4").toString();
				String AddNewUserHeadOffice = testdata.get("HeadOffice").toString();
				String InvalidEmailId = testdata.get("InvalidEmailId").toString(); 
				String InvalidEmailIdWithoutDomain = testdata.get("EmailWithoutDomain").toString();
				String InvalidPhoneNumberWithLetters = testdata.get("NumberWithLetters").toString();
				String InvalidPhoneNumberWithEightDigits = testdata.get("NumberEightDigits").toString();
				String NameWithAlphabeticInput = testdata.get("AlphabeticInputName").toString();
				String NamewithNumericInput = testdata.get("NumericInputName").toString();
				String NamewithAlphaNumericInput = testdata.get("AlphaNumericInputName").toString();
				String AddNewUserZoneCO = testdata.get("ZoneCO").toString();
				String AddNewUserRegion = testdata.get("Region").toString(); 
				String InvalidUserName = testdata.get("InvalidUserName").toString();
				
				boolean EnterName = User_UserManagementPage.EnterAddNewUserName(AddNewUserNameBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Entered valid Name" + " is displayed : " + EnterName);
                Log.info("Entered valid Name is showing : " + EnterName);
                
                boolean EnterEmail = User_UserManagementPage.EnterAddNewUserEmail(AddNewUserEmailBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Entered valid Email" + " is displayed : " + EnterEmail);
                Log.info("Entered valid Email is showing : " + EnterEmail);
                
                boolean EnterPhonenumber = User_UserManagementPage.EnterAddNewUserPhoneNumber(AddNewUserPhoneNumberBtn);
				
				ExtentTestManager.getTest().log(Status.PASS, "Entered valid Phonenumber" + " is displayed : " + EnterPhonenumber);

                Log.info("Entered valid Phonenumber is showing : " + EnterPhonenumber);
                
                boolean SelectTestrole = User_UserManagementPage.SelectRoleDropdown(AddNewUserRole);
				
				ExtentTestManager.getTest().log(Status.PASS, "Selected Testrole" + " is displayed : " + SelectTestrole);

                Log.info("Selected valid Testrole : " + SelectTestrole);
                
                boolean SelectOrganizationtype = User_UserManagementPage.SelectOrganizationTypeDropdown(AddNewUserOrganizationType);
				
				ExtentTestManager.getTest().log(Status.PASS, "Selected Organization type" + " is displayed : " + SelectOrganizationtype);

                Log.info("Head office dropdown is selected : " + SelectOrganizationtype);
                
                ExtentTestManager.startTest("TestScenario09 :Checking Head office dropdown field displayed or not ");
				TimeUnit.SECONDS.sleep(5);
				boolean flag16 = User_UserManagementPage.DisplayAddNewUserHeadofficeBtn();
				ExtentTestManager.getTest().log(Status.PASS, "Displayed Add New User Headoffice option : " + flag16);
				Log.info("Displayed Add New User Headoffice option : " + flag16);
				
				ExtentTestManager.startTest("TestScenario09 :Showing out Head office and Zone/CO dropdown fields");
                User_UserManagementPage.SelectOrganizationTypeDropdown2(AddNewUserOrganizationType2);
				
				boolean flag18 = User_UserManagementPage.DisplayAddNewUserHeadofficeBtn();
				ExtentTestManager.getTest().log(Status.PASS, "Displayed AddNewUser HeadofficeField : " + flag18);
				Log.info("Displayed AddNewUser HeadofficeField : " + flag18);
				boolean flag19 = User_UserManagementPage.DisplayAddNewUserZoneCOBtn();
				ExtentTestManager.getTest().log(Status.PASS, "Display AddNewUser ZoneCOField : " + flag19);
				Log.info("Displayed AddNewUser ZoneCOField : " + flag19);
				
				ExtentTestManager.startTest("TestScenario10 :Showing out Head office, Zone/CO and Region dropdown fields");
				TimeUnit.SECONDS.sleep(3);
                User_UserManagementPage.SelectOrganizationTypeDropdown3(AddNewUserOrganizationType3);
                TimeUnit.SECONDS.sleep(5);
                
				boolean flag20 = User_UserManagementPage.DisplayAddNewUserHeadofficeBtn();
				ExtentTestManager.getTest().log(Status.PASS, "Displayed AddNewUser HeadofficeField : " + flag20);
				Log.info("Displayed AddNewUser HeadofficeField : " + flag20);
				boolean flag21 = User_UserManagementPage.DisplayAddNewUserZoneCOBtn();
				ExtentTestManager.getTest().log(Status.PASS, "Display AddNewUser ZoneCOField : " + flag21);
				Log.info("Displayed AddNewUser ZoneCOField : " + flag21);
				boolean flag22 = User_UserManagementPage.DisplayAddNewUserRegionBtn();
				ExtentTestManager.getTest().log(Status.PASS, "Display AddNewUser RegionField : " + flag22);
				Log.info("Displayed AddNewUser RegionField : " + flag22);
				
				ExtentTestManager.startTest("TestScenario11 :Showing out Head office, Zone/CO and Region and branch dropdown fields");
				TimeUnit.SECONDS.sleep(3);
                User_UserManagementPage.SelectOrganizationTypeDropdown4(AddNewUserOrganizationType4);
                TimeUnit.SECONDS.sleep(5);
                
				boolean flag23 = User_UserManagementPage.DisplayAddNewUserHeadofficeBtn();
				ExtentTestManager.getTest().log(Status.PASS, "Displayed AddNewUser HeadofficeField : " + flag23);
				Log.info("Displayed AddNewUser HeadofficeField : " + flag23);
				boolean flag24 = User_UserManagementPage.DisplayAddNewUserZoneCOBtn();
				ExtentTestManager.getTest().log(Status.PASS, "Display AddNewUser ZoneCOField : " + flag24);
				Log.info("Displayed AddNewUser ZoneCOField : " + flag24);
				boolean flag25 = User_UserManagementPage.DisplayAddNewUserRegionBtn();
				ExtentTestManager.getTest().log(Status.PASS, "Display AddNewUser RegionField : " + flag25);
				Log.info("Displayed AddNewUser RegionField : " + flag25);
				boolean flag26 = User_UserManagementPage.DisplayAddNewUserRegionBtn();
				ExtentTestManager.getTest().log(Status.PASS, "Display AddNewUser BranchField : " + flag26);
				Log.info("Displayed AddNewUser BranchField : " + flag26);
				
			   
				ExtentTestManager.startTest("TestScenario12 :Checking Error message displayed or not in Add user page ");
				User_UserManagementPage.ClickAddNewUserCloseBtn();
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
				boolean flag27 = User_UserManagementPage.ClickAddNewUserSubmitBtn();
				ExtentTestManager.getTest().log(Status.PASS, "Clicked AddNewUser SubmitBtn : " + flag27);
				Log.info("Clicked AddNewUser SubmitBtn : " + flag27);
				
				boolean flag28 = User_UserManagementPage.ErrormessageforAdduserPage();
				ExtentTestManager.getTest().log(Status.PASS, "Error message for AdduserPage displayed : " + flag28);
				Log.info("Error message for AdduserPage displayed : " + flag28);
				
				ExtentTestManager.startTest("TestScenario13 :Showing out Error message -'Name is required'");
				User_UserManagementPage.ClickAddNewUserCloseBtn();
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
                User_UserManagementPage.EnterAddNewUserEmail(AddNewUserEmailBtn);
				User_UserManagementPage.EnterAddNewUserPhoneNumber(AddNewUserPhoneNumberBtn);
				User_UserManagementPage.SelectRoleDropdown(AddNewUserRole);
                User_UserManagementPage.SelectOrganizationTypeDropdown(AddNewUserOrganizationType);
                User_UserManagementPage.SelectHeadOfficeDropdown(AddNewUserHeadOffice);
                User_UserManagementPage.ClickAddNewUserSubmitBtn();
				boolean flag29  = User_UserManagementPage.ErrormessageforNameField();
				ExtentTestManager.getTest().log(Status.PASS, "Error message for NameField" + " is displayed : " + flag29);
				Log.info("Error message for NameField displayed : " + flag29);
				
			
				ExtentTestManager.startTest("TestScenario14 :Showing out Error message -'Email is required'");
				User_UserManagementPage.ClickAddNewUserCloseBtn();
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
				User_UserManagementPage.EnterAddNewUserName(AddNewUserNameBtn);
				User_UserManagementPage.EnterAddNewUserPhoneNumber(AddNewUserPhoneNumberBtn);
				User_UserManagementPage.SelectRoleDropdown(AddNewUserRole);
                User_UserManagementPage.SelectOrganizationTypeDropdown(AddNewUserOrganizationType);
                User_UserManagementPage.SelectHeadOfficeDropdown(AddNewUserHeadOffice);
                User_UserManagementPage.ClickAddNewUserSubmitBtn();
				boolean flag30  = User_UserManagementPage.ErrormessageforEmailField();
				ExtentTestManager.getTest().log(Status.PASS, "Error message for EmailField" + " is displayed : " + flag30);
				Log.info("Error message for EmailField displayed : " + flag30);
				
				ExtentTestManager.startTest("TestScenario15 :Showing out Error message -'Phone Number is required'");
				User_UserManagementPage.ClickAddNewUserCloseBtn();
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
				User_UserManagementPage.EnterAddNewUserName(AddNewUserNameBtn);
				User_UserManagementPage.EnterAddNewUserEmail(AddNewUserEmailBtn);
				User_UserManagementPage.SelectRoleDropdown(AddNewUserRole);
                User_UserManagementPage.SelectOrganizationTypeDropdown(AddNewUserOrganizationType);
                User_UserManagementPage.SelectHeadOfficeDropdown(AddNewUserHeadOffice);
                User_UserManagementPage.ClickAddNewUserSubmitBtn();
				boolean flag31  = User_UserManagementPage.ErrormessageforPhoneNumberField();
				ExtentTestManager.getTest().log(Status.PASS, "Error message for PhoneNumberField" + " is displayed : " + flag31);
				Log.info("Error message for PhoneNumberField displayed : " + flag31);
				
				ExtentTestManager.startTest("TestScenario16 :Showing out Error message -'Role is required'");
				User_UserManagementPage.ClickAddNewUserCloseBtn();
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
				User_UserManagementPage.EnterAddNewUserName(AddNewUserNameBtn);
				User_UserManagementPage.EnterAddNewUserEmail(AddNewUserEmailBtn);
				User_UserManagementPage.EnterAddNewUserPhoneNumber(AddNewUserPhoneNumberBtn);
				User_UserManagementPage.SelectOrganizationTypeDropdown(AddNewUserOrganizationType);
                User_UserManagementPage.SelectHeadOfficeDropdown(AddNewUserHeadOffice);
                User_UserManagementPage.ClickAddNewUserSubmitBtn();
				boolean flag32  = User_UserManagementPage.ErrormessageforRoleField();
				ExtentTestManager.getTest().log(Status.PASS, "Error message for RoleField" + " is displayed : " + flag32);
				Log.info("Error message for RoleField displayed : " + flag32);
				
				ExtentTestManager.startTest("TestScenario17 :Showing out Error message -'Organization type is required'");
				User_UserManagementPage.ClickAddNewUserCloseBtn();
				TimeUnit.SECONDS.sleep(3);
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
				TimeUnit.SECONDS.sleep(3);
				User_UserManagementPage.EnterAddNewUserName(AddNewUserNameBtn);
				User_UserManagementPage.EnterAddNewUserEmail(AddNewUserEmailBtn);
				User_UserManagementPage.EnterAddNewUserPhoneNumber(AddNewUserPhoneNumberBtn);
				User_UserManagementPage.SelectRoleDropdown(AddNewUserRole);
                User_UserManagementPage.ClickAddNewUserSubmitBtn();
				boolean flag33  = User_UserManagementPage.ErrormessageforOrganizationTypeField();
				ExtentTestManager.getTest().log(Status.PASS, "Error message for OrganizationTypeField" + " is displayed : " + flag33);
				Log.info("Error message for OrganizationTypeField displayed : " + flag33);
				
				
				ExtentTestManager.startTest("TestScenario17 :Showing out Error message -'Invalid Email Id without @'");
				User_UserManagementPage.ClickAddNewUserCloseBtn();
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
				User_UserManagementPage.EnterAddNewUserName(AddNewUserNameBtn);
				User_UserManagementPage.EnterAddNewUserEmail(InvalidEmailId);
				User_UserManagementPage.EnterAddNewUserPhoneNumber(AddNewUserPhoneNumberBtn);
				User_UserManagementPage.SelectRoleDropdown(AddNewUserRole);
				User_UserManagementPage.SelectOrganizationTypeDropdown(AddNewUserOrganizationType);
                User_UserManagementPage.SelectHeadOfficeDropdown(AddNewUserHeadOffice);
                User_UserManagementPage.ClickAddNewUserSubmitBtn();
				boolean flag34  = User_UserManagementPage.ErrormessageforInvalidEmailId();
				ExtentTestManager.getTest().log(Status.PASS, "Error message for Invalid Email Id" + " is displayed : " + flag34);
				Log.info("Error message for Invalid Email Id is displayed : " + flag34);
				
				ExtentTestManager.startTest("TestScenario18 :Showing out Error message -'Invalid Email Id without domain'");
				User_UserManagementPage.ClickAddNewUserCloseBtn();
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
				User_UserManagementPage.EnterAddNewUserName(AddNewUserNameBtn);
				User_UserManagementPage.EnterAddNewUserEmail(InvalidEmailIdWithoutDomain);
				User_UserManagementPage.EnterAddNewUserPhoneNumber(AddNewUserPhoneNumberBtn);
				User_UserManagementPage.SelectRoleDropdown(AddNewUserRole);
				User_UserManagementPage.SelectOrganizationTypeDropdown(AddNewUserOrganizationType);
                User_UserManagementPage.SelectHeadOfficeDropdown(AddNewUserHeadOffice);
                User_UserManagementPage.ClickAddNewUserSubmitBtn();
				boolean flag35  = User_UserManagementPage.ErrormessageforInvalidEmailId();
				ExtentTestManager.getTest().log(Status.PASS, "Error message for Invalid Email Id" + " is displayed : " + flag35);
				Log.info("Error message for Invalid Email Id is displayed : " + flag35);
				
				ExtentTestManager.startTest("TestScenario19 :Showing out Error message -'Invalid Mobile Number, entered letters'");
				User_UserManagementPage.ClickAddNewUserCloseBtn();
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
				User_UserManagementPage.EnterAddNewUserName(AddNewUserNameBtn);
				User_UserManagementPage.EnterAddNewUserEmail(AddNewUserEmailBtn);
				User_UserManagementPage.EnterAddNewUserPhoneNumber(InvalidPhoneNumberWithLetters);
				User_UserManagementPage.SelectRoleDropdown(AddNewUserRole);
				User_UserManagementPage.SelectOrganizationTypeDropdown(AddNewUserOrganizationType);
                User_UserManagementPage.SelectHeadOfficeDropdown(AddNewUserHeadOffice);
                User_UserManagementPage.ClickAddNewUserSubmitBtn();
				boolean flag36  = User_UserManagementPage.ClickAddNewUserSubmitBtn();
				ExtentTestManager.getTest().log(Status.PASS, "Error message for Invalid PhoneNumber with letters" + " is displayed : " + flag36);
				Log.info("Error message for Invalid PhoneNumber with letters is displayed : " + flag36);
				
				ExtentTestManager.startTest("TestScenario19 :Showing out Error message -'Invalid Mobile Number, entered 8 digits'");
				User_UserManagementPage.ClickAddNewUserCloseBtn();
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
				User_UserManagementPage.EnterAddNewUserName(AddNewUserNameBtn);
				User_UserManagementPage.EnterAddNewUserEmail(AddNewUserEmailBtn);
				User_UserManagementPage.EnterAddNewUserPhoneNumber(InvalidPhoneNumberWithEightDigits);
				User_UserManagementPage.SelectRoleDropdown(AddNewUserRole);
				User_UserManagementPage.SelectOrganizationTypeDropdown(AddNewUserOrganizationType);
                User_UserManagementPage.SelectHeadOfficeDropdown(AddNewUserHeadOffice);
                User_UserManagementPage.ClickAddNewUserSubmitBtn();
				boolean flag37  = User_UserManagementPage.ErrormessageforInvalidPhoneNumber();
				ExtentTestManager.getTest().log(Status.PASS, "Error message for Invalid PhoneNumber with 8 digits" + " is displayed : " + flag37);
				Log.info("Error message for Invalid PhoneNumber with 8 digits is displayed : " + flag37);
				
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
				ExtentTestManager.startTest("TestScenario20 :No Error message -'User is created with Alphabetic inputs'");
				User_UserManagementPage.ClickAddNewUserCloseBtn();
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
				User_UserManagementPage.EnterAddNewUserName(NameWithAlphabeticInput);
				User_UserManagementPage.EnterAddNewUserEmail(AddNewUserEmailBtn);
				User_UserManagementPage.EnterAddNewUserPhoneNumber(AddNewUserPhoneNumberBtn);
				User_UserManagementPage.SelectRoleDropdown(AddNewUserRole);
				User_UserManagementPage.SelectOrganizationTypeDropdown(AddNewUserOrganizationType);
                User_UserManagementPage.SelectHeadOfficeDropdown(AddNewUserHeadOffice);
				boolean flag38  = User_UserManagementPage.ClickAddNewUserSubmitBtn();
				ExtentTestManager.getTest().log(Status.PASS, "User is created with Alphabetic inputs" + " is displayed : " + flag38);
				Log.info("User created with Alphabetic inputs successfully: " + flag38);
				
				ExtentTestManager.startTest("TestScenario20 :Showing out Error message for numeric inputs -'Invalid Name'");
				User_UserManagementPage.ClickAddNewUserCloseBtn();
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
				User_UserManagementPage.EnterAddNewUserName(NamewithNumericInput);
				User_UserManagementPage.EnterAddNewUserEmail(AddNewUserEmailBtn);
				User_UserManagementPage.EnterAddNewUserPhoneNumber(AddNewUserPhoneNumberBtn);
				User_UserManagementPage.SelectRoleDropdown(AddNewUserRole);
				User_UserManagementPage.SelectOrganizationTypeDropdown(AddNewUserOrganizationType);
                User_UserManagementPage.SelectHeadOfficeDropdown(AddNewUserHeadOffice);
                User_UserManagementPage.ClickAddNewUserSubmitBtn();
				boolean flag39  = User_UserManagementPage.ErrormessageforInvalidName();
				ExtentTestManager.getTest().log(Status.PASS, "Error message Invalid Name for numeric inputs" + " is displayed : " + flag39);
				Log.info("Error message Invalid Name for numeric inputs is displayed: " + flag39);
				
				ExtentTestManager.startTest("TestScenario20 :Showing out Error message for alphanumeric inputs -'Invalid Name'");
				User_UserManagementPage.ClickAddNewUserCloseBtn();
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
				User_UserManagementPage.EnterAddNewUserName(NamewithAlphaNumericInput);
				User_UserManagementPage.EnterAddNewUserEmail(AddNewUserEmailBtn);
				User_UserManagementPage.EnterAddNewUserPhoneNumber(AddNewUserPhoneNumberBtn);
				User_UserManagementPage.SelectRoleDropdown(AddNewUserRole);
				User_UserManagementPage.SelectOrganizationTypeDropdown(AddNewUserOrganizationType);
                User_UserManagementPage.SelectHeadOfficeDropdown(AddNewUserHeadOffice);
                User_UserManagementPage.ClickAddNewUserSubmitBtn();
				boolean flag40  = User_UserManagementPage.ErrormessageforInvalidName();
				ExtentTestManager.getTest().log(Status.PASS, "Error message Invalid Name for alphanumeric inputs" + " is displayed : " + flag40);
				Log.info("Error message Invalid Name for alphanumeric inputs is displayed: " + flag40);
								
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
				ExtentTestManager.startTest("TestScenario21 :Showing out Error message for Empty Headoffice -'Head office is Required'");
				User_UserManagementPage.ClickAddNewUserCloseBtn();
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
				User_UserManagementPage.EnterAddNewUserName(AddNewUserNameBtn);
				User_UserManagementPage.EnterAddNewUserEmail(AddNewUserEmailBtn);
				User_UserManagementPage.EnterAddNewUserPhoneNumber(AddNewUserPhoneNumberBtn);
				User_UserManagementPage.SelectRoleDropdown(AddNewUserRole);
				User_UserManagementPage.SelectOrganizationTypeDropdown(AddNewUserOrganizationType);
                User_UserManagementPage.ClickAddNewUserSubmitBtn();
				boolean flag41  = User_UserManagementPage.ErrormessageforEmptyHeadoffice();
				ExtentTestManager.getTest().log(Status.PASS, "Error message for Empty Headoffice" + " is displayed : " + flag41);
				Log.info("Error message for Empty Headoffice is displayed: " + flag41);
				
				
				ExtentTestManager.startTest("TestScenario23 :Showing out error message for when we create existing user");
				User_UserManagementPage.ClickAddNewUserCloseBtn();
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
				User_UserManagementPage.EnterAddNewUserName(AddNewUserNameBtn);
				User_UserManagementPage.EnterAddNewUserEmail(AddNewUserEmailBtn);
				User_UserManagementPage.EnterAddNewUserPhoneNumber(AddNewUserPhoneNumberBtn);
				User_UserManagementPage.SelectRoleDropdown(AddNewUserRole);
				User_UserManagementPage.SelectOrganizationTypeDropdown(AddNewUserOrganizationType);
				User_UserManagementPage.SelectHeadOfficeDropdown(AddNewUserHeadOffice);
                User_UserManagementPage.ClickAddNewUserSubmitBtn();
                boolean flag42  = User_UserManagementPage.ErrorMessageExistUserCreation();
				ExtentTestManager.getTest().log(Status.PASS, "Error message on creating existing user" + " is displayed : " + flag42);
				Log.info("Error message on creating existing user is displayed: " + flag42);
                

                ExtentTestManager.startTest("TestScenario25 :Showing out error message Zone/CO is Required ");
				User_UserManagementPage.ClickAddNewUserCloseBtn();
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
				User_UserManagementPage.EnterAddNewUserName(AddNewUserNameBtn);
				User_UserManagementPage.EnterAddNewUserEmail(AddNewUserEmailBtn);
				User_UserManagementPage.EnterAddNewUserPhoneNumber(AddNewUserPhoneNumberBtn);
				User_UserManagementPage.SelectRoleDropdown(AddNewUserRole);
				User_UserManagementPage.SelectOrganizationTypeDropdown2(AddNewUserOrganizationType2);
				User_UserManagementPage.SelectHeadOfficeDropdown(AddNewUserHeadOffice);
                User_UserManagementPage.ClickAddNewUserSubmitBtn();
                boolean flag44  = User_UserManagementPage.ErrorMessageForZoneCO();
				ExtentTestManager.getTest().log(Status.PASS, "Error message Zone/CO Required" + " is displayed : " + flag44);
				Log.info("Error message Zone/CO Required is displayed: " + flag44);
				
				ExtentTestManager.startTest("TestScenario28 :Showing out error message Region is Required ");
				User_UserManagementPage.ClickAddNewUserCloseBtn();
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
				User_UserManagementPage.EnterAddNewUserName(AddNewUserNameBtn);
				User_UserManagementPage.EnterAddNewUserEmail(AddNewUserEmailBtn);
				User_UserManagementPage.EnterAddNewUserPhoneNumber(AddNewUserPhoneNumberBtn);
				User_UserManagementPage.SelectRoleDropdown(AddNewUserRole);
				User_UserManagementPage.SelectOrganizationTypeDropdown3(AddNewUserOrganizationType3);
				User_UserManagementPage.SelectHeadOfficeDropdown(AddNewUserHeadOffice);
				User_UserManagementPage.SelectAddNewUserZoneCO(AddNewUserZoneCO);
                User_UserManagementPage.ClickAddNewUserSubmitBtn();
                boolean flag45  = User_UserManagementPage.ErrorMessageForRegion();
				ExtentTestManager.getTest().log(Status.PASS, "Error message Region Required" + " is displayed : " + flag45);
				Log.info("Error message Region Required is displayed: " + flag45);
				
			
				ExtentTestManager.startTest("TestScenario31 :Showing out error message Branch is Required ");
				User_UserManagementPage.ClickAddNewUserCloseBtn();
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
				User_UserManagementPage.EnterAddNewUserName(AddNewUserNameBtn);
				User_UserManagementPage.EnterAddNewUserEmail(AddNewUserEmailBtn);
				User_UserManagementPage.EnterAddNewUserPhoneNumber(AddNewUserPhoneNumberBtn);
				User_UserManagementPage.SelectRoleDropdown(AddNewUserRole);
				User_UserManagementPage.SelectOrganizationTypeDropdown4(AddNewUserOrganizationType4);
				User_UserManagementPage.SelectHeadOfficeDropdown(AddNewUserHeadOffice);
				User_UserManagementPage.SelectAddNewUserZoneCO(AddNewUserZoneCO);
				User_UserManagementPage.SelectAddNewUserRegion(AddNewUserRegion);
                User_UserManagementPage.ClickAddNewUserSubmitBtn();
                boolean flag46  = User_UserManagementPage.ErrorMessageForBranch();
				ExtentTestManager.getTest().log(Status.PASS, "Error message Branch Required" + " is displayed : " + flag46);
				Log.info("Error message Branch Required is displayed: " + flag46);
				
				
				ExtentTestManager.startTest("TestScenario36 :Showing out No records to display for invalid username ");
				User_UserManagementPage.ClickAddNewUserCloseBtn();
				User_UserManagementPage.UsernameInput(InvalidUserName);
				User_UserManagementPage.UserManagementSearchBtn();
				TimeUnit.SECONDS.sleep(3);
                boolean flag47  = User_UserManagementPage.UserManagementInvalidSearchMsg();
				ExtentTestManager.getTest().log(Status.PASS, "Error message No records to display" + " is displayed : " + flag47);
				Log.info("Error message No records to display is displayed: " + flag47);
				
               	
			// Logout
			ExtentTestManager.startTest("Application Logout Initiated.");
			context.setAttribute("fileName", "Logout");
			click(userDropDown);
			click(L_signout);
			Thread.sleep(2000);
			driver.quit();
			ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
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


