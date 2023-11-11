package com.lkhoaa.model.RMS.Shopee;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ShopeeRevenue {
    public static double sumOfSPRevenue(String filePath) {
        double totalSum = 0;
        double totalSum1 = 0;
        double totalSum2 = 0;
        double totalSum3 = 0;
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = StreamingReader.builder().open(fis);

            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                if (workbook.getSheetName(i).startsWith("Income")) {
                    Sheet incomeSheet = workbook.getSheetAt(i);
                    for (Row row : incomeSheet) {
                        Cell cell = row.getCell(7); //H
                        if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                            totalSum1 += cell.getNumericCellValue();
                        }

                        Cell cell2 = row.getCell(8); //I
                        if (cell2 != null && cell2.getCellType() == CellType.NUMERIC) {
                            totalSum2 += cell2.getNumericCellValue();
                        }

                        Cell cell3 = row.getCell(9); //J
                        if (cell3 != null && cell3.getCellType() == CellType.NUMERIC) {
                            totalSum3 += cell3.getNumericCellValue();
                        }
                    }
                }
            }

            totalSum = totalSum1 + totalSum2 + totalSum3;
            System.out.printf("Total sum of Revenue on SP: ");
            System.out.printf("%.2f\n", totalSum);
            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalSum;
    }
}
