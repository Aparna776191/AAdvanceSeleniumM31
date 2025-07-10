package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {

	/**
	 * This method is used to read data from excel file
	 * @param SheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 * @author Shobha
	 */
	public String getExcelData(String SheetName,int rowNum,int cellNum) throws Throwable {
	
		FileInputStream fes = new FileInputStream("./src/test/resources/ExcelData7.xlsx");

		// step2:- keeps the workbook/Excel file in read mode
		Workbook book = WorkbookFactory.create(fes);

		// step3:- Navigates into mentioned sheetname
		Sheet sheet = book.getSheet(SheetName);

		// step 4:- Navigates into mentioned rowNum
		Row row = sheet.getRow(rowNum);

		// step 5:- Navigates into mentioned cellNum
		Cell cell = row.getCell(cellNum);

		// step6:- fetch the cell value
		String excelData = cell.getStringCellValue();
		System.out.println(excelData);
		return excelData;
	}
	public String getExcelDataUsingFormatter(String SheetName,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fes = new FileInputStream("./src/test/resources/ExcelData7.xlsx");

		// step2:- keeps the workbook/Excel file in read mode
		Workbook book = WorkbookFactory.create(fes);

		// step3:- Navigates into mentioned sheetname
		Sheet sheet = book.getSheet(SheetName);
		Row row1 = sheet.getRow(rowNum);
		Cell cell1 = row1.getCell(cellNum);
		DataFormatter format = new DataFormatter();
		String ExcelData = format.formatCellValue(cell1);
		System.out.println(ExcelData);
		return ExcelData;
		
	}
	
	public  Object[][] readDataUsingDAtaProvider(String SheetName) throws Throwable
	{
		
		FileInputStream fes = new FileInputStream("./src/test/resources/ExcelData7.xlsx");

		// step2:- keeps the workbook/Excel file in read mode
		Workbook book = WorkbookFactory.create(fes);

		// step3:- Navigates into mentioned sheetname
		Sheet sheet = book.getSheet(SheetName);
		
		int lastRow = sheet.getLastRowNum()+1;
		
		int lastCell = sheet.getRow(0).getLastCellNum();
		
		Object[][] objArr = new Object[lastRow][lastCell];
		
		for(int i=0;i<lastRow;i++)
		{
			for (int j = 0; j < lastCell; j++)
			{
				objArr[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		
		return objArr;
		
	}
	
	
}
