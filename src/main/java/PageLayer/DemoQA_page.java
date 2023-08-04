package PageLayer;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClassDemo;
import UtilsLayer.utilsDemo;

public class DemoQA_page extends BaseClassDemo{

	

@FindBy(xpath="//input[@id='firstName']")
private WebElement firstName ;

@FindBy(xpath="//input[@id='lastName']")
private WebElement lastName ;

@FindBy(xpath="//input[@id='userEmail']")
private WebElement userEmail;

@FindBy(xpath="//input[@name='gender']")
private List <WebElement> Gender;

@FindBy(xpath="//input[@id='userNumber']")
private WebElement  mob;

@FindBy(xpath="//input[@id='dateOfBirthInput']")
private WebElement DOB ;

@FindBy(xpath="//div[@id='subjectsContainer']")
private WebElement subjects ;

@FindBy(xpath="//input[@id='hobbies-checkbox-1']")
private WebElement hobbySport ;

@FindBy(xpath="//input[@id='hobbies-checkbox-2']")
private WebElement hobbyReading ;

@FindBy(xpath="//input[@id='hobbies-checkbox-3']")
private WebElement hobbyMusic ;

@FindBy(xpath="(//div[@class='col-md-9 col-sm-12'])[8]")
private WebElement currentAdd ;

public DemoQA_page(){

	PageFactory.initElements(driver, this);

}

public void demoQA(String fname, String lname, String email,String Mob, String add, String gender){

	utilsDemo.sendKeys(firstName,fname);
	utilsDemo.sendKeys(lastName,lname);
	utilsDemo.sendKeys(userEmail,email);
	utilsDemo.sendKeys(mob,Mob);
//	utilsDemo.sendKeys(subjects,sub);
	utilsDemo.sendKeys(currentAdd,add);
	
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
}}		

