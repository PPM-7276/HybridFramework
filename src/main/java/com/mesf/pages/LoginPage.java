package com.mesf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.mesf.repository.LoginRepository;
import com.mesf.utility.seleniumUtils;

public class LoginPage {
	
	public static WebDriver driver;
	public LoginRepository lr;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		lr=new LoginRepository(driver);
	}

	@Test(enabled=false)
	public void creation_Of_New_User() throws InterruptedException {
		try {
			lr.btn.click();		
			seleniumUtils.explicitlyWait(lr.loginByEmailAddress, driver);
			lr.loginByEmailAddress.click();
			seleniumUtils.explicitlyWait(lr.loginText, driver);
			lr.loginText.sendKeys("paras.mohod@gmail.com");
			seleniumUtils.explicitlyWait(lr.passtext, driver);
			lr.passtext.sendKeys("NewYear@2010");
			Thread.sleep(5000);
			seleniumUtils.explicitlyWait(lr.loginButton, driver);
			lr.loginButton.click();
			Thread.sleep(5000);
			driver.findElement((By.cssSelector("div.iti-arrow"))).click();	
			Thread.sleep(5000);
			lr.mobileCode.sendKeys("91");
			Thread.sleep(5000);
			lr.indiaCode.click();
			Thread.sleep(5000);
			lr.input.sendKeys("7276106117");
			lr.nextButton.click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public boolean valid_Pass_And_Valid_Username() throws InterruptedException {
		try {
			lr.btn.click();
			seleniumUtils.explicitlyWait(lr.loginByEmailAddress, driver);
			lr.loginByEmailAddress.click();
			seleniumUtils.explicitlyWait(lr.loginText, driver);
			lr.loginText.sendKeys("paras.mohod@gmail.com");
			seleniumUtils.explicitlyWait(lr.passtext, driver);		
			lr.passtext.sendKeys("NewYear@2010");
			seleniumUtils.explicitlyWait(lr.loginButton, driver);
			lr.loginButton.click();
			seleniumUtils.explicitlyWait(lr.avatar, driver);
			lr.avatar.click();
			seleniumUtils.explicitlyWait(lr.clickProfile, driver);
			lr.clickProfile.click();
			seleniumUtils.explicitlyWait(lr.form, driver);
			Boolean formDisplayed=lr.form.isDisplayed();
			if(formDisplayed.TRUE) {
				System.out.println("Form is Displayed");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	@Test
	public boolean valid_Username_And_Invalid_Pass() throws InterruptedException {
		try {
			lr.btn.click();			
			seleniumUtils.explicitlyWait(lr.loginByEmailAddress, driver);
			lr.loginByEmailAddress.click();
			seleniumUtils.explicitlyWait(lr.loginText, driver);
			lr.loginText.sendKeys("paras.mohod@gmail.com");
			seleniumUtils.explicitlyWait(lr.passtext, driver);
			lr.passtext.sendKeys("NEWYEAR2010");
			seleniumUtils.explicitlyWait(lr.loginButton, driver);
			lr.loginButton.click();			
			seleniumUtils.explicitlyWait(lr.msgOfEmailAndPass, driver);
			String errorMsg=lr.msgOfEmailAndPass.getText(); 
			if(errorMsg.equals("Email address or password is incorrect")) {
				System.out.println("Password Is Incorrect");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	@Test
	public boolean Invalid_Username_And_valid_Pass() throws InterruptedException {
		try {
			lr.btn.click();		
			seleniumUtils.explicitlyWait(lr.loginByEmailAddress, driver);		
			lr.loginByEmailAddress.click();
			seleniumUtils.explicitlyWait(lr.loginText, driver);
			lr.loginText.sendKeys("paras.mohodgmail.com");
			seleniumUtils.explicitlyWait(lr.passtext, driver);
			lr.passtext.sendKeys("NewYear@2010");
			seleniumUtils.explicitlyWait(lr.matError, driver);
			String errorMsg=lr.matError.getText(); 
			if(errorMsg.equals("Invalid email address")) {
				System.out.println("Email Is Incorrect");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	@Test
	public boolean Invalid_Username_And_Invalid_Pass() throws InterruptedException {
		try {
			lr.btn.click();		
			seleniumUtils.explicitlyWait(lr.loginByEmailAddress, driver);
			lr.loginByEmailAddress.click();
			seleniumUtils.explicitlyWait(lr.loginText, driver);
			lr.loginText.sendKeys("paras.mohodg");
			seleniumUtils.explicitlyWait(lr.passtext, driver);
			lr.passtext.sendKeys("NEWYEAR2010");
			seleniumUtils.explicitlyWait(lr.matError, driver);
			String errorMsg=lr.matError.getText(); 
			if(errorMsg.equals("Invalid email address")) {
				System.out.println("Email Is Incorrect And Password Is Incorrect");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}		 
}
