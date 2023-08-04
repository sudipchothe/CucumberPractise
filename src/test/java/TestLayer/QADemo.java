package TestLayer;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import UtilsLayer.utilsDemo;

public class QADemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/automation-practice-form");
		
		List<WebElement> Gender = driver.findElements(By.xpath("//input[@name='gender']"));	
		
		for(WebElement a : Gender) {
			
		if(a.getText().equalsIgnoreCase("Male")){
				
				a.click();
			}
		else if(a.getText().equalsIgnoreCase("female")) {
			a.click();
		}
		else {
			a.click();
		}
		}
	}

}
