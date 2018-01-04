package com.ccautomation.testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ccautomation.utils.WebUtils;



public class Gmail extends WebUtils {
	
	//WebDriver w = new FirefoxDriver();
	
	
	
	@BeforeClass
	public void beforeClass()
	{
		setUp();
	}
	
	
    @Test
	public void gmaillogin() throws InterruptedException {
    	
    	driver.manage().window().maximize();
        String appurl = "https://www.gmail.com/intl/en/mail/help/about.html";
        driver.get(appurl);
        driver.findElement(By.id("gmail-sign-in")).click();
        driver.findElement(By.id("Email")).sendKeys("mayur.diman@gmail.com");
        driver.findElement(By.id("next")).click();
        driver.findElement(By.id("Passwd")).sendKeys("manish16");
        driver.findElement(By.id("signIn")).click();
        Thread.sleep(10000);
       //driver.findElement(By.id(":it")).click();
        //driver.switchTo().frame(driver.findElement(By.xpath(".//iframe[@title='Fill Quote']")));
      //  Thread.sleep(10000);
       // driver.findElement(By.xpath("//td//img[2]")).click();
       // Thread.sleep(10000);
      //  driver.findElement(By.className("vO")).sendKeys("manishrulz16@gmail.com");
        //driver.findElement(By.id(":o1")).click();
      //  driver.findElement(By.className("aoT")).sendKeys("test mail");
      //  Thread.sleep(10000);
      //  driver.findElement(By.xpath("//div[text()='Send']")).click();
       // driver.findElement(By.xpath(".//*[@id=':lo']")).sendKeys("test");
       // driver.switchTo().frame(driver.findElement(By.xpath(".//*[@id=':lo']")));
        //WebElement printbody = driver.switchTo().activeElement();
       // printbody.sendKeys("test mail");
       // driver.switchTo().defaultContent();
       // driver.findElement(By.xpath("//div[text()='Send']")).click();	
        driver.findElement(By.xpath(".//*[@id='gb']/div[1]/div[1]/div[2]/div[4]/div[1]/a/span")).click();
	}
	
	

	

	@AfterClass
	public void afterClass(){
		//driver.close();
	}

}
