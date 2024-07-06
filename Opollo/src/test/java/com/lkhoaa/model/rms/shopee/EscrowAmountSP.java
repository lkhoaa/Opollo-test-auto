package com.lkhoaa.model.rms.shopee;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class EscrowAmountSP {
    public static double sumOfEscrowAmountSP(String filePath) {
        double totalSum = 0;
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = StreamingReader.builder().open(fis);

            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                if (workbook.getSheetName(i).startsWith("Income")) {
                    Sheet incomeSheet = workbook.getSheetAt(i);
                    for (Row row : incomeSheet) {
                        Cell cell = row.getCell(21); //V
                        if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                            totalSum += cell.getNumericCellValue();
                        }
                    }
                }
            }

            System.out.printf("Total sum of Escrow Amount on SP: ");
            System.out.printf("%.2f\n", totalSum);
            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalSum;
    }
}
