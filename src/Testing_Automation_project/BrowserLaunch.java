package Testing_Automation_project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserLaunch {

	static WebDriver driver;
	
	public static void main(String[] args) {

//		System.setProperty("webdriver.chrome.driver", "D:\\Latest Eclipse\\Selenium 4.0\\Driver's\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("Https://google.com");
//		String a = driver.getTitle();
//		driver.quit();
//		System.out.println(a);

//		System.setProperty("webdriver.gecko.driver", "D:\\Latest Eclipse\\Selenium 4.0\\Driver's\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
//		driver.manage().window().maximize();
//		driver.get("Https://google.com");
//		String b = driver.getTitle();
//		driver.quit();
//		System.out.println(b);
		
		System.setProperty("webdriver.chrome.driver", "D:\\Latest Eclipse\\Selenium 4.0\\Driver's\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get("https://login.yahoo.com/account/create?.intl=in&.lang=en-IN&src=search&activity=header-signin&pspid=2114723002&.done=https%3A%2F%2Fin.search.yahoo.com%2F%3Ffr2%3Dinr&specId=yidReg&done=https%3A%2F%2Fin.search.yahoo.com%2F%3Ffr2%3Dinr");
		
		driver.findElement(By.xpath("//input[@name ='freeformGender']")).sendKeys("Male");
		
	}

}
