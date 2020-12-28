package com.mesf.test;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.mesf.base.Base;
import com.mesf.pages.LoginPage;

public class LoginTest extends Base {
	
	public static WebDriver driver;
	public LoginPage lp;
	
	@BeforeMethod
	public void setUp() throws IOException {
		driver=Base.initializeDriver();
		lp=new LoginPage(driver);
	}
	
	@Test(groups= {"smoke"},description="This TC will perform valid Username and valid Password")
	public void validUsernameAndPass() throws InterruptedException {
		Assert.assertTrue(lp.valid_Pass_And_Valid_Username());
	}
	
	@Test(description="This TC will perform valid Username and Invalid Password")
	public void validUsernameAndInvalidPass() throws InterruptedException {
		Assert.assertTrue(lp.valid_Username_And_Invalid_Pass());
	}
	
	@Test(description="This TC will perform Invalid Username and valid Password")
	public void InvalidUsernameAndvalidPass() throws InterruptedException {
		Assert.assertTrue(lp.Invalid_Username_And_valid_Pass());
	}
	
	@Test(description="This TC will perform Invalid Username and Invalid Password")
	public void InvalidUsernameAndInvalidPass() throws InterruptedException {
		Assert.assertTrue(lp.Invalid_Username_And_Invalid_Pass());
	}
	
	@AfterMethod
	public void tearDown(){
		if(driver!=null) {
			driver.quit();
		}
	}
}
