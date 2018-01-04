package com.ccautomation.gmail.Compose;

import org.openqa.selenium.By;

import com.ccautomation.utils.WebUtils;

public class ComposeCommon extends WebUtils {
	
	
	public static void composeEmail(String toEmailid, String subject,String body) throws InterruptedException{
		
		driver.findElement(By.id(":it")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//td//img[2]")).click();
        Thread.sleep(10000);
        driver.findElement(By.className("vO")).sendKeys(toEmailid);
        driver.findElement(By.className("aoT")).sendKeys(subject);
        Thread.sleep(10000);
        driver.findElement(By.xpath("//div[text()='Send']")).click();
	}

}
