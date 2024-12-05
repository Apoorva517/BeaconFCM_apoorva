package com.Pages_UserManagementModule;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import com.BasePackage.Base_Class;

import com.BasePackage.Base_Class;
import com.Page_Repositary.UserManagement;

import jdk.internal.org.jline.utils.Log;

public class User_UserManagment extends Base_Class
{
	 UserManagement PageRepositry= new UserManagement();


	public boolean GoCollection() throws InterruptedException 
	{
		Thread.sleep(20000);
		fluentWait("Gocollection", PageRepositry.GoCollection);
		jsClick(PageRepositry.GoCollection);
		Thread.sleep(30000);
		return true;
	}
	public boolean SelectSecurityManagementMenu() throws InterruptedException 
	{
		
		waitVisibility(PageRepositry.SecurityManagementMenu);
		click(PageRepositry.SecurityManagementMenu);
		Thread.sleep(10000);
		return true;
	}
	public boolean SelectUserManagementMenu() throws InterruptedException 
	{
		
		click(PageRepositry.UserManagementMenu);
		return true;
	}
	
	
	public boolean LocatorDisplayed() throws InterruptedException {
	    
		    waitVisibility(PageRepositry.UserManagementPageUsername);
	        ElementDisplayed(PageRepositry.UserManagementPageUsername);
	        ElementDisplayed(PageRepositry.UserManagementPageName);
	        ElementDisplayed(PageRepositry.UserManagementPageMobilenumber);
	        ElementDisplayed(PageRepositry.UserManagementPageEmailId);
	        ElementDisplayed(PageRepositry.UserManagementPageRole);
	        ElementDisplayed(PageRepositry.UserManagementPageIsActive);
	        ElementDisplayed(PageRepositry.UserManagementPageSearch);
	        ElementDisplayed(PageRepositry.UserManagementPageAddUser);

	    return true; 
	}
	public boolean UsernameInput(String username) throws InterruptedException 
	{
		input(PageRepositry.UserManagementPageUsername,username);

		return true;
	}
	public boolean UserManagementSearchBtn() throws InterruptedException 
	{
		click(PageRepositry.UserManagementPageSearch);
		Thread.sleep(20000);

		return true;
	}
	public boolean UserManagementInvalidSearchMsg() throws InterruptedException 
	{
		waitVisibility(PageRepositry.UserManagementInvalidSearchMsg);
		click(PageRepositry.UserManagementInvalidSearchMsg);
		return true;
	}

	
	public boolean isIsActiveCheckboxSelected() {
		driver.findElement(PageRepositry.UserManagementPageIsActive).isSelected();
        return true;
    }
	public boolean DisplayUserManagementPreviousBtn() throws InterruptedException {
        ElementDisplayed(PageRepositry.UserManagementPreviousBtn);
        Thread.sleep(1000);
        return true;

    }
	
	public boolean DisplayUserManagementFirstPageBtn() throws InterruptedException {
        ElementDisplayed(PageRepositry.UserManagementFirstPageBtn);
        return true;

    }
	public boolean DisplayUserManagementSecondPageBtn() throws InterruptedException {
        ElementDisplayed(PageRepositry.UserManagementSecondPageBtn);
        return true;

    }
	
	public boolean DisplayUserManagementNextBtn() throws InterruptedException {
        ElementDisplayed(PageRepositry.UserManagementNextBtn);
        return true;

    }
	
	public boolean DisplayUserManagementLastArrowBtn() throws InterruptedException {
        ElementDisplayed(PageRepositry.UserManagementNextArrowBtn);
        return true;

    }
	
	public boolean ClickUserManagementSecondPageBtn() throws InterruptedException 
	{
		click(PageRepositry.UserManagementSecondPageBtn);
		Thread.sleep(10000);

		return true;
	}
	
	public boolean ClickUserManagementLastArrowBtn() throws InterruptedException 
	{
		//fluentWait(PageRepositry.UserManagementNextArrowBtn);
		click(PageRepositry.UserManagementNextArrowBtn);
		Thread.sleep(20000);

		return true;
	}
	
	public boolean ClickUserManagementPreviousArrowBtn() throws InterruptedException 
	{
		
		click(PageRepositry.UserManagementPreviousArrowBtn);
		Thread.sleep(10000);

		return true;
	}
	
