package BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.Pom.LoginPom;
import com.crm.Pom.LogoutRepo;
import com.crm.javautility.CommonData;



public class BaseVtigerF {
	

	
public static WebDriver driver;

CommonData commonData=new CommonData();
	
	
	
	@BeforeClass
	 public static void preCondition(String browser) throws InterruptedException 
	  {
		browser=prop.getProperty("browser");
		  if(browser.equalsIgnoreCase("chrome"))
		  {
			  driver= new ChromeDriver();
		  }
		  else if (browser.equalsIgnoreCase("edge") )
		 {
			  driver= new EdgeDriver();
		}
		  else if (browser.equalsIgnoreCase("firefox") )
			 {
				  driver= new FirefoxDriver();
			}
		  else 
		  {
			  driver=new ChromeDriver();
		  }
		  
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		  driver.get(prop.getProperty("url"));
	  }
	
	@BeforeMethod
	public void login() {
		LoginPom loginpom = new Login
		
		
		
	}
	
	@AfterMethod
	public static void logout()
	{
		LogoutRepo lr = new LogoutRepo();
		login.logout icon().click();
		login.logout().click();
	}

	@AfterClass
	public static void postCondition()
	{
		driver.quit();
	}
	
	@AfterSuite
	public void  afterSuite()
	{
		System.out.println("AfterSuite");
	}
	
	

}
