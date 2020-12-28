package com.mesf.utility;

import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class seleniumUtils extends Constants {
	
	public WebDriver driver;
	
	public static void explicitlyWait(WebElement element,WebDriver driver) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICITWAIT);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.ignoring(NoSuchElementException.class);
	}

	public static boolean isVisible(WebElement element) {
		boolean flag = false;
		try {
			if (element.isDisplayed()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static void sendkeys(WebElement element, String text,WebDriver driver) {
		explicitlyWait(element, driver);
		element.sendKeys(text);
	}
	
	public static void click(WebElement element)  {
		element.click();
	}
}