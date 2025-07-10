package DDT_Pratice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingDataFromExcelFile {

	public static void main(String[] args) throws Throwable {
		
		//Step:- path Connection
//		FileInputStream fis = new FileInputStream("C:\\Users\\Shobha\\Documents\\ExcelData7.xlsx");
		FileInputStream fis = new FileInputStream("./src/test/resources/ExcelData7.xlsx");
		
		//step2:- keeps the workbook/Excel file in read mode
		Workbook book = WorkbookFactory.create(fis);
		
		//step3:- Navigates into mentioned sheetname
		Sheet sheet = book.getSheet("Sheet1");
		
		//step 4:- Navigates into mentioned rowNum
		Row row = sheet.getRow(2);
		
		//step 5:- Navigates into mentioned cellNum
		Cell cell = row.getCell(1);

		//step6:- fetch the cell value
		String excelData = cell.getStringCellValue();
		System.out.println(excelData);
	}

}
