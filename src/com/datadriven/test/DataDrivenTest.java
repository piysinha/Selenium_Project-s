package com.datadriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class DataDrivenTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Latest Eclipse\\Selenium 4.0\\Driver's\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		driver.get("https://signup.ebay.com/pa/crte?ru=https%3A%2F%2Fwww.ebay.com%2F");
		
		Xls_Reader reader = new Xls_Reader("C:\\Eclipse latest project files\\Selenium_Project\\src\\com\\testdata\\EbayTestData.xlsx");
		
		String firstName = reader.getCellData("RegTestData", "firstname", 2);
		System.out.println(firstName);
		
		String lastName = reader.getCellData("RegTestData", "lastname", 2);
		System.out.println(lastName);

		String Email = reader.getCellData("RegTestData", "email", 2);
		System.out.println(Email);

		String passWord = reader.getCellData("RegTestData", "password", 2);
		System.out.println(passWord);

		driver.findElement(By.id("firstname")).sendKeys(firstName);
		driver.findElement(By.id("lastname")).sendKeys(lastName);
		driver.findElement(By.id("Email")).sendKeys(Email);
		driver.findElement(By.id("password")).sendKeys(passWord);
		
		
	}

}
