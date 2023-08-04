package TestLayer;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseLayer.BaseClassDemo;
import PageLayer.DemoQA_page;

public class DemoQA_Test extends BaseClassDemo{


	@BeforeClass
	public void setUp(){
		System.out.println("TC stared");
		BaseClassDemo.initialization();
	}
	
	@Test
	public void LoginPage(){

		DemoQA_page obj = new DemoQA_page();
		obj.demoQA("AAAA", "BBBBB", "abc@gmail.com","male" ,"9898989",  "Sangli");

	}
	
	@AfterClass
	public void tearDown(){

	System.out.println("TC ended");

	}}
