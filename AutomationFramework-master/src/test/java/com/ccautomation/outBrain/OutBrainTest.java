package com.ccautomation.outBrain;

import static org.testng.Assert.assertTrue;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.fest.swing.annotation.GUITest;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ccautomation.utils.WebUtils;

@GUITest
public class OutBrainTest extends WebUtils{
	
	@BeforeClass
	public void beforeClass() {
		setUp();
		driver.get("http://www.india.com/stream/");
	}
	
	@Test(priority=3)
	public void checkOutBrainWidgetOnStreamCat() throws Exception {
	
		driver.get("http://www.india.com/stream/");
		pause(10000);
		//String page_source ;
//		WebElement ele = driver.findElement(By.id("mostView"));   
//		  try
//		  {
//		  File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		  BufferedImage  fullImg = ImageIO.read(screenshot);
//		  //Get the location of element on the page
//		  Point point = ele.getLocation();
//		  //Get width and height of the element
//		  int eleWidth = ele.getSize().getWidth();
//		  int eleHeight = ele.getSize().getHeight();
//		  //Crop the entire page screenshot to get only element screenshot
//		  BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
//		  ImageIO.write(eleScreenshot, "png", screenshot);
//		  //Copy the element screenshot to disk
//		  FileUtils.copyFile(screenshot, new File("D://stream.png"));
//		  }
//		  catch(Exception e)
//		  {
//		   e.printStackTrace();
//		  }
		
		WebElement element = driver.findElement(By.xpath(".//*[@id='outbrain_widget_0'][@data-widget-id='AR_7']"));
		
		if(element.isDisplayed()){
			
			getscreenshot("StreamCat",element);
			System.out.println("Element is Present");
			}else{
			System.out.println("Element is Absent");
			}
		
	}
	
//	@Test(priority=2)
//	public void checkOutBrainWidgetOnGalleryDetails() throws Exception {
//	
//		String page_source ;
//		
//		driver.get("http://www.india.com/gallery/14-pictures-of-syrian-refugees-fleeing-hungarian-police-that-tell-you-the-story-of-the-syrian-crisis-551105/");
//		pause(10000);
//		driver.manage().window().maximize();
//		WebElement ele = driver.findElement(By.id("outbrain_widget_0"));   
//		  try
//		  {
//		  File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		  BufferedImage  fullImg = ImageIO.read(screenshot);
//		  //Get the location of element on the page
//		  Point point = ele.getLocation();
//		  //Get width and height of the element
//		  int eleWidth = ele.getSize().getWidth();
//		  int eleHeight = ele.getSize().getHeight();
//		  //Crop the entire page screenshot to get only element screenshot
//		  BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
//		  ImageIO.write(eleScreenshot, "png", screenshot);
//		  //Copy the element screenshot to disk
//		  FileUtils.copyFile(screenshot, new File("D://screenshots/gallery.png"));
//		  }
//		  catch(Exception e)
//		  {
//		   e.printStackTrace();
//		  }
//			
//		if(driver.findElement(By.xpath(".//*[@id='outbrain_widget_0'][@data-widget-id='AR_6']")).isDisplayed()){
//			System.out.println("Element is Present");
//			}else{
//			System.out.println("Element is Absent");
//			}
//		
//		
//	}
//	
	//@Test(priority=2)
	public void checkOutBrainWidgetOnArticleDetails() throws Exception {
//	
//		String page_source ;
//		
		driver.get("http://www.india.com/news/india/dengue-death-delhi-government-orders-magisterial-probe-in-the-case-avinash-rout-550446/");
		pause(10000);
//		driver.manage().window().maximize();
//		WebElement ele = driver.findElement(By.id("outbrain_widget_0"));   
//		  try
//		  {
//		  File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		  BufferedImage  fullImg = ImageIO.read(screenshot);
//		  //Get the location of element on the page
//		  Point point = ele.getLocation();
//		  //Get width and height of the element
//		  int eleWidth = ele.getSize().getWidth();
//		  int eleHeight = ele.getSize().getHeight();
//		  //Crop the entire page screenshot to get only element screenshot
//		  BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
//		  ImageIO.write(eleScreenshot, "png", screenshot);
//		  //Copy the element screenshot to disk
//		  FileUtils.copyFile(screenshot, new File("D://screenshots/article.png"));
//		  }
//		  catch(Exception e)
//		  {
//		   e.printStackTrace();
//		  }
//		
//		if(driver.findElement(By.xpath(".//*[@id='outbrain_widget_0'][@data-widget-id='AR_5']")).isDisplayed()){
//			System.out.println("Element is Present");
//			}else{
//			System.out.println("Element is Absent");
//			}
//		
//		
	}

	//@Test(priority=1)
public void checkOutBrainWidgetOnCategory() throws Exception {
//	
//		String page_source ;
//		
		driver.get("http://www.india.com/showbiz/");
		pause(10000);
//		driver.manage().window().maximize();
//		WebElement ele = driver.findElement(By.id("outbrain_widget_0"));   
//		  try
//		  {
//		  File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		  BufferedImage  fullImg = ImageIO.read(screenshot);
//		  //Get the location of element on the page
//		  Point point = ele.getLocation();
//		  //Get width and height of the element
//		  int eleWidth = ele.getSize().getWidth();
//		  int eleHeight = ele.getSize().getHeight();
//		  //Crop the entire page screenshot to get only element screenshot
//		  BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
//		  ImageIO.write(eleScreenshot, "png", screenshot);
//		  //Copy the element screenshot to disk
//		  FileUtils.copyFile(screenshot, new File("D://screenshots/category.png"));
//		  }
//		  catch(Exception e)
//		  {
//		   e.printStackTrace();
//		  }
		
		if(driver.findElement(By.xpath(".//*[@id='outbrain_widget_0'][@data-widget-id='AR_7']")).isDisplayed()){
			System.out.println("Element is Present");
			}else{
			System.out.println("Element is Absent");
			}
		
		
		
	}
	
	@AfterClass
	public void afterClass(){
		
	driver.quit();	
	}
	
	

}
