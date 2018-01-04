package com.indiacom.verifyurls;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.indiacom.utils.WebUtils;

public class GetAllLinks extends WebUtils {

	@BeforeClass
	public void beforeClass() {
		setUp("Chrome");
	}

	@Test
	public void checkurl() {
		String url = "http://www.india.com";
		driver.get(url);
		// pause(10000);
		CheckUrlCommon.verifyURLStatus(url);

		List<WebElement> listOfURLs = getAllLinks();
		// System.out.println("Link url are"+listOfURLs);
		Set<String> hs = new LinkedHashSet<String>();
		try {
		for (WebElement urlElement : listOfURLs) {
			String linkURL = urlElement.getAttribute("href");
			System.out.println("Link url are   " + linkURL);
			hs.add(linkURL);
			
		}
		
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			
			System.err.println("ERROR ");
			ex.printStackTrace();
		}

		generateExcelSheet(hs);
	}

	@AfterClass
	public void afterClass() {
		WebUtils.tearDown();
	}
	

	private void generateExcelSheet(Set<String> hs) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Data");

		System.out.println("hs is: " + hs);
		XSSFCell cell;
		XSSFRow row;
		int i = 0;
		row = sheet.createRow(i++);
		cell = row.createCell(0);
		// Set value into cell
		cell.setCellValue("Links");

		for (String link : hs) {
			row = sheet.createRow(i++);
			String fillData = link;

			cell = row.createCell(0);
			// Set value into cell
			cell.setCellValue(fillData);
		}

		try {
			FileOutputStream fileout = new FileOutputStream(new File("D:\\selenium-automation-project\\Indiacom\\src\\test\\resources\\Data\\urllist.xls"));
			workbook.write(fileout);
			fileout.close();
			System.out.println("File Created");
		} catch (IOException e) {
			System.err.println("ERROR while creating file");
			e.printStackTrace();
		}

	}

}
