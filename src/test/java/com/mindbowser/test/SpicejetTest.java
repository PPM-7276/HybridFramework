package com.mindbowser.test;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mindbowser.base.Base;
import com.mindbowser.pages.SpicejetPage;

public class SpicejetTest extends Base {
	
	public static WebDriver driver;
	public SpicejetPage lp;
	
	@BeforeMethod
	public void setUp() throws IOException {
		driver=Base.initializeDriver();
		driver.navigate().to("https://www.spicejet.com/");
		lp=new SpicejetPage(driver);
	}
	
	@Test(description="This TC will book flight from one way")
	public void Verify_Student_is_mentioned_under_Discounts_field() throws InterruptedException {
		Assert.assertTrue(lp.Verify_Student_is_mentioned_under_Discounts_field_Or_Not());
	}

	@AfterMethod
	public void tearDown(){
		if(driver!=null) {
			driver.quit();
		}
	}
}
