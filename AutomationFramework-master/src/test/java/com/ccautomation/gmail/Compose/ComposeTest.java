package com.ccautomation.gmail.Compose;

import org.junit.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ccautomation.gmail.Login.LoginCommon;
import com.ccautomation.utils.WebUtils;

public class ComposeTest extends WebUtils {
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException
	{
		setUp();
		LoginCommon.login();
	}
	
	@Test
	public void composeWithOutBody() throws InterruptedException{
		ComposeCommon.composeEmail("manishrulz16@gmail.com", "test email", "ZDFAS");
			}
	
//	@Test
//	public void composeWithBody() throws InterruptedException{
//		
//		ComposeCommon.composeEmail("manishrulz16@gmail.com", "test email", "");
//		
//	}
	
	
	@AfterMethod
	public void afterMethod()
	{
		//LoginCommon.logout();
		driver.quit();
	}
	

}
