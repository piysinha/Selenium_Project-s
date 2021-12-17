package com.datadriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class ParameterizeTest {

	public static void main(String[] args) {

		Xls_Reader reader = new Xls_Reader("C:\\Eclipse latest project files\\Selenium_Project\\src\\com\\testdata\\EbayTestData.xlsx");

		int rowCount = reader.getRowCount("RegTestData");

		System.setProperty("webdriver.chrome.driver","D:\\Latest Eclipse\\Selenium 4.0\\Driver's\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		driver.get("https://signup.ebay.com/pa/crte?ru=https%3A%2F%2Fwww.ebay.com%2F");

		reader.addColumn("RegTestData", "Status");

		//	System.out.println(rowCount);
		for(int rowNum=2; rowNum<=rowCount; rowNum++) {
			System.out.println("========");
			String firstName = reader.getCellData("RegTestData", "firstname", rowNum); 
			System.out.println(firstName);

			String lastName = reader.getCellData("RegTestData", "lastname", rowNum);
			System.out.println(lastName);

			String Email = reader.getCellData("RegTestData", "email", rowNum);
			System.out.println(Email);

			String passWord = reader.getCellData("RegTestData", "password", rowNum);
			System.out.println(passWord);


			driver.findElement(By.id("firstname")).clear();
			driver.findElement(By.id("firstname")).sendKeys(firstName);

			driver.findElement(By.id("lastname")).clear();
			driver.findElement(By.id("lastname")).sendKeys(lastName);

			driver.findElement(By.id("Email")).clear();
			driver.findElement(By.id("Email")).sendKeys(Email);

			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys(passWord);

		//	reader.setCellData("RegTestData", "Status", rowNum, "Pass");
				
		}


	}

}
