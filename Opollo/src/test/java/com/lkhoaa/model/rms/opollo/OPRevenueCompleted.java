package com.lkhoaa.model.rms.opollo;

import com.monitorjbl.xlsx.StreamingReader;
import io.qameta.allure.Step;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class OPRevenueCompleted {
    @Step("Opollo file: Calculate the sum of the column amount in the 'Sale out' sheet")
    public static double sumOfOPRevenueCompletedFee(String filePath) {
        double totalSum = 0;
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = StreamingReader.builder().open(fis);
            Sheet sheet = workbook.getSheet("Sale Out");

            for (Row row : sheet) {
                Cell transactionTypeCell = row.getCell(25); //Z
                String transactionTypeCellStr = transactionTypeCell.getStringCellValue();
                if (transactionTypeCellStr != null && transactionTypeCellStr.equals("completed")) {
                    Cell pisCell = row.getCell(28); //AC
                    String pisCellStr = pisCell.getStringCellValue();
                    if (pisCellStr != null && pisCellStr.equals("Yes")) {
                        Cell amountCell = row.getCell(18); //S
                        if (amountCell != null && amountCell.getCellType() == CellType.NUMERIC) {
                            double amountValue = amountCell.getNumericCellValue();
                            totalSum += amountValue;
                        }
                    }
                }
            }

            System.out.printf("Total sum of revenue amount of order completed on OP: ");
            System.out.printf("%.2f\n", totalSum);

            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalSum;
    }
}
