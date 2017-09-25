package com.test.automation.uiAutomation.homepage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.Testbase;
import com.test.automation.uiAutomation.uiActions.Homepage;

public class TC001_verifyloginwithinvalidcredentials extends Testbase {
	public static final Logger log = Logger.getLogger(TC001_verifyloginwithinvalidcredentials.class.getName());
	Homepage homepage;
	
	@BeforeTest
	public void setup() throws IOException{
		
		init();
	}
	
	@Test
	public void verifyloginwithinvalidcredentials(){
		log.info("------------------Starting verifyloginwithinvalidcredentials Test------------ ");
	     homepage = new Homepage(driver);
		homepage.logintoapplications("123@gmail.com", "12345");
		Assert.assertEquals(homepage.getinvalidlogintext(), "Authentication failed.");
	log.info("------------------Finishing verifyloginwithinvalidcredentials Test------------ ");
	
	}
	
	@AfterClass
	public void endTest(){
		
	driver.close();
		
	}
	
}
