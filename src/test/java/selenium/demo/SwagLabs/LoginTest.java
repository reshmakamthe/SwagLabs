package selenium.demo.SwagLabs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import selenium.demo.SwagLabs.POMClasses.LoginPage;

public class LoginTest {
	
	
	LoginPage objLogin;
	
	@BeforeSuite
	public void login() {
		System.setProperty("webdriver.chrome.driver", "D:\\ReshmaAutomation\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get(Common.URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	    objLogin=new LoginPage(driver);
		
		
	}
	
	@DataProvider (name="data-provider")
	public Object[][] dpMethod(){
		return new Object[][] {{"standard_user","secret_sauce"},{"locked_out_user","secret_sauce"}};
	}
	
	@Test(dataProvider="data-provider")
	public void ValidateLogin(String username,String password) {
		objLogin.setUsername(username);
		objLogin.setPassword(password);
		objLogin.clickLogin();
		Assert.assertEquals(objLogin.getURL(), "https://www.saucedemo.com/inventory.html");
		
		
		
	}
	
	
}
