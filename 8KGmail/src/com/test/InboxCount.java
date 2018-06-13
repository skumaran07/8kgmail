package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InboxCount {
	
	Credential obj = new Credential();

	@BeforeMethod
	public void setUp() {
		obj.start();		
	}
	
	@Test(priority = 1)
	public void checkPrimaryTab(){
		try{
		obj.emailId();
		obj.emailNext();
		WebDriverWait wait = new WebDriverWait(obj.driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='passwordNext']")));
		obj.password();
		obj.passwordNext();
		WebDriverWait wait3 = new WebDriverWait(obj.driver, 30);
		wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'COMPOSE')]")));		
		WebElement pTab2 = obj.driver.findElement(By.xpath("//*[@id=':2']/div/div/div[3]/table/tbody/tr[1]/td[1]/div[1]"));  
		boolean val2 = pTab2.isEnabled();                                                         
		System.out.println(val2);
		if(val2){
			System.out.println("Tab2 is enabled by default ");} 
			else{
				System.out.println(" Tab2 not enabled");
			}	
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	@Test(priority = 2)
	public void VerifyinboxCountPresented(){
		try{
		obj.emailId();
		obj.emailNext();
		WebDriverWait wait = new WebDriverWait(obj.driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='passwordNext']")));
		obj.password();
		obj.passwordNext();
		WebDriverWait wait4 = new WebDriverWait(obj.driver, 30);
		wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'COMPOSE')]")));
		WebElement countText = obj.driver.findElement(By.xpath("//*[@class='J-J5-Ji amH J-JN-I']/span/span[2]"));
		boolean display = countText.isDisplayed();
		System.out.println(display);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	@Test(priority = 3)
	public void getInboxCount(){
		try{
		obj.emailId();
		obj.emailNext();
		WebDriverWait wait = new WebDriverWait(obj.driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='passwordNext']")));
		obj.password();
		obj.passwordNext();
		WebDriverWait wait4 = new WebDriverWait(obj.driver, 30);
		wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'COMPOSE')]")));  
		WebElement countText = obj.driver.findElement((By.xpath("//*[@class='J-J5-Ji amH J-JN-I']/span/span[2]")));
		String count = countText.getText();
		System.out.println(count);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	

	@AfterMethod
	public void end() {

		obj.stop();
	}
}
