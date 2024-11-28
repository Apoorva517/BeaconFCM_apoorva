package com.Page_Repositary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.base.Function;

public class UserManagement
{
	public By GoCollection= By.xpath("//button[text()='Go Collection']");
	public By SecurityManagementMenu= By.xpath("//span[text()='Security Management']");
	public By UserManagementMenu= By.xpath("//a[@title='User Management']");
	/*WebElement UserManagementMenu= mywait.until(new Function<webDriver,webElement>() {
		public WebElement apply(WebDriver driver) {
			return driver.findElement (By.xpath("//a[@title='User Management']"));
		}
	});*/
	public By UserManagementPageUsername= By.xpath("(//input[@class='searchinput form-control'])[1]");
	public By UserManagementPageName= By.xpath("(//input[@class='searchinput form-control']) [2]");
	public By UserManagementPageMobilenumber= By.xpath("//input[@class='rz-textbox valid searchinput form-control']");
	public By UserManagementPageEmailId= By.xpath("(//input[@class='searchinput form-control']) [3]");
	public By UserManagementPageRole= By.xpath("//div[@class='rz-dropdown valid rz-clear form-control']");
	public By UserManagementPageIsActive = By.xpath("//span[@class='rz-chkbox-icon rzi rzi-check']");
	public By UserManagementPageSearch= By.xpath("//button[text()='Search']");
	public By UserManagementPageAddUser= By.xpath("//a[text()='Add User']");
	public By UserManagementPreviousBtn= By.xpath("//li[@class='page-item disabled ']");
	public By UserManagementFirstPageBtn= By.xpath("//li[@class='page-item  active']");
	public By UserManagementSecondPageBtn= By.xpath("(//li/span[text()='2'])[3]");
	public By UserManagementThirdPageBtn= By.xpath("//li/span[text()='3']");
	public By UserManagementNextBtn= By.xpath("//li/span[text()='Next']");
	public By UserManagementNextArrowBtn= By.xpath("//li/span[text()='>>']");
	public By UserManagementPreviousArrowBtn= By.xpath("//li/span[text()='<<']"); 
	public By AddNewUserNameBtn= By.xpath("//input[@name='Name']");
	public By AddNewUserEmailBtn =  By.xpath("//input[@name='Email']");
	public By AddNewUserPhoneNumberBtn =  By.xpath("//input[@name='Mobile']");
	public By AddNewUserRole =  By.xpath("(//div[@class='rz-dropdown valid rz-clear form-control mandatory-color']) [1]");
	public By AddNewUserOrganizationType =  By.xpath("//label[contains(.,'Organization Type')]/following-sibling::div");
	public By AddNewUserCloseBtn =  By.xpath("//button[text()='Close']");
	public By AddNewUserSubmitBtn =  By.xpath("//button[text()='Submit']");	
	public By AddNewUserHeadofficeBtn =  By.xpath("//label[@class='rz-dropdown-label rz-inputtext  rz-placeholder']");	
	public By AddNewUserZoneCOBtn =  By.xpath("//label[@class='rz-dropdown-label rz-inputtext  rz-placeholder']");
	public By AddNewUserRegionBtn =  By.xpath("(//label[contains(.,'Region')]/following-sibling::div)[2]");
	public By AddNewUserBranchOption=  By.xpath("(//label[contains(.,'Branch')]/following-sibling::div) [2]");
	public By NameErrorMessage=  By.xpath("//*[@class='my-form-group form-group']//div[.='Name is required']");
	public By EmailErrorMessage=  By.xpath("//*[@class='my-form-group form-group']//div[.='Email is required']");
	public By phonenumberErrorMessage=  By.xpath("//*[@class='my-form-group form-group']//div[.='Phone number is required']");
	public By roleErrorMessage=  By.xpath("//*[@class='my-form-group form-group']//div[.='Role is required']");
	public By OrganizationTypeErrorMessage=  By.xpath("//*[@class='my-form-group form-group']//div[.='Organization type is required']");
	public By HeadOfficeDropdown =  By.xpath("(//label[contains(.,'Head office')]/following-sibling::div) [2]");
	public By InvalidEmailId =  By.xpath("//*[@class='rz-notification']//p[.='Invalid Email Id']");
	public By InvalidPhoneNumber =  By.xpath("//*[@class='rz-notification']//p[.='Invalid Mobile Number']");
	public By InvalidName =  By.xpath("//*[@class='rz-notification']//p[.='Invalid Name']");
	public By EmptyHeadofficeErrorMsg =  By.xpath("//*[@class='rz-growl-message']//p[.='Head office is Required']");
	public By UserManagementPageThreeDotBtn = By.xpath("(//button[@class='btn btn-light morebtn']) [1]");
	public By UserManagementPageEditOptn = By.xpath("(//button[text()='Edit']) [1]");
	public By EdituserPageEmailField = By.xpath("(//input[@class='form-control mandatory-color valid']) [2]");
	public By EdituserPagePhoneNumberField = By.xpath("//input[@class='rz-textbox valid form-control mandatory-color']");
	public By SuccessMessageUserCreation = By.xpath("//strong[.='User created successfully . Present password for the user: IBU0001204 is c1W3&c']");
	public By TableNameValue = By.xpath("(//tr[@class='rz-datatable-even  ']//td[3])[1]");
	public By ErrorMessageExistUserCreation = By.xpath("//*[@class='rz-growl-message']//p[.='Already User Exist ']");
	public By EmptyZoneCOErrorMsg =  By.xpath("//*[@class='rz-growl-message']//p[.='Zone/CO is Required']");
	public By EmptyRegionErrorMsg =  By.xpath("//*[@class='rz-growl-message']//p[.='Region is Required']");
	public By EmptyBranchErrorMsg =  By.xpath("//*[@class='rz-growl-message']//p[.='Branch is Required']");
	public By AddNewUserZoneCO =  By.xpath("(//label[contains(.,'Zone/CO')]/following-sibling::div)[1]");
	public By AddNewUserRegion =  By.xpath("(//label[contains(.,'Region')]/following-sibling::div)[1]");
	public By UserManagementInvalidSearchMsg =  By.xpath("//span[.='No records to display.']");
	
		
}
	