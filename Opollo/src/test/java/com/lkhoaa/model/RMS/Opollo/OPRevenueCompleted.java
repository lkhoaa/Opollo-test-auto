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
            // Load the Excel file
            FileInputStream fis = new FileInputStream(new File(filePath));

            // Create the workbook object
            Workbook workbook = StreamingReader.builder().open(fis);

            // Get the first sheet of the workbook
            Sheet sheet = workbook.getSheet("Sale Out");

            // Define the column indices for fee name and amount
            int transactionTypeColumnIndex = 23;
            int pisColumnIndex = 26;
            int amountColumnIndex = 18;

            // Iterate through each row in the sheet
            for (Row row : sheet) {
                // Get the fee name from the specified column
                Cell transactionTypeCell = row.getCell(transactionTypeColumnIndex);
                String transactionTypeCellStr = transactionTypeCell.getStringCellValue();
                if (transactionTypeCellStr != null && transactionTypeCellStr.equals("completed")) {
                    Cell pisCell = row.getCell(pisColumnIndex);
                    String pisCellStr = pisCell.getStringCellValue();
                    if (pisCellStr != null && pisCellStr.equals("Yes")) {
                        // Get the amount from the specified column
                        Cell amountCell = row.getCell(amountColumnIndex);
                        double amountValue = amountCell.getNumericCellValue();
                        if (amountCell != null) {
                            // Add the amount to the total sum
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
