package com.indiacom.googletrends;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.indiacom.utils.WebUtils;

public class GoogleTrends extends WebUtils {

	@BeforeClass
	public void beforeclass() {
		setUp("Chrome");
	}

	@Test
	public void getallgoogletrends() {

		String url = "https://trends.google.com/trends/home/h/IN";
		driver.get(url);
		
		//for() {
		String Alllinks = driver
				.findElement(By.xpath("//div[@class='trending-story-wrapper']/a[@class='trending-story']"))
				.getAttribute("href");
		String Alltitles = driver
				.findElement(By.xpath(
						"//div[@class='trending-story-wrapper']/a[@class='trending-story']/div[@class='title']/span"))
				.getText();

		System.out.println("Älllinks:   " + Alllinks);
		System.out.println("Alltitles:   " + Alltitles);
	}
	//}

	@AfterClass
	public void afterClass() {
		WebUtils.tearDown();
	}
}
