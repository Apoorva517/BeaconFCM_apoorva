package com.Pages_UserManagementModule;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import com.BasePackage.Base_Class;
import com.Page_Repositary.UserManagement;

import jdk.internal.org.jline.utils.Log;

public class User_UserManagment extends Base_Class
{
	 UserManagement PageRepositry= new UserManagement();


	public boolean GoCollection() throws InterruptedException 
	{
	
		Thread.sleep(20000);
		click(PageRepositry.GoCollection);
		Thread.sleep(20000);
		
		return true;
	}
	public boolean SelectSecurityManagementMenu() throws InterruptedException 
	{
		Thread.sleep(4000);
		click(PageRepositry.SecurityManagementMenu);
		Thread.sleep(4000);
		
		return true;
	}
	public boolean SelectUserManagementMenu() throws InterruptedException 
	{
		Thread.sleep(4000);
		click(PageRepositry.UserManagementMenu);
		Thread.sleep(6000);

		return true;
	}
	
	
	public boolean LocatorDisplayed() throws InterruptedException {
	    
	    
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
		Thread.sleep(3000);

		return true;
	}
	public boolean UserManagementSearchBtn() throws InterruptedException 
	{
		click(PageRepositry.UserManagementPageSearch);
		Thread.sleep(3000);

		return true;
	}
	public boolean UserManagementInvalidSearchMsg() throws InterruptedException 
	{
		click(PageRepositry.UserManagementInvalidSearchMsg);
		Thread.sleep(3000);

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
	
	public boolean EnterAddNewUserName(String AddNewUserNameBtn) throws InterruptedException 
	{
	
		input(PageRepositry.AddNewUserNameBtn,AddNewUserNameBtn );
		Thread.sleep(1000);

		return true;
	}
	
	public boolean EnterAddNewUserEmail(String AddNewUserEmailBtn) throws InterruptedException 
	{
		
		input(PageRepositry.AddNewUserEmailBtn, AddNewUserEmailBtn);
		Thread.sleep(1000);

		return true;
	}
	
	public boolean EnterAddNewUserPhoneNumber(String AddNewUserPhoneNumberBtn) throws InterruptedException 
	{
		
		input(PageRepositry.AddNewUserPhoneNumberBtn , AddNewUserPhoneNumberBtn);
		Thread.sleep(1000);

		return true;
	}
	
	public boolean SelectRoleDropdown(String value) throws InterruptedException {
		SelectActiveDropdown(PageRepositry.AddNewUserRole, value);
		Thread.sleep(10000);

		return true;
	}
	public boolean SelectOrganizationTypeDropdown(String value) throws InterruptedException {
		SelectActiveDropdown(PageRepositry.AddNewUserOrganizationType, value);
		Thread.sleep(10000);

		return true;
	}
	
	public boolean SelectOrganizationTypeDropdown2(String value ) throws InterruptedException 
	{
		
		SelectActiveDropdown( PageRepositry.AddNewUserOrganizationType, value);
		Thread.sleep(1000);

		return true;
	}
	public boolean SelectOrganizationTypeDropdown3(String value ) throws InterruptedException 
	{
		
		SelectActiveDropdown(PageRepositry.AddNewUserOrganizationType, value);
		Thread.sleep(1000);

		return true;
	}
	public boolean SelectOrganizationTypeDropdown4(String value ) throws InterruptedException 
	{
		
		SelectActiveDropdown(PageRepositry.AddNewUserOrganizationType, value);
		Thread.sleep(1000);

		return true;
	}
	public boolean SelectHeadOfficeDropdown(String value ) throws InterruptedException 
	{
		
		SelectActiveDropdown(PageRepositry.HeadOfficeDropdown, value);
		Thread.sleep(1000);

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
		click(PageRepositry.AddNewUserCloseBtn);
		Thread.sleep(5000);

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
    public boolean ClickEditOption() throws InterruptedException {
        click(PageRepositry.UserManagementPageThreeDotBtn);
        click(PageRepositry.UserManagementPageEditOptn);
        return true;
    }
    public boolean ClearEmailNumberField() throws InterruptedException {
        click(PageRepositry.EdituserPageEmailField);
        clear(PageRepositry.EdituserPageEmailField);
        click(PageRepositry.EdituserPagePhoneNumberField);
        clear(PageRepositry.EdituserPagePhoneNumberField);
        return true;
    }
    public boolean EnterEmailPhNumber(String EditPageEmail, String EditPagephNumber ) throws InterruptedException 
	{
	
		input(PageRepositry.EdituserPageEmailField,EditPageEmail );
		input(PageRepositry.EdituserPagePhoneNumberField,EditPagephNumber);
		return true;
	}
   
    public boolean SuccessMessageUserCreation() throws InterruptedException 
   	{
    	ElementDisplayed(PageRepositry.SuccessMessageUserCreation);
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
		Thread.sleep(5000);

		return true;
	}
    public boolean SelectAddNewUserRegion(String value) throws InterruptedException {
		SelectActiveDropdown(PageRepositry.AddNewUserRegion, value);
		Thread.sleep(5000);

		return true;
	}
}