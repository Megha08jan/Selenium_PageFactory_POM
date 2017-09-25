package com.test.automation.uiAutomation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.test.automation.uiAutomation.testBase.Testbase;

public class Homepage extends Testbase {
//PageFactory
	public static final Logger log = Logger.getLogger(Homepage.class.getName());
	
	WebDriver driver;
	
	public final String mens = "Mens";
	public final String jackets = "Jackets";
	//public final String womens = "Womens";
	//public final String pants = "Pants";
	
	
	@FindBy(xpath = "//*[contains(text(),'Sign in')]")
	WebElement signin;
	
	@FindBy(xpath = "//*[@id = 'email']")
	WebElement loginemailaddr;
	
	@FindBy(xpath = "//*[@id = 'passwd']")
	WebElement loginpwd;
	
	@FindBy(xpath = "//*[@id = 'SubmitLogin']")
	WebElement submitbutton;
	
	@FindBy(xpath = "//*[contains(text(),'There is 1 error')]//following::ol")
	WebElement authenticationfailed;
	
	@FindBy(xpath = "//*[@id = 'customer_register_link']")
	WebElement signup;
	
	@FindBy(xpath = "//*[@id = 'FirstName']")
	WebElement firstname;
	
	@FindBy(xpath = "//*[@id = 'LastName']")
	WebElement lastname;
	
	@FindBy(xpath = "//*[@id = 'Email']")
	WebElement email;
	
	@FindBy(xpath = "//*[@id = 'CreatePassword']")
	WebElement pwd;
	
	@FindBy(xpath = "//*[@class = 'btn']")
	WebElement createaccount;
	
	@FindBy (xpath = "//*[@class = 'device-preview__iframe']")
	WebElement homepageframe;
	
	@FindBy(xpath = "//*[@class ='shopify-challenge__message']")
	WebElement captchamsg;
	
	@FindBy(xpath = "//*[@id = 'customer_login_link']")
	WebElement login;
	
	@FindBy(xpath = "//*[@id = 'CustomerEmail']")
	WebElement customeremail;
	
	@FindBy(xpath = "//*[@id = 'CustomerPassword']")
	WebElement customerpassword;
	
	@FindBy(xpath = "//*[@value = 'Sign In']")
	WebElement clickonsignin;
	
	@FindBy(xpath = "//*[@id = 'customer_logout_link']")
	WebElement logout;
	
	public Homepage(WebDriver driver){//constructor : initialize all web element on runtime by supplying driver object and this is current class object
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void logintoapplications(String emailaddr, String password){
		
		signin.click();
		log.info("clicked on sign in"+signin.toString());
		
		loginemailaddr.sendKeys(emailaddr);
		log.info("entered email address"+emailaddr+ "and object is"+loginemailaddr.toString());
		
		loginpwd.sendKeys(password);
		log.info("entered password"+password + "and object is"+loginpwd.toString());
		submitbutton.click();
		log.info("click on submit button and object is "+submitbutton.toString());
	
	}
	
	public String getinvalidlogintext(){
		log.info("error message is:-"+authenticationfailed.getText());
		return authenticationfailed.getText();
		
		
	}
	
	
	public void registaruser(String firstname, String lastname, String email, String pwd ){
		
		
		log.info("in iframe"+homepageframe.toString());
		signup.click();
		log.info("clicked on signin"+signup.toString());
		this.firstname.sendKeys(firstname);
		log.info("firstname is"+firstname+"amd object is "+this.firstname.toString());
		this.lastname.sendKeys(lastname);
		
		log.info("lastname is"+lastname+"amd object is "+this.lastname.toString());
        this.email.sendKeys(email);
        log.info("email is"+email+"amd object is "+this.email.toString());
        this.pwd.sendKeys(pwd);
        log.info("firstname is"+pwd+"amd object is "+this.pwd.toString());
		createaccount.click();
		log.info("clicked on createacoount"+createaccount.toString());
	}
	
	public boolean verifyregistrationmsg(){
		
		try {
			captchamsg.isDisplayed();
			return true;
		} catch (Exception e) {
			return false ;
					}
		
	}
	
	
	public void logintodemosite(String emailid, String passwrd){
		login.click();
		log.info("clickedonlogin"+login.toString());
		customeremail.sendKeys(emailid);
		log.info("customeremail id is "+emailid+ "and objec is"+customeremail.toString());
	    customerpassword.sendKeys(passwrd);
	    log.info("customerpassword id is "+passwrd+ "and objec is"+customerpassword.toString());
  	    clickonsignin.click();
  	  log.info("clickonsignin"+clickonsignin.toString());
  	    
	}
	
	
	public boolean verifylogout(){
		
		try {
			logout.isDisplayed();
			log.info("logout is displayed and object is "+logout.toString());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
		public void clickonlogout(){	
	logout.click();
	log.info("clicked on logout");
		}
			
		public void clickOnNavigationMenu(String menuName){
			driver.findElement(By.xpath("//button[contains(text(),'"+menuName+"') and @aria-expanded='false']")).click();
			log("clicked on:-"+menuName+" navigation menu");
		} 
		
		public void clickOnProductInMensSection(String product){
		driver.findElement(By.xpath("//button[contains(text(),'Mens') and @aria-expanded='true']//following::ul/li/a[contains(text(),'"+product+"')]")).click();
			log("clicked on:-"+product);
		}
	public void switchtoframe(){
		driver.switchTo().frame(homepageframe);
		log.info("switch to frame"+homepageframe.toString());
		
	}
	
	public void switchtodefault(){
		driver.switchTo().defaultContent();
		log.info("switch to default contect");
		
	}
	
public void log(String loginfo){
		
		log.info(loginfo);
		Reporter.log(loginfo);
		
	}

	
}
