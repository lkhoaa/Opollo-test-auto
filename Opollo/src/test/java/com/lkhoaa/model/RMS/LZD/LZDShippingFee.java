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

public class LZDShippingFee {
    @Step("LZD file: Calculate the sum of the column amount in the shipping fee")
    public static double sumOfLzdShippingFee(String filePath) {
        double totalSum = 0;
        double totalSum1 = 0;
        double totalSum2 = 0;
        double totalSum3 = 0;
        double totalSum4 = 0;
        double totalSum5 = 0;
        double totalSum6 = 0;
        double totalSum7 = 0;
        double totalSum8 = 0;
        double totalSum9 = 0;
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
                if (feeStr != null && feeStr.equals("Shipping fee - correction for undercharge")) {
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
                if (feeStr2 != null && feeStr2.equals("Shipping Fee Subsidy (By Seller)")) {
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
                if (feeStr3 != null && feeStr3.equals("Shipping Fee Claims")) {
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
                if (feeStr4 != null && feeStr4.equals("Shipping Fee Refund to Customer")) {
                    // Get the amount from the specified column
                    Cell amountCell = row.getCell(amountColumnIndex);
                    double amountValue = amountCell.getNumericCellValue();
                    if (amountCell != null) {
                        // Add the amount to the total sum
                        totalSum4 += amountValue;
                    }
                }

                Cell feeCell5 = row.getCell(feeNameIndex);
                String feeStr5 = feeCell5.getStringCellValue();
                if (feeStr5 != null && feeStr5.equals("Shipping Fee Correction")) {
                    // Get the amount from the specified column
                    Cell amountCell = row.getCell(amountColumnIndex);
                    double amountValue = amountCell.getNumericCellValue();
                    if (amountCell != null) {
                        // Add the amount to the total sum
                        totalSum5 += amountValue;
                    }
                }

                Cell feeCell6 = row.getCell(feeNameIndex);
                String feeStr6 = feeCell6.getStringCellValue();
                if (feeStr6 != null && feeStr6.equals("Shipping fee refund - correction for overcharge")) {
                    // Get the amount from the specified column
                    Cell amountCell = row.getCell(amountColumnIndex);
                    double amountValue = amountCell.getNumericCellValue();
                    if (amountCell != null) {
                        // Add the amount to the total sum
                        totalSum6 += amountValue;
                    }
                }

                Cell feeCell7 = row.getCell(feeNameIndex);
                String feeStr7 = feeCell7.getStringCellValue();
                if (feeStr7 != null && feeStr7.equals("Shipping Fee Voucher (by Lazada)")) {
                    // Get the amount from the specified column
                    Cell amountCell = row.getCell(amountColumnIndex);
                    double amountValue = amountCell.getNumericCellValue();
                    if (amountCell != null) {
                        // Add the amount to the total sum
                        totalSum7 += amountValue;
                    }
                }

                Cell feeCell8 = row.getCell(feeNameIndex);
                String feeStr8 = feeCell8.getStringCellValue();
                if (feeStr8 != null && feeStr8.equals("Shipping Fee Voucher Refund to Laz")) {
                    // Get the amount from the specified column
                    Cell amountCell = row.getCell(amountColumnIndex);
                    double amountValue = amountCell.getNumericCellValue();
                    if (amountCell != null) {
                        // Add the amount to the total sum
                        totalSum8 += amountValue;
                    }
                }

                Cell feeCell9 = row.getCell(feeNameIndex);
                String feeStr9 = feeCell9.getStringCellValue();
                if (feeStr9 != null && feeStr9.equals("Shipping Fee (Paid By Customer)")) {
                    // Get the amount from the specified column
                    Cell amountCell = row.getCell(amountColumnIndex);
                    double amountValue = amountCell.getNumericCellValue();
                    if (amountCell != null) {
                        // Add the amount to the total sum
                        totalSum9 += amountValue;
                    }
                }
            }

            // Print the total sum of commission amounts
            totalSum = totalSum1 + totalSum2 + totalSum3 + totalSum4 + totalSum5 + totalSum6 + totalSum7 + totalSum8 + totalSum9;
            System.out.printf("Total sum of Shipping fee on LZD: ");
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
