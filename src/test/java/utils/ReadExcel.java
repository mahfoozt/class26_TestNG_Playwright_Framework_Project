package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {
	// public static void main(String[] args) {
	@Test
	public static void read_excel_sheet() {
		System.out.println("This is the test where we read from Excel Sheet ");
		System.out.println("Apache POI is used to read an Excel file");
		try {
			// Provide the path to your Excel file
			String excelFilePath = ".\\Data\\ReadData.xlsx";
			// Open the Excel file
			FileInputStream inputStream = new FileInputStream(excelFilePath);
			Workbook wb = new XSSFWorkbook(inputStream);
			// Assuming your data is in the first sheet (index 0)
			XSSFSheet sheet = (XSSFSheet) wb.getSheetAt(0);
			// Iterate through rows and columns to print cell values
			for (Row row : sheet) {
				for (Cell cell : row) {
					System.out.print(cell.toString() + "\t");
				}

				System.out.println(); // Move to the next line after each row
			}
			// Close the workbook and input stream
			wb.close();
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
