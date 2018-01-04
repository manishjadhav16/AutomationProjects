package com.ccautomation.testPackage;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ccautomation.utils.WebUtils;

public class ClickLink extends WebUtils {

	@BeforeClass
	public void beforeClass() {
		setUp();
	}

	@Test
	public void linkstatus() {
		String url = "http://www.cricketcountry.com/news/mohammad-azharuddins-biopic-staring-emraan-hashmis-first-look-revealed-322500";
		driver.get(url);
		//driver.findElement(By.xpath(".//*[@id='menu-item-437751']/a")).click();
		boolean isValid = false;
		isValid = getResponseCode(url);
		if (isValid) {
			System.out.println("Valid Link:" + url);
		} else {
			System.out.println("Broken Link ------> " + url);
		}
	}

	public static boolean getResponseCode(String chkurl) {
		boolean validResponse = false;
		try {
			// Get response code of URL
			HttpResponse urlresp = new DefaultHttpClient().execute(new HttpGet(
					chkurl));
			int resp_Code = urlresp.getStatusLine().getStatusCode();
			System.out.println("Response Code Is : " + resp_Code);
			if ((resp_Code == 404) || (resp_Code == 500)) {
				validResponse = false;
			} else {
				validResponse = true;
			}
		} catch (Exception e) {

		}
		return validResponse;

	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
