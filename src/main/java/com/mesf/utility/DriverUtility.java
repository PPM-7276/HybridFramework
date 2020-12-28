package com.mesf.utility;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;

public class DriverUtility {
		
	static WebDriver driver;

	public static void close(WebDriver driver) {
		driver.close();
	}

	public static String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public static void quiting(WebDriver driver) {
		driver.quit();
	}

	public static String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public static Navigation navigateToURL(WebDriver driver) {
		String arg0 = "http://javabykiran.in/Other/thbees/login?back=my-account";
		driver.navigate().to(arg0);
		return null;
	}

	public static Navigation navigate(WebDriver driver) {
		return driver.navigate();
	}

	public static String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public static Options manageMaximize(WebDriver driver) {
		driver.manage().window().maximize();
		return null;
	}

	public static Options manage(WebDriver driver) {
		return driver.manage();
	}

	public static org.openqa.selenium.Alert Alert(WebDriver driver) {
		return driver.switchTo().alert();
	}

	public static void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public static void alertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public static void alertGetText(WebDriver driver) {
		driver.switchTo().alert().getText();
	}

	public static String getWindowHandle(WebDriver driver) {
		return driver.getWindowHandle();
	}

	public static Set<String> getWindowHandles(WebDriver driver) {
		return driver.getWindowHandles();
	}

	public static void IFrame(WebDriver driver, WebElement element, String abc, int a) {
		driver.switchTo().frame(a);
		driver.switchTo().frame(abc);
		driver.switchTo().frame(element);
	}

	public static WebElement findElement(By arg0) {
		return driver.findElement(arg0);
	}

	public static List<WebElement> findElements(By arg0) {
		return driver.findElements(arg0);
	}

	public static void get(String arg0) {
		driver.get(arg0);
	}

	public static TargetLocator switchTo(WebDriver driver) {
		return driver.switchTo();
	}
}
