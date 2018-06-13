package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SendFolder {
	Credential obj = new Credential();

	@BeforeMethod
	public void setUp() {
		obj.start();
	}
	
	@Test(priority = 1)
	public void checkSendMail() throws InterruptedException{
		try{
		obj.emailId();
		obj.emailNext();
		WebDriverWait wait = new WebDriverWait(obj.driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='passwordNext']")));
		obj.password();
		obj.passwordNext();
		WebDriverWait wait3 = new WebDriverWait(obj.driver, 30);
		wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'COMPOSE')]")));
		obj.sendMailLink();
		System.out.println("Uesr able to click Send Mail");
		Thread.sleep(5000);
		String pageTitle = obj.driver.getTitle();
		if(pageTitle.contains("Sent Mail")){
			System.out.println("This is Send Mail Folder");}
		else{
			System.out.println("Link Redirected to Wrong Folder");}	
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	@Test(priority = 2)
	public void nextPage(){
		try{
		obj.emailId();
		obj.emailNext();
		WebDriverWait wait = new WebDriverWait(obj.driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='passwordNext']")));
		obj.password();
		obj.passwordNext();
		obj.sendMailLink();
		System.out.println("Uesr able to click Send Mail");
		for(int i=1;i<3;i++){
			obj.sendMailNextBtn();
		Actions actions = new Actions(obj.driver);
		actions.moveToElement(obj.nxtBtn).click().perform();
		System.out.println("Page  diaplyed");
		if(obj.nxtBtn.isEnabled()){
			System.out.println("True");
		}
			else{
				System.out.println("There is no pages");
				obj.stop();
		}
		
		}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
	}
	
	@AfterMethod
	public void end() {

		obj.stop();
	}
}
