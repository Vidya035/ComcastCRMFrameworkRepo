package com.workshop.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;

public class ExcelUtility {

    public String getDataFromExcel(String sheetName, int rowNum, int celNum) throws Throwable {
        FileInputStream fis = new FileInputStream("./TestData/TestScriptData.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);
        if (row == null) {
            wb.close();
            return "";
        }
      Cell cell = row.getCell(celNum);
        if (cell == null) {
            wb.close();
            return "";
        }
   // DataFormatter handles STRING, NUMERIC, BOOLEAN, FORMULA, etc.
        DataFormatter df = new DataFormatter();
        String data = df.formatCellValue(cell);

        wb.close();
        return data;
    }  public int getRowcount(String sheetName) throws Throwable {
        FileInputStream fis = new FileInputStream("./TestData/TestScriptData.xlsx");
        Workbook wb = WorkbookFactory.create(fis);

        Sheet sheet = wb.getSheet(sheetName);
        int rowcount = sheet.getLastRowNum(); // last row index
        wb.close();
        return rowcount;
    }
    public void setDataIntoExcel(String sheetName, int rowNum, int celNum, String data) throws Throwable {
        FileInputStream fis = new FileInputStream("./TestData/TestScriptData.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);
        }
        Cell cell = row.getCell(celNum);
        if (cell == null) {
            cell = row.createCell(celNum);
        }
        cell.setCellValue(data);
        FileOutputStream fos = new FileOutputStream("./TestData/TestScriptData.xlsx");
        wb.write(fos);

        wb.close();
        fos.close();
    }
}