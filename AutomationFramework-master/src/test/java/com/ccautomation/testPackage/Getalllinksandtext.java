package com.ccautomation.testPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ccautomation.utils.WebUtils;
import com.sun.tools.javac.util.List;

public class Getalllinksandtext extends WebUtils {
	
	
	@BeforeClass
	public void beforeClass() {
		setUp();
	}


	
	@Test
	public void Getalllinksandtext(String page, String url) {
	// WebDriver reference but Firefox object
	WebDriver driver = new FirefoxDriver();
	//Maximize browser window 
	driver.manage().window().maximize();
	//Navigate to page to get link urls abd texts
	driver.navigate().to("http://www.india.com");
	//Set  timeout
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	// Store all link tag imagetags array  
	List<WebElement> urltags = (List<WebElement>) driver.findElements(By.tagName("a"));
	for (WebElement url1 : urltags) {
	// Fiter only valid link
	if ((url1.getAttribute("href").trim().length() != 0) && (url1.getText().trim().length() != 0)) {
	//print page link
	System.out.println(url1.getText().trim() + " --> " + url1.getAttribute("href").trim());

	 }
	}
	//close firefox browser    
	driver.quit();
	    }


@AfterClass
public void afterClass() {
	WebUtils.tearDown();
}



}
