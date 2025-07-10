package DDT_Pratice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsertingLinkIntoExcel {

	public static void main(String[] args) throws Throwable {

		// Step:- path Connection
//		FileInputStream fis = new FileInputStream("C:\\Users\\Shobha\\Documents\\ExcelData7.xlsx");
		FileInputStream fis = new FileInputStream("./src/test/resources/ExcelData7.xlsx");

		// step2:- keeps the workbook/Excel file in read mode
		Workbook book = WorkbookFactory.create(fis);

		// step3:- Navigates into mentioned sheetname
		Sheet sheet = book.getSheet("Sheet1");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");

		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));

		for (int i = 0; i < allLinks.size(); i++) {
			Row row = sheet.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(allLinks.get(i).getAttribute("href"));
		}

		FileOutputStream fos = new FileOutputStream("./src/test/resources/ExcelData7.xlsx");
		book.write(fos);
		book.close();
	}

}
