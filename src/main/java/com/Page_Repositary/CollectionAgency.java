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
	public By AllCheckbox= By.xpath("//input[@type='checkbox']");
	public By RolePermissionSave= By.xpath("//button[text()= 'Save']");
	public By RoleNameErrorMsg= By.xpath("//p[.= 'Enter Role Name']");
	public By CancelRole= By.xpath("//button[text()= 'Cancel']");
	public By RoleName= By.xpath("//input[@name= 'RoleName']");
	public By RoleNameSuccessMsg = By.xpath("//p[.= 'Record Saved Successfully']");
	public By AddedRoleName = By.xpath("//span[@title='Role5']");
	public By ActionColumn= By.xpath("(//span[@class='rz-column-title']) [2]");
	public By ThreedotButton= By.xpath("(//button[@class='btn btn-light morebtn']) [1]");
	public By EditBtn= By.xpath("(//button[@class='dropdown-item']) [1]");
	public By DispositionCheckbox= By.xpath("(//input[@type= 'checkbox']) [5]");
	public By UpdateRoleSuccessMsg = By.xpath("//p[.= 'Record Updated Successfully']");
	public By NoRecordsMsg = By.xpath("//span[text()= 'No records to display.']");
	public By closeIcon = By.xpath("//span[@class= 'rzi rzi-times']");
	public By tableColumn = By.xpath("//span[@title= 'Gordon']");
	public By waitSpinner = By.xpath("(//div[@class='spinner']) [1]");
	public By NextBtn = By.xpath("//li/span[text()='Next']");
	public By CloseBtn = By.xpath("//span[@class='rzi rzi-times']");

	
	
	
	
	

}
