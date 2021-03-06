package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	@FindBy(id="user_login")
	WebElement username;
	
	@FindBy(id="user_pass")
	WebElement password;
	
	@FindBy(id="wp-submit")
	WebElement submit;
	
	public void loginValidation(String uid, String pass) {
		
		username.sendKeys(uid);
		password.sendKeys(pass);
		submit.click();
	}
}

