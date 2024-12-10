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
		click( PageRepositry.RoleNameSearch);
		return true;
		
	}
	public boolean clickRoleSearchField() throws InterruptedException {
		click( PageRepositry.SearchBtn);
		//Thread.sleep(5000);
		return true;
		
	}
	public boolean RoleMngmtEltsVisibility() throws InterruptedException {
		ElementDisplayed(PageRepositry.SearchBtn);
		ElementDisplayed(PageRepositry.RoleNameSearch);
		ElementDisplayed(PageRepositry.AddNewRoleBtn);
		return true;
		
	}
	public boolean RolePermissionPopup() throws InterruptedException {
		waitSpinner(PageRepositry.tableColumn);
		waitVisibility(PageRepositry.tableColumn);
		click(PageRepositry.AddNewRoleBtn);
		waitSpinner(PageRepositry.checkbox);
		waitVisibility(PageRepositry.checkbox);
		//Thread.sleep(5000);
		click(PageRepositry.checkbox);
		//Thread.sleep(2000);
		return true;
		
	}
		
	public boolean RolePermissionSave() throws InterruptedException {
		waitSpinner(PageRepositry.DispositionCheckbox);
		waitVisibility(PageRepositry.DispositionCheckbox);
		click(PageRepositry.RolePermissionSave);
		Thread.sleep(1000);
		return true;
	}
	public boolean RoleNameErrorMsg() throws InterruptedException {
		ElementDisplayed(PageRepositry.RoleNameErrorMsg);
		return true;	
	}
	public boolean ClickCancelRole() throws InterruptedException {
		click(PageRepositry.CancelRole);
		waitSpinner(PageRepositry.tableColumn);
		waitVisibility(PageRepositry.tableColumn);
		Thread.sleep(10000);
		return true;
	}
	
	public void ClickingAllCheckbox() throws InterruptedException {
   	 
   	 By Checkboxes = (PageRepositry.AllCheckbox);
   	 List<WebElement> ListsCount = driver.findElements(Checkboxes);
   	 int rowsize =ListsCount.size();
   	 System.out.println("rowsize:-"+rowsize);  
   	 for(WebElement ListCount: ListsCount) {
   		 ListCount.click();
   	 }
	}
	public boolean AddNewRoleName(String Name) throws InterruptedException {
		waitSpinner(PageRepositry.tableColumn);
		waitVisibility(PageRepositry.tableColumn);
		click(PageRepositry.AddNewRoleBtn);
		Thread.sleep(10000);
		waitSpinner(PageRepositry.checkbox);
		waitVisibility(PageRepositry.checkbox);
		input(PageRepositry.RoleName, Name);
		return true;
	}
	
	public boolean ClickCheckbox() throws InterruptedException {
		click(PageRepositry.checkbox);
		return true;
	}
    	 
	public boolean RoleNameSuccessMsg() throws InterruptedException {
		ElementDisplayed(PageRepositry.RoleNameSuccessMsg);
		return true;
	}
	
	public boolean InputSearchField(String SearchName) throws InterruptedException {
		Thread.sleep(10000);
		waitSpinner(PageRepositry.tableColumn);
		waitVisibility(PageRepositry.tableColumn);
		input(PageRepositry.RoleNameSearch, SearchName);
		Thread.sleep(1000);
		return true;
	}
	
	public boolean DisplayAddedRoleName() throws InterruptedException {
		waitSpinner(PageRepositry.tableColumn);
		waitVisibility(PageRepositry.tableColumn);
		ElementDisplayed(PageRepositry.AddedRoleName);
		Thread.sleep(1000);
		ElementDisplayed(PageRepositry.ThreedotButton);
		ElementDisplayed(PageRepositry.ActionColumn);
		Thread.sleep(2000);
		return true;
	}
	public boolean DisplayEditOption() throws InterruptedException {
		click(PageRepositry.ThreedotButton);
		ElementDisplayed(PageRepositry.EditBtn);
		return true;
	}
	
	public boolean EditRole() throws InterruptedException {
		click(PageRepositry.EditBtn);
		waitSpinner(PageRepositry.DispositionCheckbox);
		waitVisibility(PageRepositry.DispositionCheckbox);
		//Thread.sleep(5000);
		click(PageRepositry.checkbox);
		Thread.sleep(1000);
		click(PageRepositry.DispositionCheckbox);
		Thread.sleep(1000);
		return true;
	}
	
	public boolean UpdateRoleSuccessMsg() throws InterruptedException {
		ElementDisplayed(PageRepositry.UpdateRoleSuccessMsg);
		return true;
	}
     
	public boolean clickSearchButton() throws InterruptedException {
		click(PageRepositry.SearchBtn);
		return true;
	}
	public boolean inputRoleNameSearchField(String SearchRoleName) throws InterruptedException {
		input(PageRepositry.RoleNameSearch,SearchRoleName);
		return true;
	}
	public boolean NoRecordsMsg() throws InterruptedException {
		ElementDisplayed(PageRepositry.NoRecordsMsg);
		return true;
	}
     public boolean ValidatingTheRows() throws InterruptedException {
    	 
    	 By Rows = By.xpath("//table[@class='rz-grid-table rz-grid-table-fixed']//tbody//tr");
    	 List<WebElement> ListsCount = driver.findElements(Rows);
    	 int rowsize =ListsCount.size();
    	 System.out.println("rowsize:-"+rowsize); 
    	 boolean flag = false;
         for(int i=1;i<=rowsize;i++) {
                int j = i*2-1;
                System.out.println("J:-"+j);
                Thread.sleep(2000);
                By Elements =By.xpath("(//table[@class='rz-grid-table rz-grid-table-fixed']//tbody//tr//td[@rowspan='1']//span[@class='rz-cell-data'])["+j+"]");
                String ActualColumnName =GetElementText(Elements);
                System.out.println("User found the "+i+"row value"+ActualColumnName);
         
    	  
     }
         if (rowsize>0) {
        	 flag=true; 
         }
         return flag;
        
     }
}
 
   
	
		
	
