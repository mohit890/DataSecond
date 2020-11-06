package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Pages.LoginPage;

public class TestCase {
	
	@Test
	public void validUser() {
		
		System.setProperty("webdriver.chrome.driver","E:\\Browser_drivers\\Chrome_driver New\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demosite.center/wordpress/wp-login.php");
		
		driver.manage().window().maximize();
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		
		login.loginValidation("admin","demo123");
		
		
	}
	

}
