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

public class UpdateFileEditVirtualBundleSKU {
    public void updateExcelFile(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        // Add specific data to row number 4 (index 3 in 0-based indexing)
        Row row = sheet.getRow(3);
        if (row == null) {
            row = sheet.createRow(3);
        }

        setCellValue(row, 0, "VirtualTest01"); // Column A
        setCellValue(row, 1, "NESTLE"); // Column B
        setCellValue(row, 2, generateRandomString()); // Column C
        setCellValue(row, 3, generateRandomString()); // Column D
        setCellValue(row, 4, "Each"); // Column E
        setCellValue(row, 5, "Sell"); // Column F
        setCellValue(row, 6, "IE"); // Column G
        setCellValue(row, 8, "AF"); // Column I
        setCellValue(row, 9, "AF"); // Column J
        setCellValue(row, 10, "1"); // Column K
        setCellValue(row, 11, "Day"); // Column L
        setCellValue(row, 12, "2"); // Column M
        setCellValue(row, 13, "Day"); // Column N
        setCellValue(row, 14, 2); // Column O
        setCellValue(row, 15, 3); // Column P
        setCellValue(row, 16, 4); // Column Q
        setCellValue(row, 17, 5); // Column R
        setCellValue(row, 18, 222); // Column S
        setCellValue(row, 19, 123); // Column T
        setCellValue(row, 20, 333); // Column U
        setCellValue(row, 25, 8); // Column Z
        setCellValue(row, 26, 8); // Column AA
        setCellValue(row, 27, "Normal"); // Column AB
        setCellValue(row, 28, "pickup_by_buyer"); // Column AC
        setCellValue(row, 29, "active"); // Column AD

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
