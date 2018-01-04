package com.ccautomation.gmail.Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ccautomation.utils.WebUtils;

public class LoginTest extends WebUtils{
	
	
	@BeforeMethod
	public void beforeMethod()
	{
		setUp();
	}
	
	  @Test
		public void gmaillogin() throws InterruptedException {
		  
		  LoginCommon.login();
		 Reporter.log("Logged in successfully");
    
	  }
	  
	  @AfterMethod
		public void afterMethod(){
		  LoginCommon.logout();
			driver.quit();
		}

}
