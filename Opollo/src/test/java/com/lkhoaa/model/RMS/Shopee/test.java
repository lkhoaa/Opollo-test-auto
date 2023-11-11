package com.lkhoaa.model.RMS.Shopee;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        double totalSum = 0;
        double totalSumOfIncome = 0;
        FileInputStream fis = new FileInputStream("/Users/lkhoaa/Library/CloudStorage/OneDrive-OnPointVietnam/Documents/Restassured/Opollo/Opollo/src/test/data/Shopee/MOL.xlsx");
        Workbook workbook = StreamingReader.builder().open(fis);

        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            if (workbook.getSheetName(i).startsWith("Income")) {
                Sheet incomeSheet = workbook.getSheetAt(i);
                for (Row row : incomeSheet) {
                    Cell cell = row.getCell(18);
                    if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                        totalSum += cell.getNumericCellValue();
                    }
                }
            }
        }

        System.out.printf("Total sum of Commission fee on SP: ");
        System.out.printf("%.2f\n", totalSum);
        workbook.close();
        fis.close();
    }
}
