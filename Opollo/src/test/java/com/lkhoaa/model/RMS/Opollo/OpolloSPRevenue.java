package com.lkhoaa.model.RMS.Opollo;

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

            int amountColumnIndex = 18;

            for (Row row : sheet) {
                Cell completedCell = row.getCell(24);
                String completedCellStr = completedCell.getStringCellValue();
                if (completedCellStr != null && completedCellStr.equals("completed")){
                    Cell cell = row.getCell(amountColumnIndex);
                    if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                        totalSum += cell.getNumericCellValue();
                    }
                }
            }

            System.out.printf("Total sum of Revenue on OP: ");
            System.out.printf("%.2f\n", totalSum);

            // Close the workbook and file streams
            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalSum;
    }
}
