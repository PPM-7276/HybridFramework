package com.mesf.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/*
 * Logic to retry test cases and no of retries depends on parameter from properties file
 */
public class RetryFailedTestCases implements IRetryAnalyzer  {

	int count=0;
	int maxLimit=3;
	
	@Override
	public boolean retry(ITestResult result) {
		if (count<maxLimit) {
			count++;
			return true;
		}
		else 
		{
			return false;
		}
	}
}
