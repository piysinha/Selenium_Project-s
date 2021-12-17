package Testing_Automation_project;

import org.testng.annotations.Test;

public class TestNG_Features {

	/*
	 * @Test() public void loginTest() { System.out.println("Login Test"); int i =
	 * 9/0; }
	 * 
	 * @Test(dependsOnMethods = "loginTest") public void homePageTest() {
	 * System.out.println("Home Page Test"); }
	 * 
	 * 
	 * @Test(dependsOnMethods = "loginTest") public void searchPageTest() {
	 * System.out.println("Search page Test"); }
	 * 
	 * @Test(dependsOnMethods = "loginTest") public void reqPageTest() {
	 * System.out.println("Reg page Test"); }
	 * 
	 * 
	 */ 

	@Test(invocationCount = 5) public void sum() { 
		int a = 20; 
		int b = 30; 
		int c = a + b; 
		System.out.println(c);
	}

	@Test(expectedExceptions = NumberFormatException.class)
	public void test1() {
		String x = "100A";
		Integer.parseInt(x);
	}

}
