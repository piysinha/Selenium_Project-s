package Testing_Automation_project;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class brokenLinkTest {

	public static void main(String[] args) throws MalformedURLException, IOException {

		System.setProperty("webdriver.chrome.driver", "D:\\Latest Eclipse\\Selenium 4.0\\Driver's\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		driver.get("https://www.amazon.in/");

//		driver.findElement(By.name("username")).sendKeys("piyushsinha1995");
//		driver.findElement(By.name("password")).sendKeys("pP507428786@");
//		driver.findElement(By.xpath("//input[@class='btn btn-small']")).click();
//		driver.switchTo().frame(1);


		//1st step : This Below method will get the list of all the links and images present in the webpage : 500
		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		linksList.addAll(driver.findElements(By.tagName("img")));

		System.out.println("Size of the active links and images : " + linksList.size());

		//2nd step : Iterate linklist : exclude all the links and images that doesn't have any href attribute
		List<WebElement> activeLinks = new ArrayList<WebElement>();// 450
		
		for(int i=0; i<linksList.size();i++) {
			System.out.println(linksList.get(i).getAttribute("href"));
			if(linksList.get(i).getAttribute("href")!=null && (! linksList.get(i).getAttribute("href").contains("javascript"))) {
				activeLinks.add(linksList.get(i));
			}
		}	

		//get the size of the active links list:
		System.out.println("Size of the active links and images : " + activeLinks.size());

		//3rd step : check the href url with httpconnection API
//		200 : ok
//		404 : not found
//		500 : internal error
//		400 : bad request
		
		for(int j=0;j<activeLinks.size(); j++) {

			HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();

			connection.connect();
			String response = connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href") + "----->" +response) ;

		}


	}

}
