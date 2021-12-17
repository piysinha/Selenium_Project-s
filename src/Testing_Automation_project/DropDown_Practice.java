package Testing_Automation_project;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown_Practice {

	static WebDriver driver;
	
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Latest Eclipse\\Selenium 4.0\\Driver's\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/reg/");
		
//		driver.findElement(By.xpath("//a[contains(text(),'Bank Project')]")).click();
//		driver.findElement(By.name("uid")).sendKeys("mngr374778");
//		driver.findElement(By.name("password")).sendKeys("azAsEge");
//		driver.findElement(By.name("btnLogin")).click();
//		driver.findElement(By.xpath("//a[contains(text(),'New Customer')]")).click();
		

		WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));
		
		
		// selecting the drop down by using the select class
//		Select select = new Select(day);
//		//selecting the element through index
//		select.selectByIndex(5);
//		// check weather the dropdown is a multiple select option or not.
//		System.out.println(select.isMultiple());
//		// through the list we will get to know all the element present in the drop down
//		List<WebElement> listDays = select.getOptions();
//		//Through the list we will be able to print the size of the dropdown list
//		System.out.println(listDays.size());
		
//		Select select = new Select(driver.findElement(By.id("dob")));
//		
//		select.selectByVisibleText(Dob);
//		
//		System.out.println(select.isMultiple());
		
//		for(int i=0;i<listDays.size();i++) {
//			String dayVal = listDays.get(i).getText();
//			System.out.println(dayVal);
//			if(dayVal.equals("31")) {
//				listDays.get(i).click();
//				break;
//			}
			
//		}
	
		// selecting the drop down without using the select option
//		List<WebElement> yearList = driver.findElements(By.xpath("//select[@id='year']//option"));
//		System.out.println(yearList.size());
		
//		List<WebElement> dayList = driver.findElements(By.xpath("//select[@id='day']//option"));
//		System.out.println(dayList.size());
		
		String yearXpath = "//select[@id='year']//option";
		String monthXpath = "//select[@id='month']//option";
		String dayXpath = "//select[@id='day']//option";
		
		selectDropDownValue(yearXpath, "1994");
		selectDropDownValue(monthXpath, "Sep");
		selectDropDownValue(dayXpath, "2");
		
	}
	

	public static void selectDropDownValue(String xpathValue, String value) {
			
		List<WebElement> monthList = driver.findElements(By.xpath(xpathValue));
		//System.out.println(monthList.size());
		for (int i = 0; i<monthList.size();i++) {
			System.out.println(monthList.get(i).getText());
			if(monthList.get(i).getText().equals(value)) {
				monthList.get(i).click();
				break;
			}
		}
		
//		List<WebElement> dayList = driver.findElements(By.xpath(xpathValue));
//		//System.out.println(monthList.size());
//		for (int i = 0; i<dayList.size();i++) {
//			System.out.println(dayList.get(i).getText());
//			if(dayList.get(i).getText().equals(value)) {
//				dayList.get(i).click();
//				break;
//			}
//		}
//		
//		List<WebElement> yearList = driver.findElements(By.xpath(xpathValue));
//		//System.out.println(monthList.size());
//		for (int i = 0; i<yearList.size();i++) {
//			System.out.println(yearList.get(i).getText());
//			if(yearList.get(i).getText().equals(value)) {
//				yearList.get(i).click();
//				break;
//			}
//		}
	}
}

