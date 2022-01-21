package selenium.demo.SwagLabs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import selenium.demo.SwagLabs.POMClasses.HomePage;
import selenium.demo.SwagLabs.POMClasses.LoginPage;

public class LoginTest {
	WebDriver driver;
	@BeforeSuite

	public void loginCheck() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\ReshmaAutomation\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);		
	}
	
	
	@DataProvider(name="Data-provider")
	public Object[][] dpmethod(){
		return new Object[][] {{"standard_user","secret_sauce"},{"locked_out_user","secret_sauce"}};
		
	}
	
	@Test(dataProvider="Data-provider")
	
	public void loginValidate(String username,String password) throws InterruptedException {
		LoginPage objLogin=new LoginPage(driver);
		objLogin.SetUsername(username);
		objLogin.SetPassword(password);
		objLogin.ClickLogin();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
		
		HomePage objhome=new HomePage(driver);
		objhome.setDropDown("lohi");
		objhome.clickLogout();
		
		
	}
	
	
	
	
}
