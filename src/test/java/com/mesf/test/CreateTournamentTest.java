package com.mesf.test;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mesf.base.Base;
import com.mesf.pages.CreateTournament;


public class CreateTournamentTest extends Base {

	public static WebDriver driver;
	CreateTournament ct;
	
	@BeforeMethod
	public void setUp() throws IOException {
		driver=Base.initializeDriver();
		ct=new CreateTournament(driver);
	}
	
	@Test(description="here i want to create bracket")
	public void toCreatebracket() throws InterruptedException {
		Assert.assertTrue(ct.to_make_bracket());
	}
	
	@Test(description="here i want to edit bracket")
	public void toEditBracket() throws InterruptedException {
		Assert.assertTrue(ct.to_make_edit_bracket());
	}
	
	@Test(description="here i want to save bracket")
	public void toSaveBracket() throws InterruptedException {
		Assert.assertTrue(ct.to_save_bracket());
	}
	
	@Test(description="here i want to delete bracket")
	public void toDeleteBracket() throws InterruptedException {
		Assert.assertTrue(ct.to_delete_bracket());
	}
	
	@AfterMethod
	public void tearDown(){
		if(driver!=null) {
			driver.quit();
		}
	}
}
