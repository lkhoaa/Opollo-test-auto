package com.lkhoaa.model.RMS.Opollo;

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

            int transactionTypeColumnIndex = 25;
            int pisColumnIndex = 28;
            int amountColumnIndex = 18;

            for (Row row : sheet) {
                Cell transactionTypeCell = row.getCell(transactionTypeColumnIndex);
                String transactionTypeCellStr = transactionTypeCell.getStringCellValue();
                if (transactionTypeCellStr != null && transactionTypeCellStr.equals("completed")) {
                    Cell pisCell = row.getCell(pisColumnIndex);
                    String pisCellStr = pisCell.getStringCellValue();
                    if (pisCellStr != null && pisCellStr.equals("Yes")) {
                        Cell amountCell = row.getCell(amountColumnIndex);
                        double amountValue = amountCell.getNumericCellValue();
                        if (amountCell != null) {
                            totalSum += amountValue;
                        }
                    }
                }
            }

            // Print the total sum of commission amounts
            System.out.printf("Total sum of revenue amount of order completed on OP: ");
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
