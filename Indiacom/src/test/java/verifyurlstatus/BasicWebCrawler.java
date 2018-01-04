package verifyurlstatus;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import org.w3c.dom.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;



public class BasicWebCrawler {

	@Test
	public static void readxml() {
		String url = "http://www.india.com/sitemap.xml";
		try {
			DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
			DocumentBuilder b = f.newDocumentBuilder();
			Document doc = b.parse(url);

			doc.getDocumentElement().normalize();
			System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

			// loop through each item
			NodeList items = doc.getElementsByTagName("url");
			
			Set<String> hs = new LinkedHashSet<>();
			//Set<String> hs = new LinkedHashSet<String>();
			
			for (int i = 0; i < items.getLength(); i++) {
				Node n = items.item(i);
				if (n.getNodeType() != Node.ELEMENT_NODE)
					continue;
				Element e = (Element) n;
				NodeList titleList = e.getElementsByTagName("loc");
				Element titleElem = (Element) titleList.item(0);
				Node titleNode = titleElem.getChildNodes().item(0);
				System.out.println("all the urls:  "+titleNode.getNodeValue());
				
			
				hs.add(titleNode.getNodeValue());
			
			}
			
			generateExcelSheet(hs);
		} catch (Exception e) {
			e.printStackTrace();
		}
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

		for (String titleNode : hs) {
			row = sheet.createRow(i++);
			String fillData = titleNode;

			cell = row.createCell(0);
			// Set value into cell
			cell.setCellValue(fillData);
		}

		try {
			FileOutputStream fileout = new FileOutputStream(new File("D:\\selenium-automation-project\\Indiacom\\src\\test\\resources\\Data\\indiacomsitemap.xls"));
			workbook.write(fileout);
			fileout.close();
			System.out.println("File Created");
		} catch (IOException e) {
			System.err.println("ERROR while creating file");
			e.printStackTrace();
		}

	}

	

}
