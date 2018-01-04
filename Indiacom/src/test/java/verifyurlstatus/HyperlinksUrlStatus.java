package verifyurlstatus;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jsoup.Connection.Response;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.testng.annotations.Test;

public class HyperlinksUrlStatus {

	@Test
	public static void getresponsestatus() throws IOException {

		Document doc = Jsoup.connect(
				"http://www.india.com/news/india/triple-talaq-bill-to-be-tabled-in-lok-sabha-today-amid-oppositions-protest-against-criminalisation-of-instant-divorce-2805206/")
				.get();
		Elements els = doc.getElementsByClass("articleBody");

		// System.out.println("class name found" + els);
		Elements inputElements = els.select("a[href]");
		Set<String> hs = new LinkedHashSet<>();
		try {
			for (Element inputElement : inputElements) {

				String key = inputElement.attr("href");

				System.out.println("URLS: " + key);
				hs.add(key);
				
			//	key.statusCode();

			}
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {

			System.err.println("ERROR ");
			ex.printStackTrace();
		}

		generateExcelSheet(hs);

	}

	private static void generateExcelSheet(Set<String> hs) {
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

		for (String key : hs) {
			row = sheet.createRow(i++);
			String fillData = key;

			cell = row.createCell(0);
			// Set value into cell
			cell.setCellValue(fillData);
		}

		try {
			FileOutputStream fileout = new FileOutputStream(new File(
					"D:\\selenium-automation-project\\Indiacom\\src\\test\\resources\\Data\\hyperlinktest.xls"));
			workbook.write(fileout);
			fileout.close();
			System.out.println("File Created");
		} catch (IOException e) {
			System.err.println("ERROR while creating file");
			e.printStackTrace();
		}

	}

}
