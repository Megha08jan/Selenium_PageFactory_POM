package com.test.automation.uiAutomation.customlistner;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.test.automation.uiAutomation.testBase.Testbase;
import com.test.automation.uiAutomation.uiActions.Homepage;

public class Listener extends Testbase implements ITestListener {

	public static final Logger log = Logger.getLogger(Listener.class.getName());
    
	

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
	

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

		Calendar calendar = Calendar.getInstance();//creating object of calender class old screenshot get replace with new one but because of calender everytime new screenshot will get created
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
     
		
		
		String methodename = result.getName();//give methodname on runtime
		if(result.isSuccess()){
	
		try {
			File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//directory of file so we are making object of file		
   String reportdirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\src\\main\\java\\com\\test\\automation\\uiAutomation\\";
   File destfile = new File((String) reportdirectory + "//passed_screenshots//" +  methodename + " _ " +formater.format(calendar.getTime()) + ".png");
   
   FileUtils.copyFile(srcfile, destfile);
   
   Reporter.log("<a href = ' " + destfile.getAbsolutePath() + " '> <img src=' " + destfile.getAbsolutePath() + " ' height = '100' width = '100'/> </a>");
		}
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		}

		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		Calendar calendar = Calendar.getInstance();//creating object of calender class old screenshot get replace with new one but because of calender everytime new screenshot will get created
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		String methodename = result.getName();//give methodname on runtime
		if(!result.isSuccess()){
	
		try {
			File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//directory of file so we are making object of file		
   String reportdirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\src\\main\\java\\com\\test\\automation\\uiAutomation\\";
   File destfile = new File((String) reportdirectory + "//failure_screenshots//" +  methodename + " _ " +formater.format(calendar.getTime()) + ".png");
   
   FileUtils.copyFile(srcfile, destfile);
   
   Reporter.log("<a href = ' " + destfile.getAbsolutePath() + " '> <img src=' " + destfile.getAbsolutePath() + " ' height = '100' width = '100'/> </a>");
		}
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
