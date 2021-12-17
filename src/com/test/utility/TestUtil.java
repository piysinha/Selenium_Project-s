package com.test.utility;

import java.util.ArrayList;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.excel.utility.Xls_Reader;

public class TestUtil {
	
	WebDriver driver;
	
	static Xls_Reader reader;

	public static ArrayList<Object[]> getDataFromExcel() {
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try{
		reader = new Xls_Reader("C:\\Eclipse latest project files\\Selenium_Project\\src\\com\\testdata\\YahooCreateAccount.xlsx");	
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		for(int rowNum=2; rowNum<=reader.getRowCount("SignUpDetails"); rowNum++) {
			//System.out.println("========");
			String firstName = reader.getCellData("SignUpDetails", "firstName", rowNum); 
			String surName = reader.getCellData("SignUpDetails", "surName", rowNum);
			String emailAddress = reader.getCellData("SignUpDetails", "emailAddress", rowNum);
			String passWord = reader.getCellData("SignUpDetails", "passWord", rowNum);
			String mobileNum = reader.getCellData("SignUpDetails", "mobileNum", rowNum);
			String birthMonth = reader.getCellData("SignUpDetails", "birthMonth", rowNum);
			String birthDate = reader.getCellData("SignUpDetails", "birthDate", rowNum);
			String birthYear = reader.getCellData("SignUpDetails", "birthYear", rowNum);
			String genDer = reader.getCellData("SignUpDetails", "genDer", rowNum);
			
			
			Object ob[] = {firstName, surName, emailAddress, passWord, mobileNum, birthMonth, birthDate, birthYear, genDer};
			
			myData.add(ob);
		}
	
		return myData;
	}
	
	String text ="Female";
	String text1 = "Male";
	
	WebElement el = driver.findElement(By.xpath("//div[@id ='gender-container']/descendant::li[text()='"+text+"']"));
	
}
