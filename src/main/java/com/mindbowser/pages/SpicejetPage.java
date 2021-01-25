package com.mindbowser.pages;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mindbowser.repository.SpicejetRepository;

public class SpicejetPage extends SpicejetRepository{
	
	public static WebDriver driver;
	
	public SpicejetPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	@Test
	public boolean Verify_Student_is_mentioned_under_Discounts_field_Or_Not() throws InterruptedException {
		originStation.click();
		departure.click();
		arrival.click();
	    driver.findElement(By.xpath("(//a[text()='"+dateOfMonth()+"'])[1]")).click();
		inputDate.click();
		toDate.click();
		studentDiscount.click();
		findFlights.click();
		WebElement ele=discounts;
		Assert.assertEquals(ele.getText(), "Student");
		return true;
	}
	
	public static int dateOfMonth() {
		Date date = new Date();  
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
	    String strDate= sdf.format(date); 
	    String d[]=strDate.split("/");
	    int Month=Integer.parseInt(d[0])+2;
		return Month;
	}
}
