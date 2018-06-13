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

public class SignOut {
	
	Credential obj = new Credential();

	@BeforeMethod
	public void setUp() {

		obj.start();
	}
	
	@Test
	public void signOut(){
		try{
		obj.emailId();
		obj.emailNext();
		WebDriverWait wait = new WebDriverWait(obj.driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='passwordNext']"))); 
		obj.password();  
		obj.passwordNext();
		WebDriverWait wait3=new WebDriverWait(obj.driver,30);   
		wait3.until(ExpectedConditions.visibilityOfElementLocated(obj.profileIconPath));
		System.out.println("Profile icon is displaying on top right corner");
		obj.profileIcon();
		obj.profileIcon.click();
		WebDriverWait wait2=new WebDriverWait(obj.driver,30);  
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='gb_71']")));
		obj.signOut(); 
		System.out.println("Account has been log out");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	@AfterMethod
	public void end() {

		obj.stop();
	}

}