	public boolean ClickUserManagementPageAddUserBtn() throws InterruptedException 
	{
		fluentWait("AddUser", PageRepositry.UserManagementPageAddUser);
		click(PageRepositry.UserManagementPageAddUser);
		Thread.sleep(10000);
		return true;
	}
	public boolean AddNewUserPageElementsDisplayed() throws InterruptedException {
	  
	    
	        ElementDisplayed(PageRepositry.AddNewUserNameBtn);
	        ElementDisplayed(PageRepositry.AddNewUserEmailBtn);
	        ElementDisplayed(PageRepositry.AddNewUserPhoneNumberBtn);
	        ElementDisplayed(PageRepositry.AddNewUserRole);
	        ElementDisplayed(PageRepositry.AddNewUserOrganizationType);
	        ElementDisplayed(PageRepositry.AddNewUserCloseBtn);
	        ElementDisplayed(PageRepositry.AddNewUserSubmitBtn);
	        return true;
	}
	
	
	public boolean FetchTableHeaderName() throws InterruptedException {
		List<WebElement> tds = driver.findElements(PageRepositry.tableHeaderName);

    	for(WebElement td : tds){
    	 String name = td.getText();
    	 System.out.println(name);
    	}
    	ElementDisplayed(PageRepositry.ActivateGreenStatus);
		ElementDisplayed(PageRepositry.tableHeaderName);
		return true;
    }
	public boolean EnterAddNewUserName(String AddNewUserNameBtn) throws InterruptedException 
	{
	
		input(PageRepositry.AddNewUserNameBtn,AddNewUserNameBtn );

		return true;
	}
	   
	public boolean EnterAddNewUserEmail(String AddNewUserEmailBtn) throws InterruptedException 
	{
		
		input(PageRepositry.AddNewUserEmailBtn, AddNewUserEmailBtn);

		return true;
	}
	
	public boolean EnterAddNewUserPhoneNumber(String AddNewUserPhoneNumberBtn) throws InterruptedException 
	{
		
		input(PageRepositry.AddNewUserPhoneNumberBtn , AddNewUserPhoneNumberBtn);

		return true;
	}
	
	public boolean SelectRoleDropdown(String value) throws InterruptedException {
		SelectActiveDropdown(PageRepositry.AddNewUserRole, value);

		return true;
	}
	public boolean SelectOrganizationTypeDropdown(String value) throws InterruptedException {
		SelectActiveDropdown(PageRepositry.AddNewUserOrganizationType, value);

		return true;
	}
	
	public boolean SelectOrganizationTypeDropdown2(String value ) throws InterruptedException 
	{
		
		SelectActiveDropdown( PageRepositry.AddNewUserOrganizationType, value);

		return true;
	}
	public boolean SelectOrganizationTypeDropdown3(String value ) throws InterruptedException 
	{
		
		SelectActiveDropdown(PageRepositry.AddNewUserOrganizationType, value);

		return true;
	}
	public boolean SelectOrganizationTypeDropdown4(String value ) throws InterruptedException 
	{
		
		SelectActiveDropdown(PageRepositry.AddNewUserOrganizationType, value);

		return true;
	}
	public boolean SelectHeadOfficeDropdown(String value ) throws InterruptedException 
	{
		
		SelectActiveDropdown(PageRepositry.HeadOfficeDropdown, value);

		return true;
	}
		
	public boolean DisplayAddNewUserHeadofficeBtn() throws InterruptedException {
	  
	    
	        ElementDisplayed(PageRepositry.AddNewUserHeadofficeBtn);
	        return true;
	}
	
	public boolean DisplayAddNewUserZoneCOBtn() throws InterruptedException {
	 
	    
	        ElementDisplayed(PageRepositry.AddNewUserHeadofficeBtn);
	        return true;
	}
	
	public boolean DisplayAddNewUserRegionBtn() throws InterruptedException 
	{
		
		   ElementDisplayed(PageRepositry.AddNewUserRegionBtn);
		   return true;
	}
//	
	public boolean DisplayAddNewUserBranchBtn() throws InterruptedException 
	{
		
		   ElementDisplayed(PageRepositry.AddNewUserBranchOption);
		   return true;
	}
	
	public boolean ClickAddNewUserSubmitBtn() throws InterruptedException 
	{
		
		fluentWait("Submit Btn", PageRepositry.AddNewUserSubmitBtn);
		click(PageRepositry.AddNewUserSubmitBtn);
        return true;
	}
	
	public boolean ClearAddNewUserElements() throws InterruptedException 
	{
		clear(PageRepositry.AddNewUserNameBtn);
		clear(PageRepositry.AddNewUserEmailBtn);
		clear(PageRepositry.AddNewUserPhoneNumberBtn);
		clear(PageRepositry.AddNewUserRole);
		clear(PageRepositry.AddNewUserOrganizationType);
		return true;
	}
	
	public boolean ErrormessageforAdduserPage() throws InterruptedException {
	    
	        ElementDisplayed(PageRepositry.NameErrorMessage);
	        ElementDisplayed(PageRepositry.EmailErrorMessage);
	        ElementDisplayed(PageRepositry.phonenumberErrorMessage);
	        ElementDisplayed(PageRepositry.roleErrorMessage);
	        ElementDisplayed(PageRepositry.OrganizationTypeErrorMessage);
	        return true;
	}

