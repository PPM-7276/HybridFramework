package com.mindbowser.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.mindbowser.pages.SpicejetPage;
import com.mindbowser.repository.SpicejetRepository;

/**
 * 
 * @author paras
 * Driver class is used to start browsers based on the property file input.
 * User gets the option to work on firefox and chrome browser.
 * Private constructor to avoid external initialisation	 - DesignPattern is achieved
 */

public class Base {
	
	public static WebDriver driver;
	public SpicejetRepository lr;
	public SpicejetPage lp;

	public static WebDriver initializeDriver() throws IOException {
		WebDriver driver=BrowserFactory.browserInstance(ReadPropertyFile.get("browser"));
		driver.get(ReadPropertyFile.get("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		driver=Base.initializeDriver();
		lp=new SpicejetPage(driver);
		lr=new SpicejetRepository(driver);
	}
	
	
	
	
	@AfterMethod
	public void tearDown(){
		if(driver!=null) {
			driver.quit();
		}
	}
	
}
