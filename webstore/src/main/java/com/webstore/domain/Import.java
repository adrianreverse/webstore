package com.webstore.domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Import {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Import.readFileUsingPOI();
	}

	public static void readFileUsingPOI(ImportFile importFile) throws IOException {
		ClassLoader classLoader = Import.class.getClassLoader();
		String excelFilePath = "C:/Users/Adrian Lap/Desktop/import.xlsx";
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		
		
		
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = sheet.iterator();
		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			
			
			
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					System.out.print(cell.getStringCellValue());
					break;
				case Cell.CELL_TYPE_NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					System.out.print(cell.getBooleanCellValue());
					break;
				}
				System.out.print(" | ");
			}
			System.out.println();
		}
		workbook.close();
		inputStream.close();
	}

}
