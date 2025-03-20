package com.lkhoaa.model.rms.tiktok;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TTKPaymentFee {
    public static double sumOfTTKPaymentFee(String filePath) {
        double totalSum = 0;
        double sum1 = 0;
        double sum2 = 0;
        double sum3 = 0;
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = StreamingReader.builder().open(fis);

            Sheet orderSheet = workbook.getSheetAt(0);
            for (Row row : orderSheet) {
                try {
                    Cell cell1 = row.getCell(14); //O
                    if (cell1 != null && cell1.getCellType() == CellType.STRING) {
                        java.lang.String cellValue = cell1.getStringCellValue();
                        double numericValue = Double.parseDouble(cellValue);
                        sum1 += numericValue;
                    }
                } catch (NumberFormatException e) {
                    System.err.print("");
                }
            }
            totalSum = sum1 + sum2 + sum3;
            System.out.printf("Total sum of Payment fee on TTK: ");
            System.out.printf("%.2f\n", totalSum);
            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalSum;
    }
}
