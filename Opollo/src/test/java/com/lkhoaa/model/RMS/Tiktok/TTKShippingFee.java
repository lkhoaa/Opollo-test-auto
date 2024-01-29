package com.lkhoaa.model.RMS.Tiktok;

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
                    Cell cell1 = row.getCell(16); //Q
                    if (cell1 != null && cell1.getCellType() == CellType.STRING) {
                        java.lang.String cellValue = cell1.getStringCellValue();
                        double numericValue = Double.parseDouble(cellValue);
                        Sum1 += numericValue;
                    }
                    
                    Cell cell2 = row.getCell(17); //R
                    if (cell2 != null && cell2.getCellType() == CellType.STRING) {
                        java.lang.String cellValue = cell2.getStringCellValue();
                        double numericValue = Double.parseDouble(cellValue);
                        Sum2 += numericValue;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Cannot parse the string to a number in row " + (row.getRowNum() + 1));
                }
            }

            System.out.printf("Total sum of Shipping fee on TTK: ");
            System.out.printf("%.2f\n", abs(totalSum = Sum1 + Sum2));
            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalSum;
    }
}
