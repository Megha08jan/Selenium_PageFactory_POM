package com.test.automation.uiAutomation.homepage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.Testbase;
import com.test.automation.uiAutomation.uiActions.Homepage;

public class TC003_verifyloginwithdifferentrecord extends Testbase {
	
	Homepage homepage; 
	
	@DataProvider(name = "logindata")
	public Object[][] gettestdata() throws IOException{
		
		Object[][] testrecords = getdata("Testdata.xlsx", "Sheet1");
		
	return testrecords;
	}
	
	@BeforeClass
	public void setup() throws IOException{
		
		init();
	}
	
	
	@Test(dataProvider = "logindata")
	public void verifyloginwithdifferentrecord(String emailid, String passwrd, String runmode){
		
		if(runmode.equalsIgnoreCase("n")){
			
			throw new SkipException("marked as no run");
		}
		log.info("------------Sta Verifyingloginwith different recordes");
		homepage = new Homepage(driver);
		homepage.logintodemosite(emailid, passwrd);
	boolean status = homepage.verifylogout();
	//	getscrrenshot("testlogin_" +emailid);
       if( status ){
        	homepage.clickonlogout();
        }
        Assert.assertEquals(status, true);
		log.info("-----------FInished login with different recorde---------------");
	}
	

}
