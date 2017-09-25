package com.test.automation.uiAutomation.excelReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelread {
	
	public FileInputStream file = null;
	public String path ;
	public FileOutputStream fileout = null;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	

public Excelread(String path){
	
	this.path = path;
	
	try {
		file = new FileInputStream(path);
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

public String[][] excel_reader(String sheetname, String Excelname) throws IOException{
	
	workbook = new XSSFWorkbook(file);
	sheet = workbook.getSheet(sheetname);
	
	String[][] dataset = null;
	
	int totalrow = sheet.getLastRowNum();
	int totalcol = sheet.getRow(0).getLastCellNum();
	
	dataset = new String[totalrow][totalcol];
	
	for(int i = 1; i<=sheet.getLastRowNum();i++){
		
		row = sheet.getRow(i);
		
		
	for (int j =0; j<row.getLastCellNum();j++){
	
		cell = row.getCell(j);
		
		dataset[i-1][j]= cell.getStringCellValue();
	}
	
		
		
	}
	
	return dataset;
	
}


}

