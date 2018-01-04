package com.ccautomation.gmail.CreateLabel;

import org.junit.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ccautomation.gmail.Login.LoginCommon;
import com.ccautomation.utils.WebUtils;

public class CreateLabelTest extends WebUtils{
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException{
		
		setUp();
		LoginCommon.login();
	}
	
	@Test
	public void selectLabel() throws InterruptedException{
		
		CreateLabelCommon.selectmail();
	}
	
	@AfterMethod
	public void afterMethod() {
		
		LoginCommon.logout();
		driver.quit();
	}

}
