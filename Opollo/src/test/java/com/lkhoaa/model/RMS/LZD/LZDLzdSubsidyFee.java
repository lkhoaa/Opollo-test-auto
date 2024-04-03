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

public class LZDLzdSubsidyFee {
    @Step("LZD file: Calculate the sum of the column amount in the LzdSubsidy fee")
    public static double sumOfLzdLzdsubsidyFee(String filePath) {
        double totalSum = 0;
        try {
            // Load the Excel file
            FileInputStream fis = new FileInputStream(new File(filePath));

            // Create the workbook object
            Workbook workbook = StreamingReader.builder().open(fis);

            // Get the first sheet of the workbook
            Sheet sheet = workbook.getSheetAt(0);

            // Define the column indices for fee name and amount
            int feeNameIndex = 3;
            int amountColumnIndex = 4;

            // Iterate through each row in the sheet
            for (Row row : sheet) {
                // Get the fee name from the specified column
                Cell feeCell = row.getCell(feeNameIndex);
                String feeStr = feeCell.getStringCellValue();
                if (feeStr != null && feeStr.equals("LazFlash Extra/Everyday Below $9.99 Subsidy")) {
                    // Get the amount from the specified column
                    Cell amountCell = row.getCell(amountColumnIndex);
                    double amountValue = amountCell.getNumericCellValue();
                    if (amountCell != null) {
                        // Add the amount to the total sum
                        totalSum += amountValue;
                    }
                }
            }

            // Print the total sum of commission amounts
            System.out.printf("Total sum of LzdSubsidy amounts on LZD: ");
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
