package TestLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BaseLayer.BaseClass;

public class ExcelReeder extends BaseClass{
	XSSFWorkbook workbook;
	XSSFSheet sheets;
	
	public ExcelReeder(String path) throws IOException {
		
		File f = new File(path);
		System.out.println(f.exists());
		
		FileInputStream fis = new FileInputStream(f);
		 workbook = new XSSFWorkbook(fis);
		
	}
	
	public int  countRow(int sheetIndex) {
		
		return workbook.getSheetAt(sheetIndex).getLastRowNum();
		
	}
	
	public int countColumn(int sheetIndex) {
		
		return workbook.getSheetAt(sheetIndex).getRow(0).getLastCellNum();
		
	}
	public String getValue(int sheetIndex, int rowNum, int cellNum) {
		
		return workbook.getSheetAt(sheetIndex).getRow(rowNum).getCell(cellNum).getStringCellValue();
	}
}










