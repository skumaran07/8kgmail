package com.test;

import org.testng.annotations.Test;

public class NewTest {
	 public WebDriver driver = new FirefoxDriver();
     String appUrl = &quot;https://accounts.google.com&quot;;

@Test
public void gmailLogin() {
           // launch the firefox browser and open the application url
            driver.get(&quot;https://gmail.com&quot;);
           
//maximize the browser window
            driver.manage().window().maximize();
           
//declare and initialize the variable to store the expected title of the webpage.
            String expectedTitle = &quot; Sign in - Google Accounts &quot;;
           
//fetch the title of the web page and save it into a string variable
            String actualTitle = driver.getTitle();
            Assert.assertEquals(expectedTitle,actualTitle);
           
//enter a valid username in the email textbox
            WebElement username = driver.findElement(By.id(&quot;Email&quot;));
            username.clear();
            username.sendKeys(&quot;TestSelenium&quot;);

//enter a valid password in the password textbox
            WebElement password = driver.findElement(By.id(&quot;Passwd&quot;));
            password.clear();
            password.sendKeys(&quot;password123&quot;);
           
//click on the Sign in button
            WebElement SignInButton = driver.findElement(By.id(&quot;signIn&quot;));
            SignInButton.click();
           
//close the web browser
            driver.close();
}
}
