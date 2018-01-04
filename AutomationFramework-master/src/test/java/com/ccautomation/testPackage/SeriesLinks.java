package com.ccautomation.testPackage;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



import com.ccautomation.utils.WebUtils;

import static org.testng.Assert.assertTrue;

public class SeriesLinks extends WebUtils {
	
	
	@BeforeClass
	public void beforeClass()
	{
		setUp();
	}
	
	@Test
	public void Addserieslinks() {
		
		/*driver.get("http://beta1aws.cricketcountry.com/wp-admin");
		driver.findElement(By.id("user_login")).sendKeys("plaiw");
		driver.findElement(By.id("user_pass")).sendKeys("qwerasdf1234");
		driver.findElement(By.id("wp-submit")).click();
		driver.findElement(By.xpath(".//*[@id='menu-posts-series_links']/a/div[3]")).click();
		driver.findElement(By.xpath(".//*[@id='menu-posts-series_links']/ul/li[3]/a")).click();
		*/
		
		String page_source ;
		
		driver.get("http://www.india.com");
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		page_source = driver.getPageSource();
		
		System.out.println("page source"+page_source);
		
		assertTrue(page_source.contains("UA-19458284-1"));
		
		
	}
	
	

	

	@AfterClass
	public void afterClass(){
		WebUtils.tearDown();
	}
	

}
