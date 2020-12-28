package com.mesf.base;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertyFile {

	/*
	 * 
	 */
	public static String get(String propertyname) {
		
		String returnproperty=null;
		Properties prop = new Properties();
		try {
			FileInputStream file = new FileInputStream("D:\\TestNGFramework\\JavaFramework\\data.properties");
			prop.load(file);
			returnproperty = prop.getProperty(propertyname);
			if(returnproperty==null) {
				throw new Exception("Property named "+propertyname+ " not found");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return returnproperty;
	}
	
}
