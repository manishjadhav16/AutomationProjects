package com.ccautomation.gmail.CreateLabel;

import org.openqa.selenium.By;

import com.ccautomation.gmail.Login.LoginCommon;
import com.ccautomation.utils.WebUtils;

public class CreateLabelCommon extends WebUtils {
	
	public static void selectmail() throws InterruptedException{
		
		LoginCommon.login();
		driver.findElement(By.xpath(".//*[@id=':3a']/div")).click();
		driver.findElement(By.id(":33")).click();
		driver.findElement(By.id(":lt")).click();
		
	}
	
	

}
