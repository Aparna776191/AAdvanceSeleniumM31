package DDT_Pratice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertDataIntoExcelFile {

	public static void main(String[] args) throws Throwable {
		
		//Step:- path Connection
//		FileInputStream fis = new FileInputStream("C:\\Users\\Shobha\\Documents\\ExcelData7.xlsx");
		FileInputStream fis = new FileInputStream("./src/test/resources/ExcelData7.xlsx");
		
		//step2:- keeps the workbook/Excel file in read mode
		Workbook book = WorkbookFactory.create(fis);
		
		//step3:- Navigates into mentioned sheetname
		Sheet sheet = book.getSheet("Sheet1");
		
		Row row = sheet.createRow(5);
		
		Cell cell = row.createCell(5);
		
		cell.setCellValue("Qspiders");
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/ExcelData7.xlsx");
		book.write(fos);
		book.close();
	}

}
