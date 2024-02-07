package tests_swagLab;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Base;

public class HomePageVerification extends Base { //Soft Assertion for pass the test
	public static SoftAssert softAssert = new SoftAssert(); 
	@Test(priority = 0)
	public static void homePageVerification() throws InterruptedException {
		// go to URL
		navigate("https://www.saucedemo.com/");
		// get title page
		System.out.println(page.title());
		// verify title page
		assertion("//div[text()='Swag Labs']", "Swag Labs");
		String expresult=innerText("//div[text()='Swag Labs']");
		String actresult="Swag Labs";
		softAssert.assertEquals(expresult, actresult);
		Thread.sleep(1000);
		p("Saucedemo Home Page Verification Done");
	}
	@Test(priority = 1)
	public static void homePageVerification1() throws InterruptedException {	//Skip the Test
		// go to URL
		navigate("https://www.saucedemo.com/");
		// get title page
		System.out.println(page.title());
		// verify title page
		assertion("//div[text()='Swag Labs']", "Swag Labs");
		Thread.sleep(1000);
		p("Saucedemo Home Page Verification Done");
		throw new SkipException("---------------------The test will skip---------------");
	}
	@Test(priority = 2)
	public static void homePageVerification2() throws InterruptedException {//Hard Assert for fail the test
		// go to URL
		navigate("https://www.saucedemo.com/");
		// get title page
		System.out.println(page.title());
		// verify title page
		assertion("//div[text()='Swag Labs']", "Swag Labs");
		Thread.sleep(1000);
		p("Saucedemo Home Page Verification Done");
		Assert.assertEquals("Swag Labs1", "Swag Labs");
		Assert.fail();
	}
}
