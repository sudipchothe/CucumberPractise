package TestLayer;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import UtilsLayer.ExcelReader;

public class DataDriven {
	
	@Test(dataProvider="Login")
	public void m1(String user , String pass) {
	
		System.out.println(user+"----"+pass);
	}
	
	@DataProvider(name="Login")
	public Object [] [] testData(){
		
		ExcelReader excel =new ExcelReader("C:\\Users\\Adm\\eclipse-workspace\\CucumberPractise\\src\\main\\java\\ConfigLayer\\TestNG.xlsx");
		int row = excel.countRows(0);
		int cell =excel.countCells(0);
		System.out.println("RowCount = "+ row);
		System.out.println("CellCount = "+ cell);
		Object [][] data = new Object [row] [cell];
		
		for(int i=0;i<row; i++) {
			for(int j=0; j<cell; j++) {
				
				data [i] [j] = excel.getValue(0, i, j);
			}
		}
		return data;
	}
}
