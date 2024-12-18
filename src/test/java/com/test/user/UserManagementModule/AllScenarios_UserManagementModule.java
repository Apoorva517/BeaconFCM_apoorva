package com.test.user.UserManagementModule;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.BasePackage.Common;
import com.BasePackage.Login_Class;
import com.Page_Repositary.LoginPageRepo;
import com.Page_Repositary.UserManagement;
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

public class AllScenarios_UserManagementModule extends Base_Class {
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;
	User_UserManagment User_UserManagementPage;
	UserManagement PageRepositry;
	Login_Class CoreAppLogin;
	
	private static By userDropDown = By.xpath("//button[@class='btn dropdown-toggle']");
	private static By L_signout = By.xpath("//a[text()='Logout']");

	
	@BeforeSuite
	public void reference() {
		CoreAppLogin = new Login_Class();
		ExcelReader = new com.Utility.ExcelReader("UserManagementModule");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
		User_UserManagementPage= new User_UserManagment();
		PageRepositry= new UserManagement();
	}
	
	
	@Test(dataProvider = "TestData")
	public void RUNALL(Map<Object, Object> testdata, ITestContext context) throws IOException, InterruptedException {

		try {
			//testdata.get("URL").toString();
			if (testdata.get("Run").toString().equalsIgnoreCase("Yes")) {
				
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");
				CoreAppLogin.CoreLogin();
				//ExtentTestManager.getTest().log(Status.PASS,
						//"Application Login" + com.BasePackage.Base_Class.Pagetitle);
				Log.info("Login successful !");
				
				User_UserManagementPage.SelectSecurityManagementMenu();
				boolean flag2 = User_UserManagementPage.SelectUserManagementMenu();
				Log.info("clicked UserManagementMenu : " + flag2);
				 
				ExtentTestManager.startTest("TestScenario001 :Checking all elements in UserManagementPage displayed ");
				boolean flag3=User_UserManagementPage.LocatorDisplayed();
				ExtentTestManager.getTest().log(Status.PASS, "ElementEnabled " + flag3);
				Log.info("All elements in UserManagementPage displayed : " + flag3);
				boolean flag4=User_UserManagementPage.FetchTableHeaderName();
				Log.info("Table headers is displayed : " + flag4);
				
				ExtentTestManager.startTest("TestScenario02 :Checking IsActive Checkbox Selected by default ");
				boolean flag5 = User_UserManagementPage.isIsActiveCheckboxSelected();
				ExtentTestManager.getTest().log(Status.PASS, "isIsActiveCheckboxSelected : " + flag5);
				Log.info("IsActive Checkbox Selected by default : " + flag5);
				
				ExtentTestManager.startTest("TestScenario03 :User search page - Pagination of Active users ");
				boolean flag6 = User_UserManagementPage.DisplayUserManagementPreviousBtn();;
				Log.info("Displayed UserManagement PreviousBtn : " + flag6);
				boolean flag7 = User_UserManagementPage.DisplayUserManagementFirstPageBtn();
				ExtentTestManager.getTest().log(Status.PASS, "Displayed UserManagement FirstPageBtn : " + flag7);
				Log.info("Displayed UserManagement FirstPageBtn : " + flag7);
				boolean flag8 = User_UserManagementPage.DisplayUserManagementSecondPageBtn();
				Log.info("Displayed UserManagement SecondPageBtn : " + flag8);
				boolean flag9 = User_UserManagementPage.DisplayUserManagementNextBtn();
				Log.info("Displayed UserManagement NextBtn : " + flag9);
				boolean flag10 = User_UserManagementPage.DisplayUserManagementLastArrowBtn();
				ExtentTestManager.getTest().log(Status.PASS, "Displayed User search page - Pagination of Active users : " + flag10);
				Log.info("Displayed User search page - Pagination of Active users :" + flag10);
//			
				ExtentTestManager.startTest("TestScenario04 :User search page - Pagination of Active users - Last page button functionality and data checking ");
				boolean flag11 = User_UserManagementPage.ClickUserManagementSecondPageBtn();
				ExtentTestManager.getTest().log(Status.PASS, "Clicked UserManagement SecondPageBtn : " + flag11);
				Log.info("Clicked '2nd'page button in pagination :" + flag11);
				
				ExtentTestManager.startTest("TestScenario05 :User search page - Pagination of Active users - Second page button functionality and data checking ");
				boolean flag12 = User_UserManagementPage.ClickUserManagementLastArrowBtn();
				ExtentTestManager.getTest().log(Status.PASS, "Clicked UserManagement LastArrowBtn : " + flag12);
				Log.info("Clicked on the '>>' button in pagination" + flag12);
				
				ExtentTestManager.startTest("TestScenario06 :User search page - Pagination of Active users - Previous button functionality and data checking ");
				boolean flag13 = User_UserManagementPage.ClickUserManagementPreviousArrowBtn();
				ExtentTestManager.getTest().log(Status.PASS, "Clicked UserManagement PreviousArrowBtn : " + flag13);
				Log.info("Clicked on the'Previous' button in pagination :" + flag13);
			
				ExtentTestManager.startTest("TestScenario07 :Test Redirect to Add New User Page ");
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
  			    boolean flag14 = User_UserManagementPage.AddNewUserPageElementsDisplayed();
				ExtentTestManager.getTest().log(Status.PASS, "Add New UserPage Elements Displayed or not: " + flag14);
				Log.info("Add New UserPage Elements Displayed :" + flag14);
				
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
				String NamewithNumericInput = testdata.get("NumericInputName").toString();
				String NamewithAlphaNumericInput = testdata.get("AlphaNumericInputName").toString();
				String AddNewUserZoneCO = testdata.get("ZoneCO").toString();
				String AddNewUserRegion = testdata.get("Region").toString(); 
				String InvalidUserName = testdata.get("InvalidUserName").toString();
				String AddNewUserBranch = testdata.get("Branch").toString(); 
				FakerValue newData = new FakerValue();
				String username = newData.getFirstName();
				String UserManagementPageRole= testdata.get("UserManagementPageRole").toString(); 
				String UsernameInUNPage = testdata.get("UsernameInUNPage").toString();  
				String UNOriginal= testdata.get("UNOriginal").toString(); 
				String PwdOriginal= testdata.get("PwdOriginal").toString(); 
				
				ExtentTestManager.startTest("TestScenario08 :Add new user page - Organization Type Selection as Head office - Display Head Office Dropdown ");
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
//                
                boolean SelectOrganizationtype = User_UserManagementPage.SelectOrganizationTypeDropdown(AddNewUserOrganizationType);
				ExtentTestManager.getTest().log(Status.PASS, "Selected Organization type" + " is displayed : " + SelectOrganizationtype);
                Log.info("Head office dropdown is selected : " + SelectOrganizationtype);
                 
                ExtentTestManager.startTest("TestScenario09 :Add new user page - Organization Type Selection as Zone/Co - Display Head office and Zone/CO drop down fields ");
                boolean flag16 = User_UserManagementPage.DisplayAddNewUserHeadofficeBtn();
                ExtentTestManager.getTest().log(Status.PASS, "Displayed Add New User Headoffice option : " + flag16);
                Log.info("Displayed Add New User Headoffice option : " + flag16);
                User_UserManagementPage.SelectOrganizationTypeDropdown2(AddNewUserOrganizationType2);
                boolean flag18 = User_UserManagementPage.DisplayAddNewUserHeadofficeBtn();
                ExtentTestManager.getTest().log(Status.PASS, "Displayed AddNewUser HeadofficeField : " + flag18);
                Log.info("Displayed AddNewUser HeadofficeField : " + flag18);
                boolean flag19 = User_UserManagementPage.DisplayAddNewUserZoneCOBtn();
                ExtentTestManager.getTest().log(Status.PASS, "Display AddNewUser ZoneCOField : " + flag19);
                Log.info("Displayed AddNewUser ZoneCOField : " + flag19);
                
				ExtentTestManager.startTest("TestScenario10 :Add new user page - Organization Type Selection as Region - Display Head office, Zone/CO and Region drop down fields");
                User_UserManagementPage.SelectOrganizationTypeDropdown3(AddNewUserOrganizationType3);
				boolean flag20 = User_UserManagementPage.DisplayAddNewUserHeadofficeBtn();
				Log.info("Displayed AddNewUser HeadofficeField : " + flag20);
				boolean flag21 = User_UserManagementPage.DisplayAddNewUserZoneCOBtn();
				Log.info("Displayed AddNewUser ZoneCOField : " + flag21);
				boolean flag22 = User_UserManagementPage.DisplayAddNewUserRegionBtn();
				ExtentTestManager.getTest().log(Status.PASS, "Display AddNewUser RegionField : " + flag22);
				Log.info("Displayed AddNewUser RegionField : " + flag22);
				
				ExtentTestManager.startTest("TestScenario11 :Add new user page - Organization Type Selection as Branch - Display Head office, Zone/CO, Region and Branch drop down fields");
                User_UserManagementPage.SelectOrganizationTypeDropdown4(AddNewUserOrganizationType4);
				boolean flag23 = User_UserManagementPage.DisplayAddNewUserHeadofficeBtn();
				Log.info("Displayed AddNewUser HeadofficeField : " + flag23);
				boolean flag24 = User_UserManagementPage.DisplayAddNewUserZoneCOBtn();
				Log.info("Displayed AddNewUser ZoneCOField : " + flag24);
				boolean flag25 = User_UserManagementPage.DisplayAddNewUserRegionBtn();
				Log.info("Displayed AddNewUser RegionField : " + flag25);
				boolean flag26 = User_UserManagementPage.DisplayAddNewUserBranchBtn();
				ExtentTestManager.getTest().log(Status.PASS, "Display AddNewUser BranchField : " + flag26);
				Log.info("Displayed AddNewUser BranchField : " + flag26);
				
				ExtentTestManager.startTest("TestScenario12 :Add new user page - Submit Without Inputs ");
				User_UserManagementPage.ClickAddNewUserCloseBtn();
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
				boolean flag27 = User_UserManagementPage.ClickAddNewUserSubmitBtn();
				ExtentTestManager.getTest().log(Status.PASS, "Clicked AddNewUser SubmitBtn : " + flag27);
				Log.info("Clicked AddNewUser SubmitBtn : " + flag27);
				boolean flag28 = User_UserManagementPage.ErrormessageforAdduserPage();
				ExtentTestManager.getTest().log(Status.PASS, "Error message for AdduserPage displayed : " + flag28);
				Log.info("Error message for AdduserPage displayed : " + flag28);
			
				ExtentTestManager.startTest("TestScenario13 :Add new user page - Enter and select inputs for all fields except Name Field and click on submit button");
				User_UserManagementPage.ClickAddNewUserCloseBtn();
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
                User_UserManagementPage.EnterAddNewUserEmail(AddNewUserEmailBtn);
				User_UserManagementPage.EnterAddNewUserPhoneNumber(AddNewUserPhoneNumberBtn);
				User_UserManagementPage.SelectRoleDropdown(AddNewUserRole);
                User_UserManagementPage.SelectOrganizationTypeDropdown(AddNewUserOrganizationType);
                User_UserManagementPage.SelectHeadOfficeDropdown(AddNewUserHeadOffice);
                User_UserManagementPage.ClickAddNewUserSubmitBtn();
				boolean flag29  = User_UserManagementPage.ErrormessageforNameField();
				User_UserManagementPage.AddNewUserSpinner();
				ExtentTestManager.getTest().log(Status.PASS, "Error message for NameField" + " is displayed : " + flag29);
				Log.info("Error message for NameField displayed : " + flag29);
				
		        ExtentTestManager.startTest("TestScenario14 :Add new user page - Enter and select inputs for all fields except Email Field and click on submit button");
				User_UserManagementPage.ClickAddNewUserCloseBtn();
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
				User_UserManagementPage.EnterAddNewUserName(AddNewUserNameBtn);
				User_UserManagementPage.EnterAddNewUserPhoneNumber(AddNewUserPhoneNumberBtn);
				User_UserManagementPage.SelectRoleDropdown(AddNewUserRole);
                User_UserManagementPage.SelectOrganizationTypeDropdown(AddNewUserOrganizationType);
                User_UserManagementPage.SelectHeadOfficeDropdown(AddNewUserHeadOffice);
                User_UserManagementPage.ClickAddNewUserSubmitBtn();
				boolean flag30  = User_UserManagementPage.ErrormessageforEmailField();
				User_UserManagementPage.AddNewUserSpinner();
				ExtentTestManager.getTest().log(Status.PASS, "Error message for EmailField" + " is displayed : " + flag30);
				Log.info("Error message for EmailField displayed : " + flag30);
			
				ExtentTestManager.startTest("TestScenario15 :Add new user page - Enter and select inputs for all fields except Phone number Field and click on submit button");
				User_UserManagementPage.ClickAddNewUserCloseBtn();
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
				User_UserManagementPage.EnterAddNewUserName(AddNewUserNameBtn);
				User_UserManagementPage.EnterAddNewUserEmail(AddNewUserEmailBtn);
				User_UserManagementPage.SelectRoleDropdown(AddNewUserRole);
                User_UserManagementPage.SelectOrganizationTypeDropdown(AddNewUserOrganizationType);
                User_UserManagementPage.SelectHeadOfficeDropdown(AddNewUserHeadOffice);
                User_UserManagementPage.ClickAddNewUserSubmitBtn();
				boolean flag31  = User_UserManagementPage.ErrormessageforPhoneNumberField();
				User_UserManagementPage.AddNewUserSpinner();
				ExtentTestManager.getTest().log(Status.PASS, "Error message for PhoneNumberField" + " is displayed : " + flag31);
				Log.info("Error message for PhoneNumberField displayed : " + flag31);
				
				ExtentTestManager.startTest("TestScenario16 :Add new user page - Enter and select inputs for all fields except role drop down and click on submit button");
				User_UserManagementPage.ClickAddNewUserCloseBtn();
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
				User_UserManagementPage.EnterAddNewUserName(AddNewUserNameBtn);
				User_UserManagementPage.EnterAddNewUserEmail(AddNewUserEmailBtn);
				User_UserManagementPage.EnterAddNewUserPhoneNumber(AddNewUserPhoneNumberBtn);
				User_UserManagementPage.SelectOrganizationTypeDropdown(AddNewUserOrganizationType);
                User_UserManagementPage.SelectHeadOfficeDropdown(AddNewUserHeadOffice);
                User_UserManagementPage.ClickAddNewUserSubmitBtn();
				boolean flag32  = User_UserManagementPage.ErrormessageforRoleField();
				User_UserManagementPage.AddNewUserSpinner();
				ExtentTestManager.getTest().log(Status.PASS, "Error message for RoleField" + " is displayed : " + flag32);
				Log.info("Error message for RoleField displayed : " + flag32);
			
			
				ExtentTestManager.startTest("TestScenario17 :Add new user page - Enter and select inputs for all fields except organization type drop down and click on submit button");
				User_UserManagementPage.ClickAddNewUserCloseBtn();
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
				User_UserManagementPage.EnterAddNewUserName(AddNewUserNameBtn);
				User_UserManagementPage.EnterAddNewUserEmail(AddNewUserEmailBtn);
				User_UserManagementPage.EnterAddNewUserPhoneNumber(AddNewUserPhoneNumberBtn);
				User_UserManagementPage.SelectRoleDropdown(AddNewUserRole);
                User_UserManagementPage.ClickAddNewUserSubmitBtn();
				boolean flag33  = User_UserManagementPage.ErrormessageforOrganizationTypeField();
				User_UserManagementPage.AddNewUserSpinner();
				ExtentTestManager.getTest().log(Status.PASS, "Error message for OrganizationTypeField" + " is displayed : " + flag33);
				Log.info("Error message for OrganizationTypeField displayed : " + flag33);
				
				
				ExtentTestManager.startTest("TestScenario18 :Add new user page - Invalid Email Format-missing '@'");
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
				User_UserManagementPage.AddNewUserSpinner();
				ExtentTestManager.getTest().log(Status.PASS, "Error message for Invalid Email Id" + " is displayed : " + flag34);
				Log.info("Error message for Invalid Email Id is displayed : " + flag34);
				
				ExtentTestManager.startTest("TestScenario18 :Add new user page - Invalid Email Format- missing 'domain'");
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
				User_UserManagementPage.AddNewUserSpinner();
				ExtentTestManager.getTest().log(Status.PASS, "Error message for Invalid Email Id" + " is displayed : " + flag35);
				Log.info("Error message for Invalid Email Id is displayed : " + flag35);
				
				ExtentTestManager.startTest("TestScenario19 :Add new user page -Invalid Phone Number Format- with letters");
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
				User_UserManagementPage.AddNewUserSpinner();
				ExtentTestManager.getTest().log(Status.PASS, "Error message for Invalid PhoneNumber with letters" + " is displayed : " + flag36);
				Log.info("Error message for Invalid PhoneNumber with letters is displayed : " + flag36);
				
				ExtentTestManager.startTest("TestScenario19 :Add new user page -Invalid Phone Number Format-8 digits");
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
				User_UserManagementPage.AddNewUserSpinner();
				ExtentTestManager.getTest().log(Status.PASS, "Error message for Invalid PhoneNumber with 8 digits" + " is displayed : " + flag37);
				Log.info("Error message for Invalid PhoneNumber with 8 digits is displayed : " + flag37);
				
				
				ExtentTestManager.startTest("TestScenario20 :Add new user - Name Field - ECP Validations(Alphabetic inputs)");
				User_UserManagementPage.ClickAddNewUserCloseBtn();
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
				User_UserManagementPage.EnterAddNewUserName(username);
				User_UserManagementPage.EnterAddNewUserEmail(newData.getEmail());
				User_UserManagementPage.EnterAddNewUserPhoneNumber(AddNewUserPhoneNumberBtn);
				User_UserManagementPage.SelectRoleDropdown(AddNewUserRole);
				User_UserManagementPage.SelectOrganizationTypeDropdown(AddNewUserOrganizationType);
                User_UserManagementPage.SelectHeadOfficeDropdown(AddNewUserHeadOffice);
                Thread.sleep(5000);
                fluentWait("submit btn", PageRepositry.AddNewUserSubmitBtn);
				boolean flag38  = User_UserManagementPage.ClickAddNewUserSubmitBtn();
				User_UserManagementPage.AddNewUserSpinner();
				ExtentTestManager.getTest().log(Status.PASS, "User is created with Alphabetic inputs" + " is displayed : " + flag38);
				Log.info("User created with Alphabetic inputs successfully: " + flag38);
				
				ExtentTestManager.startTest("TestScenario20 :Add new user - Name Field - ECP Validations(numeric inputs)");
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
				User_UserManagementPage.EnterAddNewUserName(NamewithNumericInput);
				User_UserManagementPage.EnterAddNewUserEmail(AddNewUserEmailBtn);
				User_UserManagementPage.EnterAddNewUserPhoneNumber(AddNewUserPhoneNumberBtn);
				User_UserManagementPage.SelectRoleDropdown(AddNewUserRole);
				User_UserManagementPage.SelectOrganizationTypeDropdown(AddNewUserOrganizationType);
                User_UserManagementPage.SelectHeadOfficeDropdown(AddNewUserHeadOffice);
                User_UserManagementPage.ClickAddNewUserSubmitBtn();
				boolean flag39  = User_UserManagementPage.ErrormessageforInvalidName();
				User_UserManagementPage.AddNewUserSpinner();
				ExtentTestManager.getTest().log(Status.PASS, "Error message Invalid Name for numeric inputs" + " is displayed : " + flag39);
				Log.info("Error message Invalid Name for numeric inputs is displayed: " + flag39);
				
				
				ExtentTestManager.startTest("TestScenario20 :Add new user - Name Field - ECP Validations(alphanumeric inputs)");
				User_UserManagementPage.ClickAddNewUserCloseBtn();
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
				User_UserManagementPage.EnterAddNewUserName(NamewithAlphaNumericInput);
				User_UserManagementPage.EnterAddNewUserEmail(AddNewUserEmailBtn);
				User_UserManagementPage.EnterAddNewUserPhoneNumber(AddNewUserPhoneNumberBtn);
				User_UserManagementPage.SelectRoleDropdown(AddNewUserRole);
				User_UserManagementPage.SelectOrganizationTypeDropdown(AddNewUserOrganizationType);
                User_UserManagementPage.SelectHeadOfficeDropdown(AddNewUserHeadOffice);
                Thread.sleep(5000);
                User_UserManagementPage.ClickAddNewUserSubmitBtn();
				boolean flag40  = User_UserManagementPage.ErrormessageforInvalidName();
				ExtentTestManager.getTest().log(Status.PASS, "Error message Invalid Name for alphanumeric inputs" + " is displayed : " + flag40);
				Log.info("Error message Invalid Name for alphanumeric inputs is displayed: " + flag40);		
				
				ExtentTestManager.startTest("TestScenario21 :Create Head Office User - No Head Office Selected - Error message validation");
				User_UserManagementPage.ClickAddNewUserCloseBtn();
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
				User_UserManagementPage.EnterAddNewUserName(AddNewUserNameBtn);
				User_UserManagementPage.EnterAddNewUserEmail(AddNewUserEmailBtn);
				User_UserManagementPage.EnterAddNewUserPhoneNumber(AddNewUserPhoneNumberBtn);
                User_UserManagementPage.SelectRoleDropdown(AddNewUserRole);
				User_UserManagementPage.SelectOrganizationTypeDropdown(AddNewUserOrganizationType);
				fluentWait("SubmitBtn", PageRepositry.HeadOffice);
                User_UserManagementPage.ClickAddNewUserSubmitBtn();
				boolean flag41  = User_UserManagementPage.ErrormessageforEmptyHeadoffice();
				ExtentTestManager.getTest().log(Status.PASS, "Error message for Empty HeadOffice" + " is displayed : " + flag41);
				Log.info("Error message for Empty HeadOffice is displayed: " + flag41);				
				ExtentTestManager.startTest("TestScenario22 :Create Head Office User - Valid Inputs - Successful user creation ");
				User_UserManagementPage.ClickAddNewUserCloseBtn();
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
			    User_UserManagementPage.EnterAddNewUserName(username);
				User_UserManagementPage.EnterAddNewUserEmail(newData.getEmail());
				User_UserManagementPage.EnterAddNewUserPhoneNumber(newData.getPhone());
				User_UserManagementPage.SelectRoleDropdown(AddNewUserRole);
				User_UserManagementPage.SelectOrganizationTypeDropdown(AddNewUserOrganizationType);
				User_UserManagementPage.SelectHeadOfficeDropdown(AddNewUserHeadOffice);
				fluentWait("SubmitBtn", PageRepositry.AddNewUserSubmitBtn);
                User_UserManagementPage.ClickAddNewUserSubmitBtn();
                boolean flag43  = User_UserManagementPage.SuccessMessage();
				ExtentTestManager.getTest().log(Status.PASS, "Success message for user creation" + " is displayed : " + flag43);
				Log.info("Success message for user creation is displayed: " + flag43);
				assertTrue("The table name value does not match the expected button name", 
				           User_UserManagementPage.FetchTableNameValue().equals(username));
				String message = User_UserManagementPage.GetUserNameandPassowrd(); 
		
				ExtentTestManager.startTest("TestScenario23 :Add new user - User already exists case");
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
				User_UserManagementPage.EnterAddNewUserName(AddNewUserNameBtn);
				User_UserManagementPage.EnterAddNewUserEmail(AddNewUserEmailBtn);
				User_UserManagementPage.EnterAddNewUserPhoneNumber(AddNewUserPhoneNumberBtn);
				User_UserManagementPage.SelectRoleDropdown(AddNewUserRole);
				User_UserManagementPage.SelectOrganizationTypeDropdown(AddNewUserOrganizationType);
				User_UserManagementPage.SelectHeadOfficeDropdown(AddNewUserHeadOffice);
				fluentWait("SubmitBtn", PageRepositry.AddNewUserSubmitBtn);
                User_UserManagementPage.ClickAddNewUserSubmitBtn();
                boolean flag42  = User_UserManagementPage.ErrorMessageExistUserCreation();
                User_UserManagementPage.AddNewUserSpinner();
				ExtentTestManager.getTest().log(Status.PASS, "Error message on creating existing user" + " is displayed : " + flag42);
				Log.info("Error message on creating existing user is displayed: " + flag42);				 
		
				ExtentTestManager.startTest("TestScenario24 :Create Head Office User - Login with newly created user");
				User_UserManagementPage.ClickLogoutOption();
			    String UNHeadoffice = message.substring(message.lastIndexOf(":") + 1, message.indexOf("is")).replaceAll(" ", "");
			    String PwdHeadoffice = message.substring(message.lastIndexOf("is") + 2).replaceAll(" ", "");
			    System.out.println(UNHeadoffice);
			    System.out.println(PwdHeadoffice);
				User_UserManagementPage.EnterLoginPageCredential(UNHeadoffice, PwdHeadoffice);
				User_UserManagementPage.ClickLoginBtn();
				User_UserManagementPage.ModuleSelectionEltDisplayed();
				assertTrue("The UserName value does not match the expected button name", 
				           User_UserManagementPage.FetchUserName().equals(UNHeadoffice));
				assertTrue("The UserID value does not match the expected button name", 
				           User_UserManagementPage.UserId().equals(username));
                boolean flag44  = User_UserManagementPage.SetasDefaulNotSelected();
				ExtentTestManager.getTest().log(Status.PASS, "Successfully redirect to module selection page" + " is displayed : " + flag44);
				Log.info("Successfully redirect to module selection page with Headoffice credentials " + flag44);
//
				ExtentTestManager.startTest("TestScenario25 :Create Zone/CO User - No Zone/Co Selected - Error message validation");
				User_UserManagementPage.GoCollectionModule();
				User_UserManagementPage.SelectSecurityManagementMenu();
				User_UserManagementPage.SelectUserManagementMenu();
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
				User_UserManagementPage.EnterAddNewUserName(AddNewUserNameBtn);
				User_UserManagementPage.EnterAddNewUserEmail(AddNewUserEmailBtn);
				User_UserManagementPage.EnterAddNewUserPhoneNumber(AddNewUserPhoneNumberBtn);
				User_UserManagementPage.SelectRoleDropdown(AddNewUserRole);
				User_UserManagementPage.SelectOrganizationTypeDropdown2(AddNewUserOrganizationType2);
				User_UserManagementPage.SelectHeadOfficeDropdown(AddNewUserHeadOffice);
				fluentWait("Zone/CO", PageRepositry.ZoneCO);
                User_UserManagementPage.ClickAddNewUserSubmitBtn();
                boolean flag45  = User_UserManagementPage.ErrorMessageForZoneCO();
				ExtentTestManager.getTest().log(Status.PASS, "Error message Zone/CO Required" + " is displayed : " + flag45);
				Log.info("Error message Zone/CO Required is displayed: " + flag45);
			
				
				ExtentTestManager.startTest("TestScenario26 :Create Zone/CO User - Valid Inputs - Successful user creation");
				User_UserManagementPage.ClickAddNewUserCloseBtn();
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
				User_UserManagementPage.EnterAddNewUserName(username);
				User_UserManagementPage.EnterAddNewUserEmail(newData.getEmail());
				User_UserManagementPage.EnterAddNewUserPhoneNumber(newData.getPhone());
				User_UserManagementPage.SelectRoleDropdown(AddNewUserRole);
				User_UserManagementPage.SelectOrganizationTypeDropdown2(AddNewUserOrganizationType2); 
				User_UserManagementPage.SelectHeadOfficeDropdown(AddNewUserHeadOffice);
				User_UserManagementPage.SelectAddNewUserZoneCO(AddNewUserZoneCO);
				fluentWait("Submit btn",PageRepositry.AddNewUserSubmitBtn);
                User_UserManagementPage.ClickAddNewUserSubmitBtn();
                boolean flag46  = User_UserManagementPage.SuccessMessage();
				ExtentTestManager.getTest().log(Status.PASS, "Success message for user creation with Zone/CO inputs" + " is displayed : " + flag46);
				String ZONECOmessage = User_UserManagementPage.GetUserNameandPassowrd();
				Log.info("Success message for user creation is displayed with Zone/CO inputs: " + flag46);
				assertTrue("The table name value does not match the expected button name", 
				           User_UserManagementPage.FetchTableNameValue().equals(username));
		
				ExtentTestManager.startTest("TestScenario27 :Create Zone/CO User - Login with newly created user ");
				User_UserManagementPage.ClickLogoutOption();
			    String UNZoneCO = ZONECOmessage.substring(ZONECOmessage.lastIndexOf(":") + 1, ZONECOmessage.indexOf("is")).replaceAll(" ", "");
			    String PwdZoneCO = ZONECOmessage.substring(ZONECOmessage.lastIndexOf("is") + 2).replaceAll(" ", "");
			    System.out.println(UNZoneCO);
			    System.out.println(PwdZoneCO);
			    Common.waitForSpinnerToDisappear(driver, "Loading Spinner", PageRepositry.loginSelectionSpinner);
				Thread.sleep(5000);
				User_UserManagementPage.EnterLoginPageCredential(UNZoneCO, PwdZoneCO);
				User_UserManagementPage.ClickLoginBtn();
				Thread.sleep(2000);
				User_UserManagementPage.ModuleSelectionEltDisplayed();
				assertTrue("The UserName value does not match the expected button name", 
				           User_UserManagementPage.FetchUserName().equals(UNZoneCO));
				assertTrue("The UserID value does not match the expected button name", 
				           User_UserManagementPage.UserId().equals(username));
                boolean flag47 = User_UserManagementPage.SetasDefaulNotSelected();
				ExtentTestManager.getTest().log(Status.PASS, "Successfully redirect to module selection page" + " is displayed : " + flag47);
  			    Log.info("Successfully redirect to module selection page with ZoneCO credentials" + flag47);
				
				ExtentTestManager.startTest("TestScenario28 :Create Region User - No Region Selected - Error message validation ");
				User_UserManagementPage.GoCollectionModule();
				User_UserManagementPage.SelectSecurityManagementMenu();
				User_UserManagementPage.SelectUserManagementMenu();   
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
				User_UserManagementPage.EnterAddNewUserName(AddNewUserNameBtn);
				User_UserManagementPage.EnterAddNewUserEmail(AddNewUserEmailBtn);
				User_UserManagementPage.EnterAddNewUserPhoneNumber(AddNewUserPhoneNumberBtn);
				User_UserManagementPage.SelectRoleDropdown(AddNewUserRole);
				User_UserManagementPage.SelectOrganizationTypeDropdown3(AddNewUserOrganizationType3);
				User_UserManagementPage.SelectHeadOfficeDropdown(AddNewUserHeadOffice);
				User_UserManagementPage.SelectAddNewUserZoneCO(AddNewUserZoneCO);
				fluentWait("Region", PageRepositry.Region);
                User_UserManagementPage.ClickAddNewUserSubmitBtn();
                boolean flag48  = User_UserManagementPage.ErrorMessageForRegion();
				ExtentTestManager.getTest().log(Status.PASS, "Error message Region Required" + " is displayed : " + flag48);
				Log.info("Error message Region Required is displayed: " + flag48);
			
				ExtentTestManager.startTest("TestScenario29 :Create Region User - Valid Inputs - Successful user creation");
				User_UserManagementPage.ClickAddNewUserCloseBtn(); 
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
				User_UserManagementPage.EnterAddNewUserName(username);
				User_UserManagementPage.EnterAddNewUserEmail(newData.getEmail());
				User_UserManagementPage.EnterAddNewUserPhoneNumber(newData.getPhone());
				User_UserManagementPage.SelectRoleDropdown(AddNewUserRole);
				User_UserManagementPage.SelectOrganizationTypeDropdown3(AddNewUserOrganizationType3);
				User_UserManagementPage.SelectHeadOfficeDropdown(AddNewUserHeadOffice);
				User_UserManagementPage.SelectAddNewUserZoneCO(AddNewUserZoneCO);
				User_UserManagementPage.SelectAddNewUserRegion(AddNewUserRegion);
				fluentWait("Submit btn",PageRepositry.AddNewUserSubmitBtn);
                User_UserManagementPage.ClickAddNewUserSubmitBtn();
                boolean flag49  = User_UserManagementPage.SuccessMessage();
				ExtentTestManager.getTest().log(Status.PASS, "Success message for user creation with Region inputs" + " is displayed : " + flag49);
				String Regionmessage = User_UserManagementPage.GetUserNameandPassowrd();
				Log.info("Success message for user creation is displayed with Region inputs: " + flag49);
				assertTrue("The table name value does not match the expected button name", 
				           User_UserManagementPage.FetchTableNameValue().equals(username));
				
				ExtentTestManager.startTest("TestScenario30 :Create Region User - Login with newly created user ");
				User_UserManagementPage.ClickLogoutOption();
			    String UNRegion = Regionmessage.substring(Regionmessage.lastIndexOf(":") + 1, Regionmessage.indexOf("is")).replaceAll(" ", "");
			    String PwdRegion = Regionmessage.substring(Regionmessage.lastIndexOf("is") + 2).replaceAll(" ", "");
			    System.out.println(UNRegion);
			    System.out.println(PwdRegion);
			    Common.waitForSpinnerToDisappear(driver, "Loading Spinner", PageRepositry.loginSelectionSpinner);
				Thread.sleep(5000);
				User_UserManagementPage.EnterLoginPageCredential(UNRegion, PwdRegion);
				User_UserManagementPage.ClickLoginBtn();
				Thread.sleep(2000);
				User_UserManagementPage.ModuleSelectionEltDisplayed();
				assertTrue("The UserName value does not match the expected button name", 
				           User_UserManagementPage.FetchUserName().equals(UNRegion));
				assertTrue("The UserID value does not match the expected button name", 
				           User_UserManagementPage.UserId().equals(username));
                boolean flag50 = User_UserManagementPage.SetasDefaulNotSelected();
				ExtentTestManager.getTest().log(Status.PASS, "Successfully redirect to module selection page" + " is displayed : " + flag50);
				Log.info("Successfully redirect to module selection page with Region credentials " + flag50);
			
				ExtentTestManager.startTest("TestScenario31 :Create Branch User - No Branch Selected - Error message validation ");
				User_UserManagementPage.GoCollectionModule();
				User_UserManagementPage.SelectSecurityManagementMenu();
				User_UserManagementPage.SelectUserManagementMenu();   
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
				User_UserManagementPage.EnterAddNewUserName(AddNewUserNameBtn);
				User_UserManagementPage.EnterAddNewUserEmail(AddNewUserEmailBtn);
				User_UserManagementPage.EnterAddNewUserPhoneNumber(AddNewUserPhoneNumberBtn);
				User_UserManagementPage.SelectRoleDropdown(AddNewUserRole);
				User_UserManagementPage.SelectOrganizationTypeDropdown4(AddNewUserOrganizationType4);
				User_UserManagementPage.SelectHeadOfficeDropdown(AddNewUserHeadOffice);
				fluentWait("ZoneCO", PageRepositry.ZoneCO);
				User_UserManagementPage.SelectAddNewUserZoneCO(AddNewUserZoneCO);
				fluentWait("Region", PageRepositry.Region);
				User_UserManagementPage.SelectAddNewUserRegion(AddNewUserRegion);
                User_UserManagementPage.ClickAddNewUserSubmitBtn();
                boolean flag51  = User_UserManagementPage.ErrorMessageForBranch();
				ExtentTestManager.getTest().log(Status.PASS, "Error message Branch Required" + " is displayed : " + flag51);
				Log.info("Error message Branch Required is displayed: " + flag51);
		
				ExtentTestManager.startTest("TestScenario32 :Create Branch User - Valid Inputs - Successful user creation");
				User_UserManagementPage.ClickAddNewUserCloseBtn();
				User_UserManagementPage.ClickUserManagementPageAddUserBtn();
				User_UserManagementPage.EnterAddNewUserName(username);
				User_UserManagementPage.EnterAddNewUserEmail(newData.getEmail());
				User_UserManagementPage.EnterAddNewUserPhoneNumber(newData.getPhone());
				User_UserManagementPage.SelectRoleDropdown(AddNewUserRole);
				User_UserManagementPage.SelectOrganizationTypeDropdown4(AddNewUserOrganizationType4);
				User_UserManagementPage.SelectHeadOfficeDropdown(AddNewUserHeadOffice);
				fluentWait("ZoneCO", PageRepositry.ZoneCO);
				User_UserManagementPage.SelectAddNewUserZoneCO(AddNewUserZoneCO);
				fluentWait("Region", PageRepositry.Region);
				User_UserManagementPage.SelectAddNewUserRegion(AddNewUserRegion);
				fluentWait("Branch", PageRepositry.Branch);
				User_UserManagementPage.SelectAddNewUserBranch(AddNewUserBranch);
				fluentWait("Submit btn",PageRepositry.AddNewUserSubmitBtn);
                User_UserManagementPage.ClickAddNewUserSubmitBtn();
                boolean flag52  = User_UserManagementPage.SuccessMessage();
                String Branchmessage = User_UserManagementPage.GetUserNameandPassowrd();
				ExtentTestManager.getTest().log(Status.PASS, "Success message for user creation with Branch inputs" + " is displayed : " + flag52);
				Log.info("Success message for user creation is displayed with Branch inputs: " + flag52);
				assertTrue("The table name value does not match the expected button name", 
				           User_UserManagementPage.FetchTableNameValue().equals(username));
			
				ExtentTestManager.startTest("TestScenario33 :Create Branch User - Login with newly created user ");
				User_UserManagementPage.ClickLogoutOption();
			    String UNBranch = Branchmessage.substring(Branchmessage.lastIndexOf(":") + 1, Branchmessage.indexOf("is")).replaceAll(" ", "");
			    String PwdBranch = Branchmessage.substring(Branchmessage.lastIndexOf("is") + 2).replaceAll(" ", "");
			    System.out.println(UNBranch);
			    System.out.println(PwdBranch);
			    Common.waitForSpinnerToDisappear(driver, "Loading Spinner", PageRepositry.loginSelectionSpinner);
				Thread.sleep(5000);
				User_UserManagementPage.EnterLoginPageCredential(UNBranch, PwdBranch);
				User_UserManagementPage.ClickLoginBtn();
				Thread.sleep(2000);
				User_UserManagementPage.ModuleSelectionEltDisplayed();
				assertTrue("The UserName value does not match the expected button name", 
				           User_UserManagementPage.FetchUserName().equals(UNBranch));
				assertTrue("The UserID value does not match the expected button name", 
				           User_UserManagementPage.UserId().equals(username));
				boolean flag53 = User_UserManagementPage.SetasDefaulNotSelected();
                ExtentTestManager.getTest().log(Status.PASS, "Successfully redirect to module selection page" + " is displayed : " + flag53);
				Log.info("Successfully redirect to module selection page with Branch credentials :" + flag53);
				
				ExtentTestManager.startTest("TestScenario34 :User search page - Search with Valid User Name");
				User_UserManagementPage.ClickLogoutOption();
				Common.waitForSpinnerToDisappear(driver, "Loading Spinner", PageRepositry.loginSelectionSpinner);
				Thread.sleep(5000);
				User_UserManagementPage.EnterLoginPageCredential(UNOriginal, PwdOriginal);
				User_UserManagementPage.ClickLoginBtn();
				Thread.sleep(5000);
				Common.waitForSpinnerToDisappear(driver, "Loading Spinner", PageRepositry.moduleSelectionSpinner);
				User_UserManagementPage.SelectSecurityManagementMenu();
				Thread.sleep(1000);
				User_UserManagementPage.SelectUserManagementMenu();  
				Common.waitForSpinnerToDisappear(driver, "Loading Spinner", PageRepositry.moduleSelectionSpinner);
				User_UserManagementPage.EnterUsernameInUNPage(UsernameInUNPage);
				User_UserManagementPage.ClickUserManagementPageSearchBtn();
				boolean flag54 = User_UserManagementPage.FetchTableUsername();
                ExtentTestManager.getTest().log(Status.PASS, "User search page - Valid Username row" + " is displayed : " + flag54);
				Log.info("User search page - Valid Username row is displayed" + flag54);
				
				ExtentTestManager.startTest("TestScenario35 :User search page - Role Dropdown Selection ");
				User_UserManagementPage.ClearUsernameInUNPage(); 
				Thread.sleep(1000);
				User_UserManagementPage.SelectUserManagementPageRole(UserManagementPageRole);
				User_UserManagementPage.ClickUserManagementPageSearchBtn();
				boolean flag55 = User_UserManagementPage.FetchHeaderRole();
                ExtentTestManager.getTest().log(Status.PASS, "User search page - Role DropDown Selection" + " is displayed : " + flag55);
				Log.info("User search page - Role DropDown Selection is displayed" + flag55);			
			
				ExtentTestManager.startTest("TestScenario36 :User search page - Search with Invalid User Name ");
				User_UserManagementPage.ClearUserManagementPageRole();
				User_UserManagementPage.UsernameInput(InvalidUserName);
				User_UserManagementPage.UserManagementSearchBtn();
                boolean flag56  = User_UserManagementPage.UserManagementInvalidSearchMsg();
				ExtentTestManager.getTest().log(Status.PASS, "Error message No records to display" + " is displayed : " + flag56);
				Log.info("Error message No records to display is displayed: " + flag56);
							
				ExtentTestManager.startTest("TestScenario37 :User search page - Activate/Deactivate selection of an Active User ");
				User_UserManagementPage.ClearUsernameInUNPage(); 
				User_UserManagementPage.EnterUsernameInUNPage(UsernameInUNPage);
				User_UserManagementPage.ClickUserManagementPageSearchBtn();
				boolean flag57  = User_UserManagementPage.StepsOnDeactivateOptn();
				Log.info("Success Status changed message is displayed: " + flag57);
                boolean flag58  = User_UserManagementPage.DisplayDeactivateRedStatus(); ;
				ExtentTestManager.getTest().log(Status.PASS, "Record deactivated, Red cross" + " is displayed : " + flag58);
				Log.info("Record deactivated, Red cross is displayed: " + flag58);
				Thread.sleep(1000);
				
				ExtentTestManager.startTest("TestScenario38 :User search page  - Activate/Deactivate selection of an Inactive User ");
				boolean flag59  = User_UserManagementPage.StepsOnActivateOptn(); 
				Log.info("Success Status changed message is displayed: " + flag59);
                boolean flag60  = User_UserManagementPage.DisplayActivateGreenStatus(); ;
				ExtentTestManager.getTest().log(Status.PASS, "Record Activated, Green cross" + " is displayed : " + flag60);
				Log.info("Record Activated, Green cross is displayed: " + flag60);
				
				ExtentTestManager.startTest("TestScenario39 :User search page  - Reset Password");
				User_UserManagementPage.ClearUsernameInUNPage();
				User_UserManagementPage.EnterUsernameInUNPage(UsernameInUNPage);
				User_UserManagementPage.ClickUserManagementPageSearchBtn();
				boolean flag61  = User_UserManagementPage.ResetPassword(); 
				ExtentTestManager.getTest().log(Status.PASS, "Reset Password changed Status message" + " is displayed : " + flag61);
				Log.info("Reset Password changed Status message is displayed: " + flag61);
				
				ExtentTestManager.startTest("TestScenario40 :User search page  -  Edit User Details");
				User_UserManagementPage.ClearUsernameInUNPage(); 
				User_UserManagementPage.EnterUsernameInUNPage(UsernameInUNPage);
				User_UserManagementPage.ClickUserManagementPageSearchBtn();
				boolean flag62  = User_UserManagementPage.EditUserDetails(); 
				ExtentTestManager.getTest().log(Status.PASS, "Edit User Details elements" + " is displayed : " + flag62);
				Log.info("Edit User Details elements is displayed:" + flag62);
				
               	 
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