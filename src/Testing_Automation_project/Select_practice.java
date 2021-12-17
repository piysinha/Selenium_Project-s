package Testing_Automation_project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Select_practice {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Latest Eclipse\\Selenium 4.0\\Driver's\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/reg/");
		
		WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));
		
//		Select selectDay = new Select(day);
//		selectDay.selectByVisibleText("21");
//		
//		Select selectMonth = new Select(month);
//		selectMonth.selectByVisibleText("Apr");
//
//		Select selectYear = new Select(year);
//		selectYear.selectByVisibleText("1995");
		
		String dob = "21-Apr-1995";
		String dobArr[] = dob.split("-");
		
		selectValueFromDropDown(day, dobArr[0]);
		selectValueFromDropDown(month, dobArr[1]);
		selectValueFromDropDown(year, dobArr[2]);
		
		Thread.sleep(5000);
		
		driver.quit();
		
		
	}

	public static void selectValueFromDropDown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
		
	}
	
	
	
}