    public boolean ErrormessageforNameField() throws InterruptedException {
           ElementDisplayed(PageRepositry.NameErrorMessage);
           return true;
    }
    
    public boolean ClickAddNewUserCloseBtn() throws InterruptedException 
	{
    	fluentWait("CloseBtn", PageRepositry.AddNewUserCloseBtn);
    	click(PageRepositry.AddNewUserCloseBtn);
		Thread.sleep(10000);

		return true;
	}
    public boolean ErrormessageforEmailField() throws InterruptedException {
        ElementDisplayed(PageRepositry.EmailErrorMessage);
        return true;
    }
    public boolean ErrormessageforPhoneNumberField() throws InterruptedException {
        ElementDisplayed(PageRepositry.phonenumberErrorMessage);
        return true;
    }
    public boolean ErrormessageforRoleField() throws InterruptedException {
        ElementDisplayed(PageRepositry.roleErrorMessage);
        return true;
    }
    public boolean ErrormessageforOrganizationTypeField() throws InterruptedException {
        ElementDisplayed(PageRepositry.OrganizationTypeErrorMessage);
        return true;
    }
    public boolean ErrormessageforInvalidEmailId() throws InterruptedException {
        ElementDisplayed(PageRepositry.InvalidEmailId);
        return true;
    }
    public boolean ErrormessageforInvalidPhoneNumber() throws InterruptedException {
        ElementDisplayed(PageRepositry.InvalidPhoneNumber);
        return true;
    }
    public boolean ErrormessageforInvalidName() throws InterruptedException {
        ElementDisplayed(PageRepositry.InvalidName);
        return true;
    }
    public boolean ErrormessageforEmptyHeadoffice() throws InterruptedException {
        ElementDisplayed(PageRepositry.EmptyHeadofficeErrorMsg);
        return true;
    }
 
    public boolean EnterEmailPhNumber(String EditPageEmail, String EditPagephNumber ) throws InterruptedException 
	{
	
		input(PageRepositry.EdituserPageEmailField,EditPageEmail );
		input(PageRepositry.EdituserPagePhoneNumberField,EditPagephNumber);
		return true;
	}
   
    public boolean SuccessMessage() throws InterruptedException 
   	{
    	ElementDisplayed(PageRepositry.SuccessMessage);
   		return true;
   	}
    public String FetchTableNameValue() throws InterruptedException {
        String Name = driver.findElement(PageRepositry.TableNameValue).getText(); // Assign value to 'Name'
        System.out.println(Name); // Print value to console, if necessary
        return Name; // Return the fetched value
    }
    public boolean ErrorMessageExistUserCreation() throws InterruptedException {
        ElementDisplayed(PageRepositry.ErrorMessageExistUserCreation);
        return true;
    }
    
    public String GetUserNameandPassowrd() {
    	String message = driver.findElement(PageRepositry.SuccessMessage).getText();
    	return message;
    }
    public boolean ErrorMessageForZoneCO() throws InterruptedException {
        ElementDisplayed(PageRepositry.EmptyZoneCOErrorMsg);
        return true;
    }
    public boolean ErrorMessageForRegion() throws InterruptedException {
        ElementDisplayed(PageRepositry.EmptyRegionErrorMsg);
        return true;
    }
    public boolean ErrorMessageForBranch() throws InterruptedException {
        ElementDisplayed(PageRepositry.EmptyBranchErrorMsg);
        return true;
    }
    public boolean SelectAddNewUserZoneCO(String value) throws InterruptedException {
		SelectActiveDropdown(PageRepositry.AddNewUserZoneCO, value);

		return true;
	}
    public boolean SelectAddNewUserRegion(String value) throws InterruptedException {
		SelectActiveDropdown(PageRepositry.AddNewUserRegion, value);

		return true;
	}
    public boolean SelectAddNewUserBranch(String value) throws InterruptedException {
  		SelectActiveDropdown(PageRepositry.AddNewUserBranch, value);

  		return true;
  	}
    public boolean ClickLogoutOption() throws InterruptedException {
        click(PageRepositry.userDropDown);
        click(PageRepositry.L_signout);
        return true;
    }
    public boolean EnterLoginPageCredential(String username, String password ) throws InterruptedException 
   	{
   	
   		input(PageRepositry.username,username );
   		input(PageRepositry.password,password);
   		return true;
   	}
    public boolean ClickLoginBtn() throws InterruptedException {
        click(PageRepositry.SignIn);
        return true;
    }
    public boolean ModuleSelectionEltDisplayed() throws InterruptedException 
	{
	
		ElementDisplayed(PageRepositry.GoCollection);
		ElementDisplayed(PageRepositry.RecoverySectionSetasDefault);
		ElementDisplayed(PageRepositry.UserName);
		ElementDisplayed(PageRepositry.UserId);
		ElementDisplayed(PageRepositry.UserName);
		return true;
	}
    
