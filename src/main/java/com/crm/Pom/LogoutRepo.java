package com.crm.Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutRepo {
	public void LoginRepo(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "user_name")
	WebElement username ;
	
	@FindBy(name = "user_password")
	WebElement password ;
	
	@FindBy(id = "submitButton")
	WebElement login_button ;
	
	public void login() throws IOException 
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("./src/test/resources/config.properties");
		prop.load(fis);
		String un = prop.getProperty("username");
		String pswd = prop.getProperty("password");
		
		username.sendKeys(un);
		password.sendKeys(pswd);
		login_button.click();
	}


}
