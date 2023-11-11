package com.lkhoaa.utils;

import org.testng.annotations.DataProvider;

import java.io.File;

public class DataLogin {
    @DataProvider
    public static Object[][] loginData() {
        String excelFileName = "TestData.xlsx";
        File excelFileLocation = new File(System.getProperty("user.dir") + "/src/test/data/LoginCredential" + excelFileName);
        String sheet = "Login";
        int startRowIndex = 1;
        int startColumnIndex = 0;
        ExcelReaderUtil excelReaderUtil = new ExcelReaderUtil(excelFileLocation, sheet, startRowIndex, startColumnIndex);
        int totalRow = excelReaderUtil.getTotalRow();
        int totalColumn = excelReaderUtil.getTotalColumn();

        Object[][] loginData = new Object[totalRow - startRowIndex][totalColumn];
        for (int startRow = startRowIndex; startRow < totalRow; startRow++) {
            for (int startColumn = startColumnIndex; startColumn < totalColumn; startColumn++) {
                loginData[startRow - startRowIndex][startColumn] = excelReaderUtil.getCellValue(startRow, startColumn);
            }
        }
        return loginData;
    }
}
