package com.mesf.utility;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/*
 * All the utilities needed for the framework is placed in this class including all select class
 * 
 */

public class SelectUtility {
		
	WebDriver driver;

	public static void SelectByValue(WebElement element, String value) {
		Select se = new Select(element);
		se.selectByValue(value);
	}

	public static void SelectByIndex(WebElement element, int index) {
		Select se = new Select(element);
		se.selectByIndex(index);
	}

	public static void SelectByVisibleText(WebElement element, String text) {
		Select se = new Select(element);
		se.selectByVisibleText(text);
	}

	public static void deSelectall(WebElement element) {
		Select se = new Select(element);
		se.deselectAll();
	}

	public static void deSelectByValue(WebElement element, String value) {
		Select se = new Select(element);
		se.deselectByValue(value);
	}

	public static void deSelectByIndex(WebElement element, int index) {
		Select se = new Select(element);
		se.deselectByIndex(index);
	}

	public static void deSelectByVisibleText(WebElement element, String value) {
		Select se = new Select(element);
		se.deselectByVisibleText(value);
	}

	public static List<WebElement> getOptions(WebElement element) {
		Select se = new Select(element);
		List<WebElement> selectedall = se.getAllSelectedOptions();
		return selectedall;
	}

}
