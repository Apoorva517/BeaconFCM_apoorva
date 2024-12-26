package com.Pages_UserManagementModule;

import com.BasePackage.Base_Class;
import com.BasePackage.Common;
import com.Page_Repositary.CollectionAgency;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Collection_CollectionAgencyRoleManagementModule extends Base_Class {
	
	CollectionAgency PageRepositry= new CollectionAgency();

	public boolean ClickSecurityManagement() throws InterruptedException 
	{
		click(PageRepositry.SecurityManagementMenu);
		click(PageRepositry.RoleManagementOption);
		Common.waitForSpinnerToDisappear(driver, "Loading Spinner", PageRepositry.waitSpinner);
		fluentWait("Next Btn", PageRepositry.NextBtn);
		Thread.sleep(5000);
		return true;
	}
	public boolean RoleNameSearchField() throws InterruptedException {
		click( PageRepositry.RoleNameSearch);
		Common.waitForSpinnerToDisappear(driver, "Loading Spinner", PageRepositry.waitSpinner);
		return true;
	
	}
	public boolean clickRoleSearchField() throws InterruptedException {
		click( PageRepositry.SearchBtn);
		Common.waitForSpinnerToDisappear(driver, "Loading Spinner", PageRepositry.waitSpinner);
		fluentWait("Next Btn", PageRepositry.NextBtn);
		Thread.sleep(5000);
		return true;
		
	}
	public boolean RoleMngmtEltsVisibility() throws InterruptedException {
		ElementDisplayed(PageRepositry.SearchBtn);
		ElementDisplayed(PageRepositry.RoleNameSearch);
		ElementDisplayed(PageRepositry.AddNewRoleBtn);
		return true;
		
	}
	public boolean RolePermissionPopup() throws InterruptedException {
		click(PageRepositry.AddNewRoleBtn);
		Common.waitForSpinnerToDisappear(driver, "Loading Spinner", PageRepositry.waitSpinner);
		click(PageRepositry.CloseBtn);
		Common.waitForSpinnerToDisappear(driver, "Loading Spinner", PageRepositry.waitSpinner);
		fluentWait("Next Btn", PageRepositry.NextBtn);
		Thread.sleep(5000);
		click(PageRepositry.AddNewRoleBtn);
		fluentWait("checkbox", PageRepositry.checkbox);
		Thread.sleep(3000);
		click(PageRepositry.checkbox);
		//Thread.sleep(2000);
		return true;
		
	}
		
	public boolean RolePermissionSave() throws InterruptedException {
		Common.waitForSpinnerToDisappear(driver, "Loading Spinner", PageRepositry.waitSpinner);
		click(PageRepositry.RolePermissionSave);
		return true;
	}
	public boolean RoleNameErrorMsg() throws InterruptedException {
		ElementDisplayed(PageRepositry.RoleNameErrorMsg);
		Common.waitForSpinnerToDisappear(driver, "Loading Spinner", PageRepositry.waitSpinner);
		return true;	
	}
	
	public static void zoomIn(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='100%'"); // Zoom in to 150%
    }

    // Method to zoom out (decrease zoom)
    public boolean zoomOut(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='70%'");
        return true;
    }
	public boolean ClickCancelRole() throws InterruptedException {
		click(PageRepositry.CancelRole);
		Common.waitForSpinnerToDisappear(driver, "Loading Spinner", PageRepositry.waitSpinner);
		zoomIn(driver);
		Common.waitForSpinnerToDisappear(driver, "Loading Spinner", PageRepositry.waitSpinner);
		Thread.sleep(3000);
		fluentWait("Next Btn", PageRepositry.NextBtn);
		Thread.sleep(5000);
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
		click(PageRepositry.AddNewRoleBtn);
		Common.waitForSpinnerToDisappear(driver, "Loading Spinner", PageRepositry.waitSpinner);
		click(PageRepositry.CloseBtn);
		Common.waitForSpinnerToDisappear(driver, "Loading Spinner", PageRepositry.waitSpinner);
		fluentWait("Next Btn", PageRepositry.NextBtn);
		Thread.sleep(5000);
		click(PageRepositry.AddNewRoleBtn);
		fluentWait("checkbox", PageRepositry.checkbox);
		Thread.sleep(3000);
		input(PageRepositry.RoleName, Name);
		return true;
	}
	
	public boolean ClickCheckbox() throws InterruptedException {
		click(PageRepositry.checkbox);
		return true;
	}
    	 
	public boolean RoleNameSuccessMsg() throws InterruptedException {
		fluentWait("RoleNameSuccessMsg", PageRepositry.RoleNameSuccessMsg);
		ElementDisplayed(PageRepositry.RoleNameSuccessMsg);
		Common.waitForSpinnerToDisappear(driver, "Loading Spinner", PageRepositry.waitSpinner);
		fluentWait("Next Btn", PageRepositry.NextBtn);
		return true;
	}
	
	public boolean InputSearchField(String SearchName) throws InterruptedException {
		Common.waitForSpinnerToDisappear(driver, "Loading Spinner", PageRepositry.waitSpinner);
		fluentWait("Next Btn", PageRepositry.NextBtn);
		Thread.sleep(5000);
		input(PageRepositry.RoleNameSearch, SearchName);
		Thread.sleep(1000);
		return true;
	}
	
	public boolean DisplayAddedRoleName() throws InterruptedException {
		ElementDisplayed(PageRepositry.AddedRoleName);
		Thread.sleep(1000);
		ElementDisplayed(PageRepositry.ThreedotButton);
		ElementDisplayed(PageRepositry.ActionColumn);
		Thread.sleep(1000);
		return true;
	}
	public boolean DisplayEditOption() throws InterruptedException {
		click(PageRepositry.ThreedotButton);
		ElementDisplayed(PageRepositry.EditBtn);
		Common.waitForSpinnerToDisappear(driver, "Loading Spinner", PageRepositry.waitSpinner);
		fluentWait("Next Btn", PageRepositry.NextBtn);
		return true;
	}
	
	public boolean EditRole() throws InterruptedException {
		click(PageRepositry.EditBtn);
		Common.waitForSpinnerToDisappear(driver, "Loading Spinner", PageRepositry.waitSpinner);
		Thread.sleep(3000);
		fluentWait("checkbox", PageRepositry.checkbox);
		Thread.sleep(3000);
		click(PageRepositry.checkbox);
		Common.waitForSpinnerToDisappear(driver, "Loading Spinner", PageRepositry.waitSpinner);
		click(PageRepositry.DispositionCheckbox);
		Common.waitForSpinnerToDisappear(driver, "Loading Spinner", PageRepositry.waitSpinner);
		return true;
	}
	
	public boolean UpdateRoleSuccessMsg() throws InterruptedException {
		ElementDisplayed(PageRepositry.UpdateRoleSuccessMsg);
		Common.waitForSpinnerToDisappear(driver, "Loading Spinner", PageRepositry.waitSpinner);
		fluentWait("Next Btn", PageRepositry.NextBtn);
		Thread.sleep(2000);
		return true;
	}
     
	public boolean clickSearchButton() throws InterruptedException {
		Common.waitForSpinnerToDisappear(driver, "Loading Spinner", PageRepositry.waitSpinner);
		Thread.sleep(3000);
		click(PageRepositry.SearchBtn);
		Common.waitForSpinnerToDisappear(driver, "Loading Spinner", PageRepositry.waitSpinner);
		fluentWait("Next Btn", PageRepositry.NextBtn);
		Thread.sleep(5000);
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
	public boolean ClickAllCheckbox() throws InterruptedException 
	{
		click(PageRepositry.AgentAccountAllocationCheckbox);
		click(PageRepositry.AddNewAgentCheckbox);
		click(PageRepositry.AgentListCheckbox);
		click(PageRepositry.UploadInvoiceCheckbox);
		click(PageRepositry.DispositionFunctionalityCheckbox);
		click(PageRepositry.AllocationSummaryCheckbox);
		click(PageRepositry.RoleManagementCheckbox);
		click(PageRepositry.SupportRequestCheckbox);
		click(PageRepositry.SupportRequestStatusCheckbox);
		Common.waitForSpinnerToDisappear(driver, "Loading Spinner", PageRepositry.waitSpinner);
		Thread.sleep(3000);
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
 
   
	
		
	
