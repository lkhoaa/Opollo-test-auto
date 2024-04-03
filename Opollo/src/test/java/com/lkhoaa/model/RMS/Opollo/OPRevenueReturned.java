package com.lkhoaa.model.RMS.Opollo;

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
            // Load the Excel file
            FileInputStream fis = new FileInputStream(new File(filePath));

            // Create the workbook object
            Workbook workbook = StreamingReader.builder().open(fis);

            // Get the first sheet of the workbook
            Sheet sheet = workbook.getSheet("Sale Out");

            // Define the column indices for fee name and amount
            int transactionTypeColumnIndex = 25;
            int pisColumnIndex = 28;
            int amountColumnIndex = 18;

            // Iterate through each row in the sheet
            for (Row row : sheet) {
                // Get the fee name from the specified column
                Cell returnedCell = row.getCell(transactionTypeColumnIndex);
                String returnedCellStr = returnedCell.getStringCellValue();
                if (returnedCellStr != null && returnedCellStr.equals("customer_returned")) {
                    Cell pisCell = row.getCell(pisColumnIndex);
                    String pisCellStr = pisCell.getStringCellValue();
                    if (pisCellStr != null && pisCellStr.equals("Yes")) {
                        // Get the amount from the specified column
                        Cell amountCell = row.getCell(amountColumnIndex);
                        double amountValue = amountCell.getNumericCellValue();
                        if (amountCell != null) {
                            // Add the amount to the total sum
                            totalSum1 += amountValue;
                        }
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
