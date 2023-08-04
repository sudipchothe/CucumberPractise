package BaseLayer;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClassDemo {
	

	public static WebDriver driver;
	public static void initialization(){

		driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/automation-practice-form");
	}
}

//"https://demo.guru99.com/test/newtours/register.php"