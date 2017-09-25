package com.test.automation.uiAutomation.addtocart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;







import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.Testbase;
import com.test.automation.uiAutomation.uiActions.Addtocartpage;
import com.test.automation.uiAutomation.uiActions.Homepage;
import com.test.automation.uiAutomation.uiActions.Productdetails;

public class TC001_Verifyfacebooklink extends Testbase{

	public static final Logger log = Logger.getLogger(TC001_Verifyfacebooklink.class.getName());
	Homepage homepage;
	Productdetails productdetail;
	Addtocartpage addtocart;
	
	
	@BeforeClass
	public void setup() throws IOException{

		init();
	}
	
	List<String> windowsid = new ArrayList<>();
@Test
public void verifyfacebooklink(){
	try {
		log("-------------starting facebooktesting-----------");
		homepage = new Homepage(driver);
		homepage.switchtoframe();
		homepage.clickOnNavigationMenu(homepage.mens);
		homepage.clickOnProductInMensSection(homepage.jackets);
		productdetail = new Productdetails(driver);
		productdetail.selectProduct(productdetail.contrast_jacket);
		addtocart = new Addtocartpage(driver);
		addtocart.clickonfacebook();
		Iterator<String> itr = getallwindows();
		while(itr.hasNext()){
			windowsid.add(itr.next());
		}
		
		driver.switchTo().window(windowsid.get(1));
		boolean status = addtocart.verifyfacebookmsg();
		getscrrenshot("onfacebookpage");
		driver.switchTo().window(windowsid.get(0));
		Assert.assertEquals(true, status);
		
		homepage.switchtodefault();
		log("-----------------finished-----------");
	} catch (AssertionError e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		getscrrenshot("assertionfailed_verifyfacebooklink");
		Assert.assertTrue(false, "verifyfacebooklink");
		
	}
	catch(Exception e){
		//e.printStackTrace();
		log(e.fillInStackTrace().toString());
		getscrrenshot("verifyfacebooklink");
		Assert.assertTrue(false, "verifyfacebooklink");
	}

}


public void log(String loginfo){

	log.info(loginfo);
	Reporter.log(loginfo);

}
@AfterTest

public void endtestcase(){

	closebrowser();
	
}
}
