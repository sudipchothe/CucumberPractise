package TestLayer;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseLayer.BaseClassDemo;
import PageLayer.GuruPage;

public class GuruTest extends BaseClassDemo {

	@BeforeClass
	public void setUp() {
		
		BaseClassDemo.initialization();
		
	}
	@Test
	public void guruTest() throws InterruptedException{

		GuruPage obj = new GuruPage();
		obj.LoginPage("AAAA", "BBBB", "999999", "abc@gmail.com", "Sangli", "Vita", "Maharashtra", "411019", "INDIA", "ABCD", "121212", "121212");
		Thread.sleep(5000);
		driver.navigate().refresh();
	}
	
	@AfterClass
	public void tearDown() {
		System.out.println("TC ended");
	}
}