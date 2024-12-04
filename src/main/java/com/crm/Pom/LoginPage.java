package com.crm.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//input[@name='user_name']")
	private  WebElement username;
	
	@FindBy(xpath = "//input[@name='user_password']")
	private  WebElement password;
	
	@FindBy(id = "submitButton")
	private  WebElement submitbtn;

	public void login(String username, String pwd) {
		this.username.sendKeys(username);
		this.password.sendKeys(pwd);
		submitbtn.click();
	}

}
