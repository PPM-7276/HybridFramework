package com.mesf.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginRepository {

	public WebDriver driver;

	public LoginRepository(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="button.btn.btn-outline-light.is-smallTor.Header-btn.ng-star-inserted")
	public WebElement btn;
	
	@FindBy(xpath="//span[text()='LOGIN BY EMAIL ADDRESS']")
	public WebElement loginByEmailAddress;
	
	@FindBy(xpath="//b[text()='REGISTER NOW']")
	public WebElement registerNow;
	
	@FindBy(xpath="//span[text()='REGISTER BY EMAIL ADDRESS']")
	public WebElement registerByEmailAddress;
	
	@FindBy(xpath="(//input[contains(@id, 'mat-input')])[1]")
	public WebElement loginText;
	
	@FindBy(xpath="(//input[contains(@id, 'mat-input')])[2]")
	public WebElement passtext;
	
	@FindBy(xpath="//button[text()=' LOGIN ']")
	public WebElement loginButton;
	
	@FindBy(xpath="//button[text()=' LOGOUT ']")
	public WebElement logoutButton;
	
	@FindBy(xpath="//input[@id='country-search-box']")
	public WebElement mobileCode;
	
	@FindBy(xpath="//ul/li[@id='in']")
	public WebElement indiaCode;
	
	@FindBy(xpath="//input[@id='firstInput']")
	public WebElement input;
	
	@FindBy(xpath="//button[text()=' NEXT ']")
	public WebElement nextButton;
	
	@FindBy(xpath="//span/img[@class='ng-star-inserted']")
	public WebElement avatar;
	
	@FindBy(xpath="//button[text()=' PROFILE ']")
	public WebElement clickProfile;
	
	@FindBy(xpath="//form")
	public WebElement form;
	
	@FindBy(xpath="//mat-error")
	public WebElement matError;
	
	@FindBy(xpath="//div[text()=' Email address or password is incorrect ']")
	public WebElement msgOfEmailAndPass;
	
}
