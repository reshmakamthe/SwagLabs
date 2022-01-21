package selenium.demo.SwagLabs.POMClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

	WebDriver driver;

	private Select dropdownSelect;
	private WebElement btn;
    private WebElement btnlogout;
	

	public HomePage(WebDriver driver) {
		this.driver = driver;
		WebElement dropdown = driver.findElement(By.xpath("//select[@class=\"product_sort_container\"]"));
		dropdownSelect = new Select(dropdown);
		btn=driver.findElement(By.xpath("//button[@id=\"react-burger-menu-btn\"]"));
	}

	public void setDropDown(String s) {
		dropdownSelect.selectByValue(s);
		

	}

	
	public void clickLogout() throws InterruptedException {
		btn.click();
		Thread.sleep(5000);
		btnlogout = driver.findElement(By.xpath("//a[@id=\"logout_sidebar_link\"]"));
		btnlogout.click();
		Thread.sleep(5000);
		
	}
}