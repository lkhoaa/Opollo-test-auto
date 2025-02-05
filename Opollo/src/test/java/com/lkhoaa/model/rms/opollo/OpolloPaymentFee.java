package com.lkhoaa.model.rms.opollo;

import com.monitorjbl.xlsx.StreamingReader;
import io.qameta.allure.Step;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class OpolloPaymentFee {
    @Step("Opollo file: Calculate the sum of the column amount in the 'payment fee' sheet")
    public static double sumOfOPPaymentFee(String filePath) {
        double totalSum = 0;
        double sum1 = 0;
        double sum2 = 0;
        double sum3 = 0;
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = StreamingReader.builder().open(fis);
            Sheet sheet = workbook.getSheet("Payment Fee");

            for (Row row : sheet) {
                Cell cell1 = row.getCell(14); //O
                if (cell1 != null && cell1.getCellType() == CellType.NUMERIC) {
                    double amountCell = cell1.getNumericCellValue();
                    sum1 += amountCell;
                }
//                Cell cell2 = row.getCell(12); //M
//                if (cell2 != null && cell2.getCellType() == CellType.NUMERIC) {
//                    double amountCell = cell2.getNumericCellValue();
//                    sum2 += 0-amountCell;
//                }
//                Cell cell3 = row.getCell(13); //N
//                if (cell3 != null && cell3.getCellType() == CellType.NUMERIC) {
//                    double amountCell = cell3.getNumericCellValue();
//                    sum3 += 0-amountCell;
//                }
            }

            totalSum = sum1 + sum2 + sum3;
            System.out.printf("Total sum of Payment fee on OP: ");
            System.out.printf("%.2f\n", totalSum);
            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalSum;
    }
}
