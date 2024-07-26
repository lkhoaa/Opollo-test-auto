package com.lkhoaa.model.rms.opollo;

import com.monitorjbl.xlsx.StreamingReader;
import io.qameta.allure.Step;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class OPRevenueReturned {
    @Step("Opollo file: Calculate the sum of the column amount in the 'Sale out' sheet")
    public static double sumOfOPRevenueReturnedFee(String filePath) {
        double totalSum = 0;
        double totalSum1 = 0;
        double totalSum2 = 0;
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = StreamingReader.builder().open(fis);
            Sheet sheet = workbook.getSheet("Sale Out");

            int transactionTypeColumnIndex = 25;
            int pisColumnIndex = 28;
            int amountColumnIndex = 18;

            for (Row row : sheet) {
                Cell returnedCell = row.getCell(transactionTypeColumnIndex);
                String returnedCellStr = returnedCell.getStringCellValue();
                if (returnedCellStr != null && returnedCellStr.equals("customer_returned")) {
                    Cell pisCell = row.getCell(pisColumnIndex);
                    String pisCellStr = pisCell.getStringCellValue();
                    if (pisCellStr != null && pisCellStr.equals("Yes")) {
                        Cell amountCell = row.getCell(amountColumnIndex);
                        double amountValue = amountCell.getNumericCellValue();
                        totalSum1 += amountValue;
                    }
                }

                Cell refundCell = row.getCell(transactionTypeColumnIndex);
                String refundCellStr = refundCell.getStringCellValue();
                if (refundCellStr != null && refundCellStr.equals("refund")) {
                    Cell pisCell = row.getCell(pisColumnIndex);
                    String pisCellStr = pisCell.getStringCellValue();
                    if (pisCellStr != null && pisCellStr.equals("Yes")) {
                        // Get the amount from the specified column
                        Cell amountCell = row.getCell(amountColumnIndex);
                        double amountValue = amountCell.getNumericCellValue();
                        if (amountCell != null) {
                            // Add the amount to the total sum
                            totalSum2 += amountValue;
                        }
                    }
                }
            }

            // Print the total sum of commission amounts
            totalSum = totalSum1 + totalSum2;
            System.out.printf("Total sum of revenue amount of order returned on OP: ");
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
