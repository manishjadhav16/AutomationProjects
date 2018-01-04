package com.ccautomation.CheckUrl;

import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ccautomation.utils.ExcelManager;
import com.ccautomation.utils.WebUtils;

public class CheckUrlTest extends WebUtils {

	@BeforeClass
	public void beforeClass() {
		setUp();
	}

	@Test(dataProvider = "checkurl")
	public void checkurl(String page, String url) {

		if (!CheckUrlCommon.isNotBlank(url)) {
			return;
		}
		
		WebUtils.navigateToUrl(url);
		pause(10000);
		Reporter.log(page+": Success !!");
		CheckUrlCommon.verifyURLStatus(url);
		
		List<WebElement> listOfURLs = getAllLinks();
		
		for(WebElement urlElement : listOfURLs){
			String linkURL = urlElement.getAttribute("href");
			Reporter.log("Link URL : "+linkURL);
			CheckUrlCommon.verifyURLStatus(linkURL);
		}
		

	}
	
	@DataProvider(name = "checkurl")
	public Object[][] checkurl() {

		InputStream is = getClass().getResourceAsStream("/Data/checkurl.xls");
		List<HashMap<String, String>> list = ExcelManager.getTestDataFromExcel(
				is, "Sheet1");

		Object[][] input = new Object[list.size()][2];

		int i = 0;
		for (Map<String, String> map : list) {
			String page = (String) map.get("Page name");
			String url = (String) map.get("Page URL");

			input[i][0] = page;
			input[i][1] = url;
			i++;
			
		}

		return input;
		
	}

	@AfterClass
	public void afterClass() {
		WebUtils.tearDown();
	}

}
