package com.mesf.utility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionUtility {
	
	static WebDriver driver;
	boolean r;

	public static void clickAction(WebElement toClick,WebDriver driver) {
		Actions act=new Actions(driver);
		act.moveToElement(toClick).click().build().perform();
	}

	public static void clickSendkeys(WebElement toClick, String txt) {
		Actions act=new Actions(driver);
		act.moveToElement(toClick).click().sendKeys(txt).build().perform();
	}

	public static void dragDrop(WebElement element, int x, int y) {
		Actions act=new Actions(driver);
		act.dragAndDropBy(element, x, y).perform();
	}

	public static String getValue(WebElement getval) {
		Actions act=new Actions(driver);
		return getval.getText();
	}
	
	public static void mouseHover(WebElement element){
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public static void clickhold(WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).clickAndHold().perform();
	}

	public static void clickhold(WebElement element, WebElement target) {
		Actions act=new Actions(driver);
		act.moveToElement(element).clickAndHold(target).perform();
	}

	public static void contextClick(WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).contextClick().perform();
	}
	
	public static void contextClick(WebElement element, WebElement target) {
		Actions act=new Actions(driver);
		act.moveToElement(element).contextClick(target).perform();
	}
	
	public static void doubleClick(WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).doubleClick().perform();
	}
	
	public static void doubleClick(WebElement element, WebElement target) {
		Actions act=new Actions(driver);
		act.moveToElement(element).doubleClick(target).perform();
	}
	
	public static void dragDrop(WebElement source, WebElement target) {
		Actions act=new Actions(driver);
		act.dragAndDrop(source, target).perform();
	}
	
	public static void keyDown(WebElement element, String val){
		Actions act=new Actions(driver);
		act.keyDown(element, Keys.CONTROL).sendKeys(val).build().perform(); 
	}
	public static void keyDown(String val){
		Actions act=new Actions(driver);
		act.keyDown( Keys.CONTROL).sendKeys(val).build().perform(); 
	}
	
	public static void keysup(WebElement element, String val){
		Actions act=new Actions(driver);
		act.keyUp(element, Keys.CONTROL).sendKeys(val).build().perform(); 
	}
	public static void keysup(String val){
		Actions act=new Actions(driver);
		act.keyUp( Keys.CONTROL).sendKeys(val).build().perform(); 
	}
	
	public static void movetoOffset(int x,int y){
		Actions act=new Actions(driver);
		act.moveByOffset(x, y).click().build().perform();
	}
}
