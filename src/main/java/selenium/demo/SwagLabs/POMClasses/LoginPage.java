package selenium.demo.SwagLabs.POMClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;

	private WebElement txtUsername;
	private WebElement txtPassword;
	private WebElement btnLogin;

	public LoginPage(WebDriver driver) {
		this.driver = driver;

		txtUsername = driver.findElement(By.xpath("//input[@id=\"user-name\"]"));
		txtPassword = driver.findElement(By.cssSelector("input[id=\"password\"]"));
		btnLogin = driver.findElement(By.xpath("//input[@id=\"login-button\"]"));

	}

	public void setUsername(String s) {
		txtUsername.sendKeys(s);
	}

	public void setPassword(String t) {
		txtPassword.sendKeys(t);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public String getURL() {
		return driver.getCurrentUrl();
	}
}
