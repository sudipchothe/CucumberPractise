package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;
import UtilsLayer.ExcelReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Facebook_Login_Steps extends BaseClass{
	protected static  WebDriver driver;
 @BeforeClass
	public void preCondition() {
		System.out.println("TC started");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/login");
		System.out.println();

	}
	
	


	@Test(dataProvider="Login")
	@When("configure {string} & {string} with DataProvider concept")
	public void configure_with_data_provider_concept(String user, String pass) throws InterruptedException {
		
		driver.findElement(By.id("email")).sendKeys(user);
		driver.findElement(By.id("pass")).sendKeys(pass);
		
		
	}
	
	@DataProvider(name="Login")
	public Object [] [] getData() throws InterruptedException{
		ExcelReader excel = new ExcelReader("C:\\Users\\Adm\\eclipse-workspace\\CucumberPractise\\src\\main\\java\\ConfigLayer\\TestNG.xlsx");
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
	
	@Then("refresh page")
	public void refresh_page() throws InterruptedException {
		
		System.out.println("TC ended.");
	}
	


}
