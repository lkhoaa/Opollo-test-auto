package com.lkhoaa.model.rms.opollo;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class OpolloSPRevenue {
    public static double sumOfOPRevenue(String filePath) {
        double totalSum = 0;
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = StreamingReader.builder().open(fis);
            Sheet sheet = workbook.getSheet("Sale Out");

            for (Row row : sheet) {
                Cell cell1 = row.getCell(19); //T
                if (cell1 != null && cell1.getCellType() == CellType.NUMERIC) {
                    totalSum += cell1.getNumericCellValue();
                }
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
