package com.Pages_UserManagementModule;

import com.BasePackage.Base_Class;
import com.BasePackage.Common;
import com.Page_Repositary.AddNewAgent;


public class Add_AddNewAgent extends Base_Class {
	
	AddNewAgent PageRepositry= new AddNewAgent();

	public boolean ClickSecurityManagement() throws InterruptedException 
	{
		click(PageRepositry.AgentManagement);
		click(PageRepositry.AgentlistSubMenu);
		Common.waitForSpinnerToDisappear(driver, "Loading Spinner", PageRepositry.waitSpinner);
		fluentWait("Next Btn", PageRepositry.NextBtn);
		Thread.sleep(2000);
		return true;
		
	}
}