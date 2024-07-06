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
        double Sum1 = 0;
        double Sum2 = 0;
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = StreamingReader.builder().open(fis);

            Sheet orderSheet = workbook.getSheetAt(0);
            for (Row row : orderSheet) {
                try {
                    Cell cell = row.getCell(15); //P
                    if (cell != null && cell.getCellType() == CellType.STRING) {
                        java.lang.String cellValue = cell.getStringCellValue();
                        double numericValue = Double.parseDouble(cellValue);
                        totalSum += numericValue;
                    }
                } catch (NumberFormatException e) {
                    System.err.print("");
                }
            }
//            System.out.printf("Total sum of Shipping fee on TTK: ");
//            System.out.printf("%.2f\n", totalSum);
            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalSum;
    }
}
