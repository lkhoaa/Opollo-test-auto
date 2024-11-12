package com.lkhoaa.model.pms;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class UpdateFileCreatePhysicalBundleSKU {
    public void updateExcelFile(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        // Add specific data to row number 4 (index 3 in 0-based indexing)
        Row row = sheet.getRow(3);
        if (row == null) {
            row = sheet.createRow(3);
        }

        setCellValue(row, 0, generateRandomString()); // Column A
        setCellValue(row, 1, "NESTLE"); // Column B
        setCellValue(row, 2, "outright"); // Column C
        setCellValue(row, 3, "NESTLE"); // Column D
        setCellValue(row, 4, generateRandomString()); // Column E
        setCellValue(row, 6, "Physical Bundle"); // Column G
        setCellValue(row, 7, "Each"); // Column H
        setCellValue(row, 8, "Sell"); // Column I
        setCellValue(row, 9, "IE"); // Column J
        setCellValue(row, 10, "Stock001"); // Column K
        setCellValue(row, 11, "1"); // Column L
        setCellValue(row, 19, 2); // Column T
        setCellValue(row, 20, 3); // Column U
        setCellValue(row, 21, 4); // Column V
        setCellValue(row, 22, 222); // Column W
        setCellValue(row, 23, 123); // Column X
        setCellValue(row, 24, 3333); // Column Y
        setCellValue(row, 25, 4444); // Column Z
        setCellValue(row, 27, "all"); // Column AB
        setCellValue(row, 28, "NESTLE"); // Column AC
        setCellValue(row, 32, "5"); // Column AG
        setCellValue(row, 33, "5"); // Column AH
        setCellValue(row, 34, "123abc"); // Column AI
        setCellValue(row, 35, "Normal"); // Column AJ
        setCellValue(row, 36, "pickup_by_buyer"); // Column AK

        // Save the updated file
        fis.close();
        FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        workbook.close();
    }

    private void setCellValue(Row row, int colIndex, String value) {
        Cell cell = row.getCell(colIndex);
        if (cell == null) {
            cell = row.createCell(colIndex);
        }
        cell.setCellValue(value);
    }

    private void setCellValue(Row row, int colIndex, int value) {
        Cell cell = row.getCell(colIndex);
        if (cell == null) {
            cell = row.createCell(colIndex);
        }
        cell.setCellValue(value);
    }

    private String generateRandomString() {
        int length = 8;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder data = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            data.append(characters.charAt(random.nextInt(characters.length())));
        }
        return data.toString();
    }
}
