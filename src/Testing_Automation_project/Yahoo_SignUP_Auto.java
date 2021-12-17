package Testing_Automation_project;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.TestUtil;

public class Yahoo_SignUP_Auto {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Latest Eclipse\\Selenium 4.0\\Driver's\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get("https://login.yahoo.com/account/create?.intl=in&.lang=en-IN&src=search&activity=header-signin&pspid=2114723002&.done=https%3A%2F%2Fin.search.yahoo.com%2F%3Ffr2%3Dinr&specId=yidReg&done=https%3A%2F%2Fin.search.yahoo.com%2F%3Ffr2%3Dinr");
		
	}
	
	
	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testdata = TestUtil.getDataFromExcel();		
		return testdata.iterator();
	}
	
	
	@Test(dataProvider ="getTestData")
	public void yahooCreateAccountTest(String firstName, String surName, String emailAddress, String passWord, String mobileNum,
			String birthMonth, String birthDate, String birthYear, String genDer) throws InterruptedException {
			
		driver.findElement(By.xpath("//input[@id = 'usernamereg-firstName']")).clear();
		driver.findElement(By.xpath("//input[@id = 'usernamereg-firstName']")).sendKeys(firstName);
		
		driver.findElement(By.xpath("//input[@id = 'usernamereg-lastName']")).clear();
		driver.findElement(By.xpath("//input[@id = 'usernamereg-lastName']")).sendKeys(surName);
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id = 'usernamereg-yid']")).clear();
		driver.findElement(By.xpath("//input[@id = 'usernamereg-yid']")).sendKeys(emailAddress);
		
		driver.findElement(By.xpath("//input[@id = 'usernamereg-password']")).clear();
		driver.findElement(By.xpath("//input[@id = 'usernamereg-password']")).sendKeys(passWord);
		
		driver.findElement(By.xpath("//input[@id = 'usernamereg-phone']")).clear();
		driver.findElement(By.xpath("//input[@id = 'usernamereg-phone']")).sendKeys(mobileNum);

		Select select = new Select(driver.findElement(By.xpath("//select[@id = 'usernamereg-month']")));
		select.selectByVisibleText(birthMonth);
		
		Thread.sleep(2000);
				
		driver.findElement(By.xpath("//input[@id = 'usernamereg-day']")).clear();
		driver.findElement(By.xpath("//input[@id = 'usernamereg-day']")).sendKeys(birthDate);
	
		driver.findElement(By.xpath("//input[@id = 'usernamereg-year']")).clear();
		driver.findElement(By.xpath("//input[@id = 'usernamereg-year']")).sendKeys(birthYear);
		
		driver.findElement(By.xpath("//input[@name ='freeformGender']")).sendKeys(genDer);
		Thread.sleep(3000);

		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
