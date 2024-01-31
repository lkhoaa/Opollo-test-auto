package com.lkhoaa.model.RMS.Tiktok;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.apache.commons.math3.util.FastMath.abs;

public class TTKAffCommissionFee {
    public static double sumOfTTKAffCommissionFee(String filePath) {
        double totalSum = 0;
        double Sum1 = 0;
        double Sum2 = 0;
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = StreamingReader.builder().open(fis);

            Sheet orderSheet = workbook.getSheetAt(0);
            for (Row row : orderSheet) {
                try {
                    Cell cell1 = row.getCell(23); //X
                    if (cell1 != null && cell1.getCellType() == CellType.STRING) {
                        java.lang.String cellValue = cell1.getStringCellValue();
                        double numericValue = Double.parseDouble(cellValue);
                        Sum1 += numericValue;
                    }

                    Cell cell2 = row.getCell(24); //Y
                    if (cell2 != null && cell2.getCellType() == CellType.STRING) {
                        java.lang.String cellValue = cell2.getStringCellValue();
                        double numericValue = Double.parseDouble(cellValue);
                        Sum2 += numericValue;
                    }
                } catch (NumberFormatException e) {
                    System.err.print("");
                }
            }

            System.out.printf("Total sum of Aff Commission fee on TTK: ");
            System.out.printf("%.2f\n", totalSum = Sum2 + Sum1);
            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalSum;
    }
}
