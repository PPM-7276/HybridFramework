package com.mesf.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class tournamentRepository {
	
	public WebDriver driver;

	public tournamentRepository(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[text()=' Create new tournament ']")
	public WebElement createTournament;
	
	@FindBy(xpath="//button[text()=' GENERATE BRACKET ']")
	public WebElement generateBracket;
	
	@FindBy(xpath="//span[text()='LOGIN BY EMAIL ADDRESS']")
	public WebElement loginByEmailAddress;
	
	@FindBy(xpath="(//input[contains(@id, 'mat-input')])[1]")
	public WebElement loginAddress;
	
	@FindBy(xpath="(//input[contains(@id, 'mat-input')])[2]")
	public WebElement loginPass;
	
	@FindBy(xpath="//button[text()=' LOGIN ']")
	public WebElement loginButton;
	
	@FindBy(xpath="//input[@id='bracket_name']")
	public WebElement bracketName;
	
	@FindBy(xpath="//button[text()=' EDIT ']")
	public WebElement editButton;
	
	@FindBy(xpath="//input[@id='maximum_participants']")
	public WebElement maximumParticipants;
	
	@FindBy(xpath="//button[text()=' SAVE ']")
	public WebElement saveButton;
	
	@FindBy(xpath="(//*[name()='svg' and @data-icon='trash'])[1]")
	public WebElement deleteButton;
	
	@FindBy(xpath="(//button[text()=' CONFIRM '])")
	public WebElement confirmButton;
	
}
