package com.lkhoaa.model.rms.opollo;

import com.monitorjbl.xlsx.StreamingReader;
import io.qameta.allure.Step;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class OpolloLazadaBonusFee {
    @Step("Opollo file: Calculate the sum of the column amount in the 'Lazada Bonus' sheet")
    public static double sumOfOPLazadaBonus(String filePath) {
        double totalSum = 0;
        try {
            // Load the Excel file
            FileInputStream fis = new FileInputStream(new File(filePath));

            // Create the workbook object
            Workbook workbook = StreamingReader.builder().open(fis);

            // Get the first sheet of the workbook
            Sheet sheet = workbook.getSheet("Lazada Bonus");

            // Define the column indices for fee name and amount
            int amountColumnIndex = 9;  // Column index 7 (0-based)

            // Iterate through each row in the sheet
            for (Row row : sheet) {
                // Get the fee name from the specified column
                Cell cell = row.getCell(amountColumnIndex);
                if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                    // Add the numeric value to the total sum
                    totalSum += cell.getNumericCellValue();
                }
            }

            // Print the total sum of commission amounts
            System.out.printf("Total sum of Lazada Bonus amounts on OP: ");
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
