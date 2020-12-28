package com.mesf.reports;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenshotFile {
	
	public WebDriver driver;
	
	public static String getScreenShotPath(WebDriver driver,String screenshotName) throws IOException {
		Date date=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMddhhmmss");
		String dateName =dateFormat.format(date);
		TakesScreenshot ts=(TakesScreenshot )driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"/FailedTestsScreenshots/"+screenshotName+dateName+"demo.jpg";
		File finaldestination=new File(destination);
		try {
			FileUtils.copyFile(src, finaldestination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destination;	
	}
}
