package com.test.automation.uiAutomation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.test.automation.uiAutomation.testBase.Testbase;

public class Addtocartpage extends Testbase {
	
	WebDriver driver;
	
	public static final Logger log = Logger.getLogger(Addtocartpage.class.getName());
	
	public Addtocartpage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath = "//*[@title = 'Share on Facebook']")
	WebElement facebooklink;
	
	@FindBy (xpath = "//*[@title ='Tweet on Twitter']")
	WebElement twitterlink;
	
	@FindBy (xpath = "//*[@title ='Pin on Pinterest']")
	WebElement pinlink;
	
	@FindBy(xpath = "//*[@id = 'AddToCart']")
	WebElement addtocartlink;
	
	@FindBy(xpath = "//*[contains(text(),'Log in to your Facebook account to share.')]")
	WebElement facebookmsg;
	
   public void addtocart(){
	   
	   addtocartlink.click();
	   log("clicked on"+addtocartlink.toString());
   }
   
   
   public void clickonfacebook(){
	   
	   facebooklink.click();
	   log("clicked on facebooklink"+facebooklink.toString());
   }
   
 public void clickontwitter(){
	   
	   twitterlink.click();
	   log("clicked on facebooklink"+twitterlink.toString());
   }
  
   
 public boolean verifyfacebookmsg(){
	 
	try {
		facebookmsg.isDisplayed();
		log("facebook is displayed");
		return true;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		return false;
	}
	 
 }
   public void log(String loginfo){

		log.info(loginfo);
		Reporter.log(loginfo);

	}

}
