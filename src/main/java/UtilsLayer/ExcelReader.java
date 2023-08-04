package UtilsLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public XSSFWorkbook workbook;

	public ExcelReader(String filePath) {
		File f = new File(filePath);
		System.out.println(f.exists());
			try {
				FileInputStream fis = new FileInputStream(f);
				workbook = new XSSFWorkbook(fis);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		
	}
	
	public int countRows(int sheetIndex) {
		return workbook.getSheetAt(sheetIndex).getLastRowNum()+1;
	}

	public int countCells(int sheetIndex) {
		return workbook.getSheetAt(sheetIndex).getRow(0).getLastCellNum();
	}

	public String getValue(int sheetIndex, int rows, int cells) {

		try {
			return workbook.getSheetAt(sheetIndex).getRow(rows).getCell(cells).getStringCellValue();
		} catch (Exception e) {
			double d = workbook.getSheetAt(sheetIndex).getRow(rows).getCell(cells).getNumericCellValue();
			return Long.toString((long) d);
		}
	}

	

}
