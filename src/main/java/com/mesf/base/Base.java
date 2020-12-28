package com.mesf.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mesf.pages.CreateTournament;
import com.mesf.pages.LoginPage;
import com.mesf.repository.LoginRepository;
import com.mesf.utility.seleniumUtils;

/**
 * 
 * @author paras
 * Driver class is used to start browsers based on the property file input.
 * User gets the option to work on firefox and chrome browser.
 * Private constructor to avoid external initialisation	 - DesignPattern is achieved
 */

public class Base {
	
	public static WebDriver driver;
	public LoginRepository lr;
	public LoginPage lp;
	public CreateTournament ct;
	
	
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
		lp=new LoginPage(driver);
		ct=new CreateTournament(driver);
		lr=new LoginRepository(driver);
	}
	
	
	public void LoginFunction() {
		lr.btn.click();
		seleniumUtils.explicitlyWait(lr.loginByEmailAddress, driver);
		lr.loginByEmailAddress.click();
		seleniumUtils.explicitlyWait(lr.loginText, driver);
		lr.loginText.sendKeys("paras.mohod@gmail.com");
		seleniumUtils.explicitlyWait(lr.passtext, driver);
		lr.passtext.sendKeys("NewYear@2010");
		seleniumUtils.explicitlyWait(lr.loginButton, driver);
		lr.loginButton.click();
	}
	
	
	@AfterMethod
	public void tearDown(){
		if(driver!=null) {
			driver.quit();
		}
	}
	
}
