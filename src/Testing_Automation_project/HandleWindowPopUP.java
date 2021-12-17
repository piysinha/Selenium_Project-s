package Testing_Automation_project;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindowPopUP {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Latest Eclipse\\Selenium 4.0\\Driver's\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.rrc.texas.gov/resource-center/research/gis-viewer/gis-popup-blocker-test/#");

		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		driver.findElement(By.xpath("//a[contains(text(),'RUN POPUP TEST')]")).click();

		Set<String> handler = driver.getWindowHandles();
		Iterator <String> it = handler.iterator();

		String parentWindowID = it.next();
		System.out.println("Parent Window ID is : " + parentWindowID);

		String childWindowID = it.next();
		System.out.println("Child Window ID is : " + childWindowID);

		driver.switchTo().window(childWindowID);

		System.out.println("Child window popUp title : "+ driver.getTitle());

		Thread.sleep(3000);

		driver.close();

		driver.switchTo().window(parentWindowID);

		System.out.println("Parent window title : " + driver.getTitle());

		Thread.sleep(3000);

		driver.quit();

	}

}
