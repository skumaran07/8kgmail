package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Credential {

	WebDriver driver;
	WebElement email;
	WebElement nxtBtnEmail;
	WebElement pwd;
	WebElement nxtBtnPassword;
	WebElement nxtBtn;
	WebElement profileIcon;
	WebElement signOutBtn;
	By profileIconPath;
	WebElement securityPage;
	WebDriverWait waiti;
	public void start(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://accounts.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void emailId(){
		email = driver.findElement(By.id("identifierId"));
		email.sendKeys("ksilentwar@gmail.com");
		}
	
	public void password(){
		pwd = driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input"));
		pwd.sendKeys("muthukumaran");
	}
	
	public void emailNext(){
		nxtBtnEmail = driver.findElement(By.xpath("//*[@id='identifierNext']/content/span"));
		nxtBtnEmail.click();
	}
	
	public void passwordNext(){
		nxtBtnPassword = driver.findElement(By.xpath("//*[@id='passwordNext']"));
		nxtBtnPassword.click();
	}
	
	public void sendMailLink(){
		WebElement sendMail = driver.findElement(By.xpath("//*[contains(text(),'Sent Mail')]"));
		sendMail.click();
	}
	
	public void sendMailNextBtn(){
		nxtBtn = driver.findElement(By.xpath("//*[contains(@class, 'T-I J-J5-Ji amD T-I-awG T-I-ax7 T-I-Js-Gs L3')]"));
	}
	
	public void profileIcon(){
		By profileIconPath = By.xpath("//*[@id='gb']/div[2]/div[1]/div[2]/div[5]/div[1]/a/span");
		profileIcon = driver.findElement(profileIconPath);
		
	}
	
	public void signOut(){
		signOutBtn = driver.findElement(By.xpath("//*[@id='gb_71']"));
		signOutBtn.click();
	}
	
	public void stop(){
		driver.close();
	}
	
	public String security(){
		String securePage = driver.getTitle();
		return securePage;
		
	}
	
	public void clickMailIcon(){
		waiti = new WebDriverWait(driver,30);
		waiti.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='Ml62gf']")));
		securityPage = driver.findElement(By.xpath("//*[@class='WaidBe']"));
		securityPage.click();		
	}
	
}
