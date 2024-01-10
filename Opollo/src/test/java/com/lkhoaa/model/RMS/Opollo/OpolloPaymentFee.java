package com.lkhoaa.model.RMS.Opollo;

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
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));

            Workbook workbook = StreamingReader.builder().open(fis);

            Sheet sheet = workbook.getSheet("Payment Fee");

            int amountColumnIndex = 11;  //

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
            System.out.printf("Total sum of Payment fee on OP: ");
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
