package com.technocredits.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataOperation {
	
	private static int getTotalRows(Sheet sheet)
	{
		return sheet.getLastRowNum()+1;
	}
	
	static private int getTotalCol(Sheet sheet)
	{
		return sheet.getRow(sheet.getFirstRowNum()).getLastCellNum();
	}
	
	static private String getCellData(Sheet sheet, int row, int col)
	{
		return sheet.getRow(row).getCell(col).getStringCellValue();
	}
	
	public static String[][] getData(String filePath, String sheetName) throws IOException
	{
		File file = new File(filePath);
		FileInputStream input = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(input);
		
		Sheet sheet = wb.getSheet(sheetName);
		//int totalRows = getTotalRows(sheet);
		int totalRows = sheet.getLastRowNum()+1;
		int totalCol = sheet.getRow(sheet.getFirstRowNum()).getLastCellNum();
		//int totalCol = getTotalCol(sheet);
		String[][] data = new String[totalRows][totalCol];
		
		for(int i=0; i<totalRows;i++)
		{
			for(int j=0;j<totalCol;j++)
			{
				data[i][j] = getCellData(sheet, i, j);
			}
		}
		return data;
		
		
	}
}
