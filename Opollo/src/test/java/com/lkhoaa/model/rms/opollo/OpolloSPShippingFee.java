package com.lkhoaa.model.rms.opollo;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class OpolloSPShippingFee {
    public static double sumOfOPShippingFee(String filePath) {
        double totalSum = 0;
        double totalSum1 = 0;
        double totalSum2 = 0;
        double totalSum3 = 0;
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = StreamingReader.builder().open(fis);
            Sheet sheet = workbook.getSheet("Shipping Fee");

            for (Row row : sheet) {
                Cell cell1 = row.getCell(16);
                if (cell1 != null && cell1.getCellType() == CellType.NUMERIC) {
                    double amountCell = cell1.getNumericCellValue();
                    totalSum1 += 0-amountCell;
                }

                Cell cell2 = row.getCell(17);
                if (cell2 != null && cell2.getCellType() == CellType.NUMERIC) {
                    double amountCell = cell2.getNumericCellValue();
                    totalSum2 += 0-amountCell;
                }

                Cell cell3 = row.getCell(18);
                if (cell3 != null && cell3.getCellType() == CellType.NUMERIC) {
                    double amountCell = cell3.getNumericCellValue();
                    totalSum3 += 0-amountCell;
                }
            }

            totalSum = totalSum1 + totalSum2 + totalSum3;
            System.out.printf("Total sum of Shipping fee on OP: ");
            System.out.printf("%.2f\n", totalSum);

            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalSum;
    }
}
