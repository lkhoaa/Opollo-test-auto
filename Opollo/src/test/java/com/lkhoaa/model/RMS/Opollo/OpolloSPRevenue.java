package com.lkhoaa.model.RMS.Opollo;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class OpolloSPRevenue {
    public static double sumOfOPRevenue(String filePath) {
        double sum1 = 0;
        double sum2 = 0;
        double totalSum = 0;
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = StreamingReader.builder().open(fis);
            Sheet sheet = workbook.getSheet("Sale Out");

            for (Row row : sheet) {
                Cell cell1 = row.getCell(18);
                if (cell1 != null && cell1.getCellType() == CellType.NUMERIC) {
                    sum1 += cell1.getNumericCellValue();
                }

                Cell cell2 = row.getCell(14);
                if (cell2 != null && cell2.getCellType() == CellType.NUMERIC) {
                    sum2 += cell2.getNumericCellValue();
                }
                totalSum = sum1 + sum2;
            }

            System.out.printf("Total sum of Revenue on OP: ");
            System.out.printf("%.2f\n", totalSum);

            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalSum;
    }
}
