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
                        totalSum += numericValue;
                    }
                } catch (NumberFormatException e) {
                    System.err.print("");
                }
            }
            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalSum;
    }
}
