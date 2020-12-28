package com.mesf.utility;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.DataProvider;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelUtility {
	
	Workbook wb;
	Sheet sh;
	
	@DataProvider
	public String[][] getTableData(String path,String sheetName) throws Exception {
		String data[][] = null;
		FileInputStream fis = new FileInputStream(path);
		wb = Workbook.getWorkbook(fis);
		sh = wb.getSheet(sheetName);
		int row = sh.getRows();
		int col = sh.getColumns();
		data = new String[row][col];
		for (int i = 1; i < row; i++) {
			for (int j = 0; j < col; j++) {
				Cell cell = sh.getCell(j, i);
				data[i][j] = cell.getContents();
			}
		}
		return data;
	}
	
	public static List<String> excelData(String filePath,String sheetName) throws Exception {
		String data = null;
		
		List<String> expData = new ArrayList<String>();
		
		FileInputStream f=new FileInputStream(filePath);
		Workbook wb=Workbook.getWorkbook(f);
		Sheet sh = wb.getSheet(sheetName);
		int rows = sh.getRows();
		int cols = sh.getColumns();
		Cell cell = null;
		data=new String();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				 cell= sh.getCell(j, i);
				 data=cell.getContents();
				 expData.add(data);
				}
		}
		return expData;
		}
	
	public static String data(String filePath,String sheetName,int col,int row) throws Exception {
		String data = null;
		FileInputStream f=new FileInputStream(filePath);
		Workbook wb=Workbook.getWorkbook(f);
		Sheet sh = wb.getSheet(sheetName);
		data=sh.getCell(col, row).getContents();
		return data;
	}
	
	public static List<String> excelDataByRowNo(String filePath,String sheetName,int row) throws Exception {
		String data = null;
		List<String> expData = new ArrayList<String>();
		
		FileInputStream f=new FileInputStream(filePath);
		Workbook wb=Workbook.getWorkbook(f);
		Sheet sh = wb.getSheet(sheetName);
		//int rows = sh.getRows();
		int cols = sh.getColumns();
		Cell cell = null;
		data=new String();
	     for (int j = 0; j < cols; j++) {
				 cell= sh.getCell(j, row);
				 data=cell.getContents();
				 expData.add(data);
				 
				}
		return expData;
	}
	
	public static List<String> excelDataByColNo(String filePath,String sheetName,int col) throws Exception {
		String data = null;
		List<String> expData = new ArrayList<String>();
		FileInputStream f=new FileInputStream(filePath);
		Workbook wb=Workbook.getWorkbook(f);
		Sheet sh = wb.getSheet(sheetName);
		int rows = sh.getRows();
		//int cols = sh.getColumns();
		Cell cell = null;
		data=new String();
	     for (int j = 0; j < rows; j++) {
				 cell= sh.getCell( col,j);
				 data=cell.getContents();
				 expData.add(data);
				}
		return expData;
	}
}