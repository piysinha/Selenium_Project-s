package com.datadriven.test;

import com.excel.utility.Xls_Reader;

public class ExcelOperations {

	public static void main(String[] args) {

		Xls_Reader reader = new Xls_Reader("C:\\Eclipse latest project files\\Selenium_Project\\src\\com\\testdata\\EbayTestData.xlsx");
		
		if(!reader.isSheetExist("HomePage")) {
		reader.addSheet("HomePage");
		}
		
		int colCount = reader.getColumnCount("RegTestData");
		System.out.println("Total coloums present in :" + colCount);
		
		int cellValue = reader.getCellRowNum("RegTestData", "firstname", "Tom");
		System.out.println("The row number for tom is : "+cellValue);
	}

}
