package com.lkhoaa.model.RMS.LZD;

import com.monitorjbl.xlsx.StreamingReader;
import io.qameta.allure.Step;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class LZDLazadaBonusFee {
    @Step("LZD file: Calculate the sum of the column amount in the lazada bonus sheet")
    public static double sumOfLzdLazadaBonus(String filePath) {
        double totalSum = 0;
        double totalSum1 = 0;
        double totalSum2 = 0;
        double totalSum3 = 0;
        double totalSum4 = 0;
        try {
            // Load the Excel file
            FileInputStream fis = new FileInputStream(new File(filePath));

            // Create the workbook object
            Workbook workbook = StreamingReader.builder().open(fis);

            // Get the first sheet of the workbook
            Sheet sheet = workbook.getSheetAt(0);

            // Define the column indices for fee name and amount
            int feeNameIndex = 2;
            int amountColumnIndex = 7;

            // Iterate through each row in the sheet
            for (Row row : sheet) {
                // Get the fee name from the specified column
                Cell feeCell = row.getCell(feeNameIndex);
                String feeStr = feeCell.getStringCellValue();
                if (feeStr != null && feeStr.equals("Lazada Bonus")) {
                    // Get the amount from the specified column
                    Cell amountCell = row.getCell(amountColumnIndex);
                    double amountValue = amountCell.getNumericCellValue();
                    if (amountCell != null) {
                        // Add the amount to the total sum
                        totalSum1 += amountValue;
                    }
                }

                Cell feeCell2 = row.getCell(feeNameIndex);
                String feeStr2 = feeCell2.getStringCellValue();
                if (feeStr2 != null && feeStr2.equals("Lazada Bonus - LZD co-fund")) {
                    // Get the amount from the specified column
                    Cell amountCell = row.getCell(amountColumnIndex);
                    double amountValue = amountCell.getNumericCellValue();
                    if (amountCell != null) {
                        // Add the amount to the total sum
                        totalSum2 += amountValue;
                    }
                }

                Cell feeCell3 = row.getCell(feeNameIndex);
                String feeStr3 = feeCell3.getStringCellValue();
                if (feeStr3 != null && feeStr3.equals("Lazada Bonus - LZD co-fund - Reversal")) {
                    // Get the amount from the specified column
                    Cell amountCell = row.getCell(amountColumnIndex);
                    double amountValue = amountCell.getNumericCellValue();
                    if (amountCell != null) {
                        // Add the amount to the total sum
                        totalSum3 += amountValue;
                    }
                }

                Cell feeCell4 = row.getCell(feeNameIndex);
                String feeStr4 = feeCell4.getStringCellValue();
                if (feeStr4 != null && feeStr4.equals("Lazada Bonus - Reversal")) {
                    // Get the amount from the specified column
                    Cell amountCell = row.getCell(amountColumnIndex);
                    double amountValue = amountCell.getNumericCellValue();
                    if (amountCell != null) {
                        // Add the amount to the total sum
                        totalSum4 += amountValue;
                    }
                }
            }

            // Print the total sum of commission amounts
            totalSum = totalSum1 + totalSum2 + totalSum3 + totalSum4;
            System.out.printf("Total sum of Lazada Bonus (LZD co-fund, LZD co-fund - Reversal, Reversal) on LZD: ");
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
