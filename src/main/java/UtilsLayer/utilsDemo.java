package UtilsLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import BaseLayer.BaseClassDemo;

public class utilsDemo extends BaseClassDemo{

public static void sendKeys(WebElement wb, String value){

	if(wb.isDisplayed() && wb.isEnabled()){

		wb.sendKeys(value);
	}		

}



public static void HandleDP(WebElement wb, String DPvalue){

	new Select(wb).selectByVisibleText(DPvalue);
	
}

public static void optionSelect(WebElement wb1, WebElement wb2, WebElement wb3){

	if(wb1.isSelected()){

		wb1.click();
	}
	else if(wb2.isSelected()){
		
		wb2.click();
	}
	else{
		wb3.isSelected();
	}
}

}