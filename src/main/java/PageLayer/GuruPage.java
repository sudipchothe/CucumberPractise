package PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClassDemo;
import UtilsLayer.utilsDemo;

public class GuruPage extends BaseClassDemo {


	@FindBy(xpath="//input[@name='firstName']")
	private WebElement fname;

	@FindBy(xpath="//input[@name='lastName']")
	private WebElement lname;

	@FindBy(xpath="//input[@name='phone']")
	private WebElement phoneNo;

	@FindBy(xpath="//input[@name='userName']")
	private WebElement email;

	@FindBy(xpath="//input[@name='address1']")
	private WebElement addr;

	@FindBy(xpath="//input[@name='city']")
	private WebElement city;

	@FindBy(xpath="//input[@name='state']")
	private WebElement state;

	@FindBy(xpath="//input[@name='postalCode']")
	private WebElement pinCode;

	@FindBy(xpath="//select[@name='country']")
	private WebElement countryDP;

	@FindBy(xpath="//input[@name='email']")
	private WebElement username;

	@FindBy(xpath="//input[@name='password']")
	private WebElement password;

	@FindBy(xpath="//input[@name='confirmPassword']")
	private WebElement confirmPassword;

	@FindBy(xpath="//input[@name='submit']")
	private WebElement submitBtn;


	public GuruPage(){

		PageFactory.initElements(driver,this);
	}

	public void LoginPage (String Fname, String Lname, String PhoneNo, String Email, String Addr, String City, String State, String PinCode, String CountryDP, String Username, String Password, String ConfirmPassword){


		utilsDemo.sendKeys(fname,Fname);
		utilsDemo.sendKeys(lname,Lname);
		utilsDemo.sendKeys(phoneNo, PhoneNo);
		utilsDemo.sendKeys(email, Email);
		utilsDemo.sendKeys(addr,Addr);
		utilsDemo.sendKeys(city,City);
		utilsDemo.sendKeys(state,State);
		utilsDemo.sendKeys(pinCode, PinCode);
		utilsDemo.HandleDP(countryDP,CountryDP );

		utilsDemo.sendKeys(username,Username);
		utilsDemo.sendKeys(password,Password);
		utilsDemo.sendKeys(confirmPassword, ConfirmPassword);
		
	}

}
