package com.lkhoaa.model.rms.shopee;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ShopeeShippingFee {
    public static double sumOfShippingFee(String filePath) {
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
                        Cell cell = row.getCell(13); //N
                        if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                            totalSum1 += cell.getNumericCellValue();
                        }

                        Cell cell2 = row.getCell(14); //O
                        if (cell2 != null && cell2.getCellType() == CellType.NUMERIC) {
                            totalSum2 += cell2.getNumericCellValue();
                        }

                        Cell cell3 = row.getCell(15); //P
                        if (cell3 != null && cell3.getCellType() == CellType.NUMERIC) {
                            totalSum3 += cell3.getNumericCellValue();
                        }
                    }
                }
            }

            totalSum = totalSum1 + totalSum2 + totalSum3;
            System.out.printf("Total sum of Shipping fee on SP: ");
            System.out.printf("%.2f\n", totalSum);
            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalSum;
    }
}
