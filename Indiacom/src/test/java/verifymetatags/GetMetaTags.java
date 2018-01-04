package verifymetatags;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.fest.swing.annotation.GUITest;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.indiacom.utils.ExcelManager;
import com.indiacom.utils.WebUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@GUITest
public class GetMetaTags { // extends WebUtils {

	/*
	 * @BeforeClass public void beforeClass() { // setUp("Chrome"); }
	 */
	/*
	 * @Test(dataProvider = "pageMetaProvider") public void GetMetatags(String url)
	 * {
	 * 
	 * WebUtils.navigateToUrl(url); try { Thread.sleep(30000); } catch
	 * (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * String Pagetitle =
	 * driver.findElement(By.xpath("//meta[@name='title']@content")).getText();
	 * String Pagedescription =
	 * driver.findElement(By.xpath("//meta[@name='description']@content")).getText()
	 * ; String PageKeywords =
	 * driver.findElement(By.xpath("//meta[@name='keywords']@content")).getText();
	 * 
	 * }
	 * 
	 * @DataProvider(name = "pageMetaProvider") public Object[][] pageMetaProvider()
	 * throws IOException {
	 * 
	 * InputStream is = getClass().getResourceAsStream(
	 * "D:\\selenium-automation-project\\Indiacom\\src\\test\\resources\\Data\\urllist.xlsx"
	 * ); List<HashMap<String, String>> list = ExcelManager.getTestDataFromExcel(is,
	 * "Sheet1");
	 * 
	 * Object[][] input = new Object[list.size()][1];
	 * 
	 * int i = 0; for (Map<String, String> map : list) { String url = (String)
	 * map.get("Links"); // Document doc = Jsoup.connect(page).get(); // Elements
	 * PageTitle = doc.select("meta[@name='title']"); //
	 * System.out.println("Meta title"+PageTitle); input[i][0] = url; i++; }
	 * 
	 * return input; }
	 */

	/*
	 * @Test public void GetMetatags() throws IOException, BiffException {
	 * 
	 * String FilePath =
	 * "D:\\selenium-automation-project\\Indiacom\\src\\test\\resources\\Data\\testlink.xls";
	 * FileInputStream fs = new FileInputStream(FilePath); //InputStream is =
	 * getClass().getResourceAsStream(
	 * "D:\\selenium-automation-project\\Indiacom\\src\\test\\resources\\Data\\urllist.xls"
	 * ); Workbook wb = Workbook.getWorkbook(fs);
	 * 
	 * List<HashMap<String, String>> list = ExcelManager.getTestDataFromExcel(fs,
	 * "Sheet1");
	 * 
	 * Object[][] input = new Object[list.size()][1];
	 * 
	 * int i = 0; for (Map<String, String> map : list) { String url = (String)
	 * map.get("Links");
	 * 
	 * Document document; try { // Get Document object after parsing the html from
	 * given url. document = Jsoup.connect(url).get();
	 * 
	 * // Get description from document object. String description =
	 * document.select("meta[name=description]").get(0).attr("content"); // Print
	 * description. System.out.println("Meta Description: " + description);
	 * 
	 * // Get keywords from document object. String keywords =
	 * document.select("meta[name=keywords]").first().attr("content"); // Print
	 * keywords. System.out.println("Meta Keyword : " + keywords);
	 * 
	 * } catch (IOException e) { e.printStackTrace(); }
	 * 
	 * i++; }
	 * 
	 * //return input;
	 * 
	 * }
	 */

	/*
	 * public static void main(String[] args) throws IOException {
	 * 
	 * 
	 * 
	 * Document document; try { //Get Document object after parsing the html from
	 * given url. document = Jsoup.connect("http://www.india.com").get();
	 * 
	 * //Get description from document object. String description =
	 * document.select("meta[name=description]").get(0).attr("content"); //Print
	 * description. System.out.println("Meta Description: " + description);
	 * 
	 * //Get keywords from document object. String keywords =
	 * document.select("meta[name=keywords]").first().attr("content"); //Print
	 * keywords. System.out.println("Meta Keyword : " + keywords);
	 * 
	 * } catch (IOException e) { e.printStackTrace(); } }
	 */

	/*
	 * @AfterClass public void afterClass() { WebUtils.tearDown(); }
	 */

	@Test(dataProvider = "pageMetaDataProvider")
	public void GetMetatags(String url) throws IOException {

		// WebUtils.navigateToUrl(url);
		Document document;
		document = Jsoup.connect(url).get();
		String description = document.select("meta[name=description]").get(0).attr("content");
		System.out.println("Meta Description: " + description);
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// String actualTitle = WebUtils.getPageTitle();
		// Assert.assertEquals(actualTitle, title);
		// Reporter.log("ActualPage Title : "+ actualTitle);
		Reporter.log(url + ": Success !!");

	}

	/*
	 * @DataProvider(name="pageMetaDataProvider") public Object [][]
	 * pageMetaDataProvider(){
	 * 
	 * InputStream is = getClass().getResourceAsStream(
	 * "D:\\selenium-automation-project\\Indiacom\\src\\test\\resources\\Data\\urllist.xls"
	 * ); List<HashMap<String, String>> list = ExcelManager.getTestDataFromExcel(is,
	 * "Sheet1");
	 * 
	 * Object [][] input = new Object[list.size()][5];
	 * 
	 * int i=0; for(Map<String, String> map: list){ String url = (String)
	 * map.get("Link"); String title = (String) map.get("Page Title"); String
	 * description = (String) map.get("Page Description"); String keywords =
	 * (String) map.get("Page Keywords"); String url = (String) map.get("Page URL");
	 * 
	 * input[i][0] = url; input[i][1] = title; input[i][2] = description;
	 * input[i][3] = keywords; input[i][4] = url; i++; }
	 * 
	 * return input; }
	 */

	public static void main(String[] args) throws IOException {
		String excelFilePath = "D:\\selenium-automation-project\\Indiacom\\src\\test\\resources\\Data\\urllist.xls";
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = firstSheet.iterator();
		
		int row = 1;
		int lastRowNum = firstSheet.getLastRowNum();
		
		while (row <= lastRowNum) {
			
			//Row getSchool = firstSheet.getRow(1);
			Row nextRow = firstSheet.getRow(row++); //iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();

				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					System.out.print(cell.getStringCellValue());
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					System.out.print(cell.getBooleanCellValue());
					break;
				case Cell.CELL_TYPE_NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;
				}
				// System.out.print(" - ");
			}
			System.out.println();
		}

		// workbook.close();
		inputStream.close();
	}

}
