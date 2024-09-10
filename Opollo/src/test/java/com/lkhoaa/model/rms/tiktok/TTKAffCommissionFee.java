package com.lkhoaa.model.rms.tiktok;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.apache.commons.math3.util.FastMath.abs;

public class TTKAffCommissionFee {
    public static double sumOfTTKAffCommissionFee(String filePath) {
        double totalSum = 0;
        double sum1 = 0;
        double sum2 = 0;
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
                        sum1 += numericValue;
                    }

                    Cell cell2 = row.getCell(29); //AD
                    if (cell2 != null && cell2.getCellType() == CellType.STRING) {
                        java.lang.String cellValue = cell2.getStringCellValue();
                        double numericValue = Double.parseDouble(cellValue);
                        sum2 += numericValue;
                    }
                } catch (NumberFormatException e) {
                    System.err.print("");
                }
            }

            totalSum = sum1 + sum2;
            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalSum;
    }
}
