package Testing_Automation_project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest_NG {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Latest Eclipse\\Selenium 4.0\\Driver's\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("Https://google.com");
	}
		
	@Test(priority = 1, groups = "Title test")
	public void googleTitleTest() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	
	
	@Test(priority = 2, groups = "Logo Test")
	public void googleLogoTest() {
		boolean b = driver.findElement(By.xpath("//img[@class = 'lnXdpd']")).isDisplayed();
		System.out.println(b);
	}
		
	@Test(priority = 2, groups = "Link Test")
	public void mailLinkTest() {
		boolean b = driver.findElement(By.linkText("Gmail")).isDisplayed();
		System.out.println(b);
	}
	
	@Test(priority = 4, groups = "Testing")
	public void test1() {
		System.out.println("Test1");
	}

	@Test(priority = 5,groups="Testing")
	public void test2() {
		System.out.println("Test2");
	}
	
	@Test(priority = 6, groups = "Testing")
	public void test3() {
		System.out.println("Test3");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
				
}

