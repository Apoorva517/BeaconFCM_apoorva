package com.Pages_UserManagementModule;

import com.BasePackage.Base_Class;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import com.BasePackage.Base_Class;

import com.BasePackage.Base_Class;
import com.Page_Repositary.CollectionAgency;
import com.Page_Repositary.UserManagement;

import jdk.internal.org.jline.utils.Log;
import com.Page_Repositary.UserManagement;

public class Collection_CollectionAgencyRoleManagementModule extends Base_Class {
	
	CollectionAgency PageRepositry= new CollectionAgency();


	public boolean ClickSecurityManagement() throws InterruptedException 
	{
	
		fluentWait("SecurityManagementMenu", PageRepositry.SecurityManagementMenu);
		click(PageRepositry.SecurityManagementMenu);
		click(PageRepositry.RoleManagementOption);
		return true;
	}
	public boolean RoleNameSearchField() throws InterruptedException {
		fluentWait("SearchField", PageRepositry.RoleNameSearch);
		ElementDisplayed( PageRepositry.RoleNameSearch);
		return true;
		
	}
	public boolean RoleMngmtEltsVisibility() throws InterruptedException {
		ElementDisplayed(PageRepositry.SearchBtn);
		ElementDisplayed(PageRepositry.RoleNameSearch);
		ElementDisplayed(PageRepositry.AddNewRoleBtn);
		return true;
		
	}
	public boolean ClickRoleSaveBtn() throws InterruptedException {
		click(PageRepositry.AddNewRoleBtn);
		Thread.sleep(3000);
		fluentWait("checkbox",PageRepositry.checkbox);
		click(PageRepositry.checkbox);
		fluentWait("checkbox",PageRepositry.checkbox);
		fluentWait("Save", PageRepositry.RolePermissionSave);
		click(PageRepositry.RolePermissionSave);
		return true;
		
	}
	public boolean RoleNameErrorMsg() throws InterruptedException {
		fluentWait("ErrorMsg",PageRepositry.RoleNameErrorMsg);
		ElementDisplayed(PageRepositry.RoleNameErrorMsg);
		return true;	
	}
	public boolean ClickCancelRole() throws InterruptedException {
		fluentWait("CancelRole",PageRepositry.CancelRole);
		click(PageRepositry.CancelRole);
		return true;
	}

}
	
	
		
	
