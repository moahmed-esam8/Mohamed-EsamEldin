package TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReaderFromExcel {

	static FileInputStream fis = null;

	public Object[][] GetDataFromExcel() throws IOException {

		String filepath = System.getProperty("user.dir") + "//TestFiles//UserData.xlsx";
		File src = new File(filepath);
		fis = new FileInputStream(src);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rows = sheet.getLastRowNum()+1;
		int cols = 2;
		String[][] Excelarr = new String[rows][cols];

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				XSSFRow row_sheet = sheet.getRow(row);
				Excelarr[row][col] = row_sheet.getCell(col).toString();
			}
		}
		wb.close();
		return Excelarr;
	}
}
