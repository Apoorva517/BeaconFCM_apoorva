package com.Pages_UserManagementModule;

import com.BasePackage.Base_Class;
import com.BasePackage.Common;
import com.Page_Repositary.CollectionAgency;

public class Add_AddNewAgent extends Base_Class {
	
	Add_AddNewAgent PageRepositry= new Add_AddNewAgent();

	public boolean ClickSecurityManagement() throws InterruptedException 
	{
		click(PageRepositry.SecurityManagementMenu);
		click(PageRepositry.RoleManagementOption);
		Common.waitForSpinnerToDisappear(driver, "Loading Spinner", PageRepositry.waitSpinner);
		fluentWait("Next Btn", PageRepositry.NextBtn);
		Thread.sleep(5000);
		return true;
		
	}
}