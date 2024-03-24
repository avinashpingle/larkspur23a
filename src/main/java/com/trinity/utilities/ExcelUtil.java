package com.trinity.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public void readExcel(String filePath) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Workbook book = null;
		try {
			book = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Sheet sheet = book.getSheet("");

	}
}