    public boolean SetasDefaulNotSelected() {
        return !driver.findElement(PageRepositry.SetasDefault).isSelected();
     
    }
    public String FetchUserName() throws InterruptedException {
        String Name = driver.findElement(PageRepositry.UserName).getText(); 
        System.out.println(Name);
        return Name; 
    }
    public String UserId() throws InterruptedException {
        String Name = driver.findElement(PageRepositry.UserId).getText(); 
        System.out.println(Name);
        return Name; 
    }
    public boolean SelectUserManagementPageRole(String value) throws InterruptedException {
		SelectActiveDropdown(PageRepositry.UserManagementPageRole, value);

		return true;
	}
    
    public boolean ClearUserManagementPageRole() throws InterruptedException {
		click(PageRepositry.ClearUserManagementPageRole);

		return true;
	}
    public boolean ClickUserManagementPageSearchBtn() throws InterruptedException {
		click(PageRepositry.UserManagementPageSearch);
		Thread.sleep(10000);

		return true;
	}
    
    public boolean FetchHeaderRole() throws InterruptedException {
    	List<WebElement> tds = driver.findElements(PageRepositry.tableElts);

    	for(WebElement td : tds){
    	 String name = td.getText();
    	 System.out.println(name);
    	}
    	ElementDisplayed(PageRepositry.tableRoleHeader);

		return true;
	}
    public boolean EnterUsernameInUNPage(String UN) throws InterruptedException 
	{
    	input(PageRepositry.UserManagementPageUsername,UN);
		return true;
	}
    
    public boolean ClearUsernameInUNPage() throws InterruptedException 
	{
        clear(PageRepositry.UserManagementPageUsername);
       
		return true;
	}
    public boolean FetchTableUsername() throws InterruptedException {
    	List<WebElement> tds = driver.findElements(PageRepositry.tableUsernameElts);

    	for(WebElement td : tds){
    	 String name = td.getText();
    	 System.out.println(name);
    	}
    	ElementDisplayed(PageRepositry.ActivateGreenStatus);
    	ElementDisplayed(PageRepositry.tableHeaderName);
    	ElementDisplayed(PageRepositry.tableUsername);

		return true;
	}
    public boolean StepsOnDeactivateOptn() throws InterruptedException {
        click(PageRepositry.UserManagementPageThreeDotBtn);
        Thread.sleep(2000);
        click(PageRepositry.activateDeactivateBtn);
        Thread.sleep(2000);
        ElementDisplayed(PageRepositry.SuccessMessageUserCreation);
        click(PageRepositry.UserManagementPageActiveCheck);
        Thread.sleep(10000);
        click(PageRepositry.UserManagementPageSearch);
        Thread.sleep(10000);
        return true;
    }
    public boolean DisplayDeactivateRedStatus() throws InterruptedException {
    	ElementDisplayed(PageRepositry.DeactivateRedStatus);

		return true;
	}
    public boolean StepsOnActivateOptn() throws InterruptedException {
    	 click(PageRepositry.UserManagementPageThreeDotBtn);
         Thread.sleep(2000);
         click(PageRepositry.activateDeactivateBtn);
         Thread.sleep(2000);
         ElementDisplayed(PageRepositry.SuccessMessageUserCreation);
        waitVisibility(PageRepositry.UserManagementPageActiveUnCheck);
        click(PageRepositry.UserManagementPageActiveUnCheck);
        Thread.sleep(10000);
        click(PageRepositry.UserManagementPageSearch);
        Thread.sleep(10000);
        return true;
    }
    public boolean DisplayActivateGreenStatus() throws InterruptedException {
    	ElementDisplayed(PageRepositry.ActivateGreenStatus);

		return true;
	}
    public boolean ResetPassword() throws InterruptedException {
    	click(PageRepositry.UserManagementPageThreeDotBtn);
    	click(PageRepositry.ResetPassword);
    	ElementDisplayed(PageRepositry.ResetPasswordMsg);

		return true;
	}
    public boolean EditUserDetails() throws InterruptedException {
    	click(PageRepositry.UserManagementPageThreeDotBtn);
    	click(PageRepositry.EditBtn);
    	ElementDisplayed(PageRepositry.EditPageName);
    	ElementDisplayed(PageRepositry.EditPageEmail);
    	ElementDisplayed(PageRepositry.EditPagePhNumber);
    	ElementDisplayed(PageRepositry.EditPageRole);
    	ElementDisplayed(PageRepositry.EditPageOrganizationType);
    	ElementDisplayed(PageRepositry.EditPageHeadoffice);
    	ElementDisplayed(PageRepositry.CloseBtn);
    	ElementDisplayed(PageRepositry.UpdateBtn);

		return true;
	}
}