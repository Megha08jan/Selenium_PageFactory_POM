package com.test.automation.uiAutomation.productdetailspage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.homepage.TC003_verifyloginwithdifferentrecord;
import com.test.automation.uiAutomation.testBase.Testbase;
import com.test.automation.uiAutomation.uiActions.Homepage;
import com.test.automation.uiAutomation.uiActions.Productdetails;

public class TC001_Selectproduct extends Testbase {

	Homepage homepage;
	Productdetails productdetail;
	public static final Logger log = Logger.getLogger(TC001_Selectproduct.class.getName());

	
	@BeforeClass
	public void setup() throws IOException{

		init();
	}
	
	
	
	@Test
	public void selectproduct(){  

		try {
			log("--------------starting selecproduct testing-------------");	
		     
			homepage = new Homepage(driver);
			homepage.switchtoframe();
			homepage.clickOnNavigationMenu(homepage.mens);
			homepage.clickOnProductInMensSection(homepage.jackets);
			productdetail = new Productdetails(driver);
			productdetail.selectProduct(productdetail.contrast_jacket);
			getscrrenshot("selectproduct");
			homepage.switchtodefault();
			log("-------------finished---------------");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			getscrrenshot("selectproduct");
		}


	}



	@AfterTest
	public void endtestcase(){

			closebrowser();

	}


	public void log(String loginfo){

		log.info(loginfo);
		Reporter.log(loginfo);

	}

}
