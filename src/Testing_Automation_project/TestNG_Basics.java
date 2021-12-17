package Testing_Automation_project;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Basics {

	//Pre-conditions annotations - starting with @Before
	
	@BeforeSuite // 1st thing to run in testNG
	public void setUp() {
		System.out.println("Suite");
	}
	
	@BeforeTest // 2nd thing to run in TestNG
	public void Launchbrowser(){
		System.out.println("Test");
	}
	
	@BeforeClass // 3rd thing to run in TestNG
	public void login(){
		System.out.println("class");
	}
		
	@BeforeMethod // 4th thing to run in TestNG
	public void enterURL(){
		System.out.println("Mehtod");		
	}
	
	// main Test cases execution
	
	@Test (priority = 1, groups = "1st Test") // 5th thing to run in TestNG
	public void googleTitleList(){
		System.out.println("Actual test");
	}
	
	@Test(priority = 2, groups = "2nd Test")
	public void searchTest() {
		System.out.println("test2");
	}
	
	@Test(priority = 3, groups = "3rd Test")
	public void googleLogoTest() {
		System.out.println("google logo test");
	}
	//Post conditions After running the test is complete starts with @After
	
	@AfterMethod
	public void logout(){
		System.out.println("After method");
	}
	
	@AfterClass
	public void deleteAllCookies() {
		System.out.println("After class");
	}
	
	@AfterTest
	public void closeBrowser() {
		System.out.println("After test");
	}
	
	@AfterSuite
	public void generateTestReport() {
		System.out.println("After Suite");
	}
	
}
