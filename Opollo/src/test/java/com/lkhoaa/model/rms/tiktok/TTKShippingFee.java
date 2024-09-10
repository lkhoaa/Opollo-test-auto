package com.lkhoaa.model.rms.tiktok;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.apache.commons.math3.util.FastMath.abs;

public class TTKShippingFee {
    public static double sumOfTTKShippingFee(String filePath) {
        double totalSum = 0;
        double sum1 = 0;
        double sum2 = 0;
        double sum3 = 0;
        double sum4 = 0;
        double sum5 = 0;
        double sum6 = 0;
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = StreamingReader.builder().open(fis);

            Sheet orderSheet = workbook.getSheetAt(0);
            for (Row row : orderSheet) {
                try {
                    Cell cell2 = row.getCell(16); //Q
                    if (cell2 != null && cell2.getCellType() == CellType.STRING) {
                        java.lang.String cellValue = cell2.getStringCellValue();
                        double numericValue = Double.parseDouble(cellValue);
                        sum2 += numericValue;
                    }

                    Cell cell3 = row.getCell(17); //R
                    if (cell3 != null && cell3.getCellType() == CellType.STRING) {
                        java.lang.String cellValue = cell3.getStringCellValue();
                        double numericValue = Double.parseDouble(cellValue);
                        sum3 += numericValue;
                    }

                    Cell cell4 = row.getCell(18); //S
                    if (cell4 != null && cell4.getCellType() == CellType.STRING) {
                        java.lang.String cellValue = cell4.getStringCellValue();
                        double numericValue = Double.parseDouble(cellValue);
                        sum4 += numericValue;
                    }

                    Cell cell5 = row.getCell(19); //T
                    if (cell5 != null && cell5.getCellType() == CellType.STRING) {
                        java.lang.String cellValue = cell5.getStringCellValue();
                        double numericValue = Double.parseDouble(cellValue);
                        sum5 += 0 - numericValue;
                    }

                    Cell cell6 = row.getCell(20); //U
                    if (cell6 != null && cell6.getCellType() == CellType.STRING) {
                        java.lang.String cellValue = cell6.getStringCellValue();
                        double numericValue = Double.parseDouble(cellValue);
                        sum6 += numericValue;
                    }

                    Cell cell1 = row.getCell(15); //P
                    if (cell1 != null && cell1.getCellType() == CellType.STRING) {
                        java.lang.String cellValue = cell1.getStringCellValue();
                        double numericValue = Double.parseDouble(cellValue);
                        sum1 += numericValue;
                    }
                } catch (NumberFormatException e) {
                    System.err.print("");
                }
            }
//            System.out.printf("Total sum of Shipping fee on TTK: ");
//            System.out.printf("%.2f\n", totalSum);
            totalSum = sum1 + sum2 + sum3 + sum4 + sum5 + sum6;
            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalSum;
    }
}
