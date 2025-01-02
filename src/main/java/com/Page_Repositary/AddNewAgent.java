package com.Page_Repositary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.base.Function;

public class AddNewAgent
{
	public static By AgentManagement= By.xpath("(//span[@class='text nav-text']) [3]");
	public By AgentlistSubMenu= By.xpath("(//a[@class='dropdown-item']) [4]");
	public By UserManagementMenu= By.xpath("//label[contains(.,'Agent Code')]/following-sibling::input");
	public By Username= By.xpath("//label[contains(.,'User Name')]/following-sibling::input");
	public By AgentName= By.xpath("//label[contains(.,'Agent Name')]/following-sibling::input");
	public By MobileNumber= By.xpath("//label[contains(.,'Mobile Number')]/following-sibling::input");
	public By Role = By.xpath("//div[@class='rz-helper-hidden-accessible']/following-sibling::label");
	public By IsActive= By.xpath("//label[text()='Is Active']");
	public By NextBtn= By.xpath("(//span[@class='page-link']) [2]");
	public By waitSpinner= By.xpath("(//div[@class='spinner']) [1]");
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}