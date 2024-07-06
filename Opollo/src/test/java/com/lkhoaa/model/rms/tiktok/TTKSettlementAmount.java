package com.lkhoaa.model.rms.tiktok;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TTKSettlementAmount {
    public static double sumOfTTKSettlementAmount(String filePath) {
        double totalSum = 0;
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = StreamingReader.builder().open(fis);

            Sheet orderSheet = workbook.getSheetAt(0);
            for (Row row : orderSheet) {
                try {
                    Cell cell = row.getCell(6); //G
                    if (cell != null && cell.getCellType() == CellType.STRING) {
                        java.lang.String cellValue = cell.getStringCellValue();
                        double revenueValue = Double.parseDouble(cellValue);
                        if (revenueValue != 0) {
                            Cell cell2 = row.getCell(5); //G
                            if (cell2 != null && cell2.getCellType() == CellType.STRING) {
                                java.lang.String cell2Value = cell2.getStringCellValue();
                                double settlementValue = Double.parseDouble(cell2Value);
                                totalSum += settlementValue;
                            }
                        }
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
