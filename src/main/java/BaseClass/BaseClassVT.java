package BaseClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.Pom.LoginPom;
import com.crm.javautility.CommonData;

public class BaseClassVT {
	
public static WebDriver driver;
	
	CommonData commonData=new CommonData();
	
	@BeforeClass
	public void preCondition() throws InterruptedException, IOException {
		
		String browser=commonData.data("browser");
		String url=commonData.data("url");
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else if (browser.equalsIgnoreCase("fireFox")) {
			driver=new FirefoxDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(url);
		
	}
	
	@BeforeMethod
	public void login() throws IOException {
		String username=commonData.data("username");
		String password=commonData.data("password");
		LoginPom loginPage=new LoginPom();
		loginPage.login(username, password);
	}
	
	@AfterMethod
	public void logout() throws InterruptedException {
		
		HomePagePOM homepage=new HomePagePOM();
		Thread.sleep(2000);
		homepage.logout();
		Thread.sleep(2000);
	}
	

}
