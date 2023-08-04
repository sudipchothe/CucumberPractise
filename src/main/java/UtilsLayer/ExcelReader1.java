package UtilsLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BaseLayer.BaseClass;

public class ExcelReader1 extends BaseClass{
	XSSFWorkbook workbook ;
	public ExcelReader1(String filePath) throws IOException{

		File f = new File("filePath");
		System.out.println(f.exists());

		FileInputStream fis = new FileInputStream(f);
		 workbook = new XSSFWorkbook(fis);

	}

	public int countRows(int sheetIndex){


		return workbook.getSheetAt(sheetIndex).getLastRowNum()+1;
	}

	public int countCell(int sheetIndex){


		return workbook.getSheetAt(sheetIndex).getRow(0).getLastCellNum();
	}

	public String getValue(int sheetIndex, int row, int cell){


		return workbook.getSheetAt(sheetIndex).getRow(row).getCell(cell).getStringCellValue();
	}

}