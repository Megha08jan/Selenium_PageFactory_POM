package com.test.automation.uiAutomation.homepage;



import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.customlistner.Listener;
import com.test.automation.uiAutomation.testBase.Testbase;
import com.test.automation.uiAutomation.uiActions.Homepage;

public class TC002_VerifyRegistration extends Testbase {

	
	public static final Logger log = Logger.getLogger(TC002_VerifyRegistration.class.getName());
	
	Homepage homepage;
	String firstname = "megha"; 
	String lastname = "jain";
     String email = "automation@gmail.com";
    String pwd = "password";
   
    
	@BeforeTest
	public void setup() throws IOException{
		
		init();
	
	}

@Test
public void VerifyRegistration(){ 

			log.info("------------starting user registration-------");
		
			homepage = new Homepage(driver);
		
		homepage.registaruser( firstname,  lastname,  email,  pwd);
		Assert.assertEquals(true, homepage.verifyregistrationmsg());
		log.info("------------End user registration-------");
	
}

@AfterClass
public void endTest(){  
	
driver.close();
}

}
