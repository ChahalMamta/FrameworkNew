package com.automation.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;

	public ExcelDataProvider() {
		File src = new File("./TestData/Data.xslx");

		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
           System.out.println("Unable to read excel file"+e.getMessage());
		}
	}
	
	public String getStringData(int shIndex, int shRow, int shColumn) {
		return wb.getSheetAt(shIndex).getRow(shRow).getCell(shColumn).getStringCellValue();
	}
	
	public String getStringData(String shName, int shRow, int shColumn) {
		return wb.getSheet(shName).getRow(shRow).getCell(shColumn).getStringCellValue();
	}
	
	public double getNumericData(String shName, int shRow, int shColumn) {
		return wb.getSheet(shName).getRow(shRow).getCell(shColumn).getNumericCellValue();
		
	}
}
