package DataDrivenExcel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Lib\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demosite.center/wordpress/wp-login.php");
		
		driver.manage().window().maximize();
		driver.findElement(By.id("user_login")).sendKeys(username);
		driver.findElement(By.id("user_pass")).sendKeys(password);
		driver.findElement(By.name("wp-submit")).click();
	}
	
	@DataProvider(name = "loginData")
	public Object[][] getData() throws IOException
	{
		FileInputStream fis = new FileInputStream("Data/ExcelDemo.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet1 = wb.getSheet("Sheet1");
		
		int rowsCount = sheet1.getPhysicalNumberOfRows();
		
		Object[][] data = new Object[rowsCount][2];
		
		for (int i = 0; i < rowsCount; i++) 
		{
			XSSFRow row = sheet1.getRow(i);
			
			XSSFCell username = row.getCell(0);
			data[i][0] = username.getStringCellValue();
			
			XSSFCell password = row.getCell(1);
			data[i][1] = password.getStringCellValue();
		}
		
		return data;
	}
}
