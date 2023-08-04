package TestLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import UtilsLayer.ExcelReader;

public class FacebookLoginDataDriven {
	WebDriver driver;
	@BeforeClass
	public void preCondition() {
		
		 driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
	}
	
	@AfterMethod
	public void postCondition() {
		driver.navigate().refresh();
	}
	
	@Test(dataProvider="Login")
	public void m1(String user, String pass) throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(user);;
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(pass);
		Thread.sleep(2000);
	}
	
	@DataProvider(name="Login")
	public Object [] [] testData(){
		
		ExcelReader excel = new ExcelReader("C:\\\\Users\\\\Adm\\\\eclipse-workspace\\\\CucumberPractise\\\\src\\\\main\\\\java\\\\ConfigLayer\\\\TestNG.xlsx");
		int row = excel.countRows(0);
		int cell = excel.countCells(0);
		Object [] [] data = new Object [row] [cell];
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<cell; j++) {
				data[i] [j] = excel.getValue(0, i, j);
			}
		}
		
		return data;
	}
}

















