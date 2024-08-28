package com.lkhoaa.model.rms.compareFormular;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ExcelComparator {
    public static void compareExcelFiles(String filePath1, String filePath2) throws IOException {

        Set<String> file1Data = readExcelColumn(filePath1, "Order details", 0, true); // Column A is index 0
        Set<String> file2Data = readExcelColumn(filePath2, "Commission Fee", 3, false); // Column D is index 3

        int file1Rows = file1Data.size();
        int file2Rows = file2Data.size();

        Set<String> commonRows = new HashSet<>(file1Data);
        commonRows.retainAll(file2Data);
        int commonRowsCount = commonRows.size();

        Set<String> onlyInFile1 = new HashSet<>(file1Data);
        onlyInFile1.removeAll(file2Data);
        int onlyInFile1Count = onlyInFile1.size();

        Set<String> onlyInFile2 = new HashSet<>(file2Data);
        onlyInFile2.removeAll(file1Data);
        int onlyInFile2Count = onlyInFile2.size();

        System.out.println("Number of rows in File Tiktok: " + file1Rows);
        System.out.println("Number of rows in File Opollo: " + (file2Rows-1));
//        System.out.println("Number of rows common in both files: " + commonRowsCount);
        System.out.println("Number of rows only in File Tiktok: " + onlyInFile1Count);
//        System.out.println("Number of rows only in File Opollo: " + onlyInFile2Count);
        double rate = (file1Rows > 0) ? ((double) onlyInFile1Count / file1Rows) * 100 : 0;
        System.out.println("Rate of rows only in File Tiktok compared to total rows in File Tiktok: " + String.format("%.2f", rate) + "%");
    }

    private static Set<String> readExcelColumn(String filePath, String sheetName, int columnIndex, boolean checkColumnV) throws IOException {
        Set<String> data = new HashSet<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = StreamingReader.builder().open(fis)) {
            Sheet sheet = workbook.getSheet(sheetName);

            for (Row row : sheet) {
                try {
                    if(checkColumnV){Cell cell = row.getCell(21); //V
                    if (cell != null && cell.getCellType() == CellType.STRING) {
                        java.lang.String cellValue = cell.getStringCellValue();
                        double numericValue = Double.parseDouble(cellValue);
                        if (numericValue == 0) {continue;}
                    }}
                    Cell targetCell = row.getCell(columnIndex);
                    if (targetCell != null && targetCell.getCellType() == CellType.STRING) {
                        data.add(targetCell.getStringCellValue());
                    }
                } catch (NumberFormatException e) {
                    System.err.print("");
                }
            }
        }

        return data;
    }
}

