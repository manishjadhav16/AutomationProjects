package com.ccautomation.CheckUrl;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.testng.Reporter;

public class CheckUrlCommon {

	public static void verifyURLStatus(String linkURL){
		boolean isValid = false;

		isValid = getResponseCode(linkURL);

		if (isValid) {
			Reporter.log("Valid Link:" + linkURL);
			Reporter.log("--------------");
			Reporter.log("\n");
		}

		else

		{
			Reporter.log("Broken Link ------> " + linkURL);
			Reporter.log("------------");
			Reporter.log("\n");

		}
	}
	
	
	public static boolean getResponseCode(String chkurl) {
		boolean validResponse = false;
		try {
			// Get response code of URL
			HttpResponse urlresp = new DefaultHttpClient().execute(new HttpGet(chkurl));
			int resp_Code = urlresp.getStatusLine().getStatusCode();
			Reporter.log("Response Code Is : " + resp_Code);
			if ((resp_Code == 404) || (resp_Code == 500)) {
				validResponse = false;
			} else {
				validResponse = true;
			}
		} catch (Exception e) {

		}
		return validResponse;
		
	}

	public static boolean isNotBlank(String text) {
		return text != null && text.trim().length() > 0;
	}
}
