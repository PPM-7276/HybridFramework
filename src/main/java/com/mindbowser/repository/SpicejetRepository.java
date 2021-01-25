package com.mindbowser.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mindbowser.pages.SpicejetPage;

public class SpicejetRepository {

	public WebDriver driver;

	public SpicejetRepository(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="ctl00_mainContent_ddl_originStation1_CTXT")
	public WebElement originStation;
	
	@FindBy(xpath="//a[@value='BLR']")
	public WebElement departure;
	
	@FindBy(xpath="(//a[@value='PNQ'])[2]")
	public WebElement arrival;
	
	@FindBy(xpath="//input[@name='ctl00$mainContent$view_date2']/following-sibling::button[@class='ui-datepicker-trigger']")
	public WebElement inputDate;
	
	@FindBy(xpath="(//a[text()='30'])[1]")
	public WebElement toDate;
	
	@FindBy(xpath="//input[@id='ctl00_mainContent_chk_StudentDiscount']")
	public WebElement studentDiscount;
	
	@FindBy(xpath="//input[@id='ctl00_mainContent_btn_FindFlights']")
	public WebElement findFlights;
	
	@FindBy(xpath="//span[text()='Discounts']/following-sibling::span")
	public WebElement discounts;
	
}
