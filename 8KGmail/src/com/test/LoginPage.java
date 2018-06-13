package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class LoginPage {
	
	ATUTestRecorder recorder;									// Video Recording
	Credential obj = new Credential();

	@BeforeMethod
	public void setUp() throws ATUTestRecorderException {
		recorder = new ATUTestRecorder(System.getProperty("user.dir") + "\\video","testvideo",false);
		recorder.start();
		obj.start();
	}

	@Test(priority = 1)
	public void checkEmailField() {
		try{
		WebElement title = obj.driver.findElement(By.xpath("//*[@id='headingText']"));
		String titleText = title.getText();
		Assert.assertEquals(titleText, "Sign in");
		System.out.println(titleText);
		WebElement email = obj.driver.findElement(By.id("identifierId"));
		Boolean blank = email.isDisplayed();
		System.out.println("Email field is available");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 2)
	public void clickWithBlankEmail(){
		try{

		WebElement nxtBtnEmail = obj.driver.findElement(By.xpath("//*[@id='identifierNext']/content/span"));
		nxtBtnEmail.click();
		Boolean nextEmail = nxtBtnEmail.isDisplayed();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	@DataProvider(name = "getData")	 
	  public static Object[][] getData() {	 	
		 return new Object[][] { 
			 { "ksilentwar", "dsdsdsd" }, 
			 { "ksilentwar", "muthukumaran"},
			 { "skumara", "dsdsdsd@123"},
			 { "skumaran", "muthukumaran"}};		
	  }

	@Test(dataProvider = "getData", priority=3)
	public void validate(String emailId, String password) {
		try{
		obj.email = obj.driver.findElement(By.id("identifierId"));
		obj.email.clear();
		obj.email.sendKeys(emailId);
		obj.emailNext();
		WebDriverWait wait = new WebDriverWait(obj.driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")));
		obj.pwd = obj.driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input"));
		obj.pwd.clear();
		obj.pwd.sendKeys(password);
		obj.passwordNext();
		//Assert.assertEquals(driver.getTitle(), "Sign in - Google Accounts");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		}
	
	@Test(priority = 4)
	public void verifyPasswordPage() {
		try{		
		obj.emailId();
		WebDriverWait wait = new WebDriverWait(obj.driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='passwordNext']")));
		Assert.assertEquals(obj.driver.findElement(By.xpath("//*[@id='headingText']")).getText(), "Welcome");
		System.out.println("Password page has verified");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 5)
	public void clickWithBlankPassword(){
		try{
		obj.emailId();
		obj.emailNext();
		WebDriverWait wait = new WebDriverWait(obj.driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='passwordNext']")));
	    obj.pwd = obj.driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input"));
		obj.pwd.clear();
		WebDriverWait wait1 = new WebDriverWait(obj.driver, 30);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='passwordNext']")));
		obj.passwordNext();
		WebDriverWait wait2 = new WebDriverWait(obj.driver, 30);
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='password']/div[2]/div[2]")));
		Assert.assertEquals(obj.driver.findElement(By.xpath("//*[@id='password']/div[2]/div[2]")).getText(),
				"Enter a password");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 6)
	public void verifyGmailHome(){
		try{
		obj.emailId();
		obj.emailNext();
		WebDriverWait wait = new WebDriverWait(obj.driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='passwordNext']")));
		obj.password();
		obj.passwordNext();
		WebDriverWait waiti = new WebDriverWait(obj.driver,30);
		waiti.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='WaidBe']")));
		if((obj.security().equalsIgnoreCase("My Account"))){														//Handle the security account page
			obj.clickMailIcon();
		}
		WebDriverWait wait3 = new WebDriverWait(obj.driver, 30);
		wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'COMPOSE')]")));
		String title = obj.driver.getTitle();
		if(title.contains("Gmail")){
			System.out.println("Gmail home page is displaying");}
		else{
			System.out.println("Page redirected into incorrecly");
		}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	@Test(priority = 7)
	public void browserBack(){
		try{
		obj.emailId();
		obj.emailNext();
		WebDriverWait wait = new WebDriverWait(obj.driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='passwordNext']")));
		obj.password();
		obj.passwordNext();
		WebDriverWait waiti = new WebDriverWait(obj.driver,30);
		waiti.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='Ml62gf']")));
		System.out.println("Added");
		if((obj.security().equalsIgnoreCase("My Account"))){	                      //Handle the security account page
			System.out.println("After condition");
			obj.clickMailIcon();
		}
		WebDriverWait wait3 = new WebDriverWait(obj.driver, 30);
		wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'COMPOSE')]")));
		String title1= obj.driver.getTitle();
		obj.driver.navigate().back();
		if((obj.security().equalsIgnoreCase("My Account"))){														//Handle the security account page
			obj.clickMailIcon();
		}
		WebDriverWait wait4 = new WebDriverWait(obj.driver, 30);
		wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'COMPOSE')]")));
		String title2 = obj.driver.getTitle();
		
		if(title1.contains(title2)){
			System.out.println("Account does not Log Out");}
		else{
			System.out.println("Account has been Log Out");
		}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	@AfterMethod
	public void end() throws ATUTestRecorderException {
		obj.stop();
		recorder.stop();
	}
}
