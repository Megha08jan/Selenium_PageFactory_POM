package com.test.automation.uiAutomation.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.test.automation.uiAutomation.customlistner.Listener;
import com.test.automation.uiAutomation.excelReader.Excelread;

public class Testbase {
//Parent class for all classes : reusable method, common configuration required by all classes
	
	public static final Logger log = Logger.getLogger(Testbase.class.getName());//want to log for the class
	
	public WebDriver driver;
	
	Properties OR = new Properties();
	
	Excelread excel;
	
	public void loaddata() throws IOException{
		
		File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\test\\automation\\uiAutomation\\config\\config.properties");
		FileInputStream f = new FileInputStream(file);
		OR.load(f);
		
	}
	public void init() throws IOException{
		loaddata();
		System.out.println(OR.getProperty("browser"));
		selectBrowser(OR.getProperty("browser"));
		
		geturl(OR.getProperty("url"));
		
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);//configuration of log4j.properties
		
	}
	
	public void selectBrowser(String browser){
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			 System.setProperty("webdriver.chrome.driver", "D:\\seleniumex\\chromdriver_win32\\chromedriver.exe");
            log.info("creating the object of"+browser);
		    driver = new ChromeDriver();
		    
		}
		
			
		
	}
	
	public void geturl(String url){
		log.info("navigating to" +url);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
	}
	
	public Object[][] getdata(String excelname, String sheetname) throws IOException{
		String path = "D:\\POM\\uiAutomation\\src\\main\\java\\com\\test\\automation\\uiAutomation\\data\\"+excelname;
		excel = new Excelread(path);
        
		String[][] data= excel.excel_reader(sheetname,excelname);
		
		return data;
	}
	
	public void getscrrenshot(String name) {

    try {
		Calendar calendar = Calendar.getInstance();//creating object of calender class
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String reportdirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\src\\main\\java\\com\\test\\automation\\uiAutomation\\screensots\\";
   File destfile = new File((String) reportdirectory + name + " _ " +formater.format(calendar.getTime()) + ".png");
   FileUtils.copyFile(srcfile, destfile);
   
   Reporter.log("<a href = ' " + destfile.getAbsolutePath() + " '> <img src=' " + destfile.getAbsolutePath() + " ' height = '100' width = '100'/> </a>");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    
	}
	
	public void waitForElement(WebDriver driver, int timeoutseconds, WebElement elements){
		
		WebDriverWait wait = new WebDriverWait(driver, timeoutseconds);
		wait.until(ExpectedConditions.visibilityOf(elements));
		
	}
	
	
	public Iterator<String> getallwindows(){
		
		Set<String> windows = driver.getWindowHandles();
	    Iterator<String> itr = windows.iterator();
	    
	    return itr;
		
	}
	
	public void closebrowser(){
		
		driver.quit();
		log.info("browser is closed");
		
	}
	
	
	
	
}
