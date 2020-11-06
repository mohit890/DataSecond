package DataDivine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class comWordpress 
{
	@Test(dataProvider = "loginData")
	public void LoginWordpress(String username, String password)
	{
		System.setProperty("webdriver.chrome.driver","E:\\Browser_drivers\\Chrome_driver New\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demosite.center/wordpress/wp-login.php");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("user_login")).sendKeys(username);
		driver.findElement(By.id("user_pass")).sendKeys(password);
		driver.findElement(By.name("wp-submit")).click();
	}
	
	@DataProvider(name = "loginData")
	public Object[][] getData()
	{
		Object[][] data = new Object[3][2];
		
		data[0][0] = "admin1";
		data[0][1] = "demo123";
		
		data[1][0] = "admin";
		data[1][1] = "demo123";
		
		data[2][0] = "admin3";
		data[2][1] = "demo123";
		
		
		return data;
	}
}
