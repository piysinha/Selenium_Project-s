package Testing_Automation_project;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Select_Calender_byJS {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Latest Eclipse\\Selenium 4.0\\Driver's\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
		driver.get("https://www.redbus.in/");		
		
//		driver.findElement(By.xpath("//a[contains(text(),'Bank Project')]")).click();
//		driver.findElement(By.name("uid")).sendKeys("mngr372085");
//		driver.findElement(By.name("password")).sendKeys("ararYtu");
//		driver.findElement(By.name("btnLogin")).click();
//		
//		driver.findElement(By.xpath("//a[contains(text(),'New Customer')]")).click();
		
		
		
//		new WebDriverWait(driver, Duration.ofSeconds(5))
//		.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ui-datepicker-calendar")));
//		
//		String monthYearValue = driver.findElement(By.className("ui-datepicker-title")).getText();
//		
//		System.out.println(monthYearValue);
		
//		WebElement date = driver.findElement(By.id("dob"));
//		String dateVal = "21-04-1995";
//		
//		selectDateByJS(driver, date, dateVal);
		
		driver.findElement(By.id("onward_cal")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//table[@class='rb-monthTable first last']/child::tbody/child::tr[4]/child::td[5]")).click();
		
		List<WebElement> dates = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//td"));
		
		int total_node = dates.size();
		
		for(int i=0;i<total_node;i++) {
			String date = dates.get(i).getText();
			
			if(date.equals("22"))
			{
				dates.get(i).click();
				break;
			}
		}
		
	}
	
	public static void selectDateByJS(WebDriver driver, WebElement element, String dateVal) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("argument[0].setAttribute('value','"+dateVal+"');", element);
		
		
	}
	
}
