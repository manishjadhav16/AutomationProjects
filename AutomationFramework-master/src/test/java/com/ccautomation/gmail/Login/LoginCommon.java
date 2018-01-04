package com.ccautomation.gmail.Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.ccautomation.utils.WebUtils;

public class LoginCommon extends WebUtils {
	
	public static void login() throws InterruptedException{
	String appurl = "https://www.gmail.com/intl/en/mail/help/about.html";
    driver.get(appurl);
    driver.findElement(LoginObjects.gmail).click();
    driver.findElement(By.id("Email")).sendKeys("mayur.diman@gmail.com");
    driver.findElement(By.id("next")).click();
    driver.findElement(By.id("Passwd")).sendKeys("manish16");
    driver.findElement(By.id("signIn")).click();
    Thread.sleep(10000);
    
	}

	public static void logout(){

		driver.findElement(By.className("gb_Qa gb_Lb gb_Od gb_R")).click();
		driver.findElement(By.id("gb_71")).click();
		
	}
}
