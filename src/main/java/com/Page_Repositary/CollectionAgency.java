package com.Page_Repositary;

import org.openqa.selenium.By;

public class CollectionAgency {
	
	public By SecurityManagement= By.xpath("//span[text()= 'Security Management']");
	public By SecurityManagementMenu= By.xpath("(//a[@data-bs-toggle='tooltip']) [2]");
	public By RoleManagementOption= By.xpath("//a[text()= 'Role Management']");
	public By SearchBtn= By.xpath("//button[@type= 'submit']");
	public By RoleNameSearch= By.xpath("//input[@type= 'search']");
	public By AddNewRoleBtn= By.xpath("//button[@class= 'addbutton btn btn-primary rounded-pill']");
	public By checkbox= By.xpath("(//input[@type= 'checkbox']) [1]");
	public By RolePermissionSave= By.xpath("//button[text()= 'Save']");
	public By RoleNameErrorMsg= By.xpath("//p[.= 'Enter Role Name']");
	public By CancelRole= By.xpath("//button[text()= 'Cancel']");

	
	
	

}
