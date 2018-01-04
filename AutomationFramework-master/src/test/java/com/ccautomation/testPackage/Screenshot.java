package com.ccautomation.testPackage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import com.ccautomation.utils.WebUtils;

public class Screenshot extends WebUtils {

	 @BeforeTest
	 public void beforeTest() {
		 
		// setUp();
		WebDriver driver = new FirefoxDriver();
		
		ProfilesIni allProfiles = new ProfilesIni();
		//FirefoxProfile profile = new FirefoxProfile();
		//FirefoxProfile profile = allProfiles.getProfile("Mozilla_Firefox_37.0");
		//profile.setPreference("browser.startup.homepage",
		//		"http://www.india.com/stream/");
		//driver = new FirefoxDriver(profile);
	  driver.get("http://www.india.com/stream/");
	 }
	 
	 @Test
	 public void captureScreenshot() throws InterruptedException{
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 for (int second = 0;; second++) {
		         if(second >=60){
		             break;
		         }
		             jse.executeScript("window.scrollBy(0,800)", ""); //y value '800' can be altered
		             Thread.sleep(3000);
		 }
		
		  WebElement ele = driver.findElement(By.id("mostView"));   
		  try
		  {
		  File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  BufferedImage  fullImg = ImageIO.read(screenshot);
		  //Get the location of element on the page
		  Point point = ele.getLocation();
		  //Get width and height of the element
		  int eleWidth = ele.getSize().getWidth();
		  int eleHeight = ele.getSize().getHeight();
		  //Crop the entire page screenshot to get only element screenshot
		  BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
		  ImageIO.write(eleScreenshot, "png", screenshot);
		  //Copy the element screenshot to disk
		  FileUtils.copyFile(screenshot, new File("D://MSlider.png"));
		  }
		  catch(Exception e)
		  {
		   e.printStackTrace();
		  }
	 }
	 

	 
	 @AfterTest
	 public void afterTest(){
		 
		 driver.quit();
	 }
}
