package com.mesf.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.mesf.repository.tournamentRepository;
import com.mesf.utility.seleniumUtils;

public class CreateTournament {

	public static WebDriver driver;
	tournamentRepository tr=null;
	
	Logger log=Logger.getLogger(CreateTournament.class);
	
	public CreateTournament(WebDriver driver) {
		this.driver=driver;
		tr=new tournamentRepository(driver);
	}
	
	@Test
	public boolean to_make_bracket() throws InterruptedException {
		seleniumUtils.explicitlyWait(tr.createTournament, driver);
		tr.createTournament.click();
		seleniumUtils.explicitlyWait(tr.generateBracket, driver);
		tr.generateBracket.click();
		seleniumUtils.explicitlyWait(tr.loginByEmailAddress, driver);
		tr.loginByEmailAddress.click();
		seleniumUtils.explicitlyWait(tr.loginAddress, driver);
		tr.loginAddress.sendKeys("paras.mohod@gmail.com");
		seleniumUtils.explicitlyWait(tr.loginPass, driver);
		tr.loginPass.sendKeys("NewYear@2010");
		seleniumUtils.explicitlyWait(tr.loginButton, driver);
		tr.loginButton.click();
		seleniumUtils.explicitlyWait(tr.bracketName, driver);
		tr.bracketName.sendKeys("AAA");
		seleniumUtils.explicitlyWait(tr.maximumParticipants, driver);
		tr.maximumParticipants.clear();
		seleniumUtils.explicitlyWait(tr.maximumParticipants, driver);
		tr.maximumParticipants.sendKeys("8");
		seleniumUtils.explicitlyWait(tr.generateBracket, driver);
		tr.generateBracket.click();
		return true;
	}
	
	@Test
	public boolean to_make_edit_bracket() throws InterruptedException {
		to_make_bracket();
		seleniumUtils.explicitlyWait(tr.editButton, driver);
		tr.editButton.click();
		seleniumUtils.explicitlyWait(tr.bracketName, driver);
		tr.bracketName.sendKeys("AAA");
		seleniumUtils.explicitlyWait(tr.maximumParticipants, driver);
		tr.maximumParticipants.clear();
		seleniumUtils.explicitlyWait(tr.maximumParticipants, driver);
		tr.maximumParticipants.sendKeys("8");
		seleniumUtils.explicitlyWait(tr.generateBracket, driver);
		tr.generateBracket.click();
		return true;
	}
	
	@Test
	public boolean to_save_bracket() throws InterruptedException {
		to_make_bracket();
		seleniumUtils.explicitlyWait(tr.saveButton, driver);
		tr.saveButton.click();
		return true;
	}
		
	@Test
	public boolean to_delete_bracket() throws InterruptedException {
		to_make_bracket();
		log.info("bracket is created");
		seleniumUtils.explicitlyWait(tr.saveButton, driver);
		tr.saveButton.click();
		log.info("bracket is created");
		seleniumUtils.explicitlyWait(tr.deleteButton, driver);
		tr.deleteButton.click();
		log.info("bracket is created");
		seleniumUtils.explicitlyWait(tr.confirmButton, driver);
		tr.confirmButton.click();
		log.info("bracket is deleted");
		return true;
	}
	
	@AfterMethod
	public void tearDown(){
		if(driver!=null) {
			driver.quit();
		}
	}
}
