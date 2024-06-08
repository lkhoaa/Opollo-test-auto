package com.lkhoaa.model.RMS.LZD;

import com.monitorjbl.xlsx.StreamingReader;
import io.qameta.allure.Step;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class LZDPaymentFee {
    @Step("LZD file: Calculate the sum of the column amount in the payment fee")
    public static double sumOfLzdPaymentFee(String filePath) {
        double totalSum = 0;
        double totalSum1 = 0;
        double totalSum2 = 0;
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = StreamingReader.builder().open(fis);
            Sheet sheet = workbook.getSheetAt(0);
            int feeNameIndex = 3;
            int amountColumnIndex = 4;
            for (Row row : sheet) {
                Cell feeCell = row.getCell(feeNameIndex);
                String feeStr = feeCell.getStringCellValue();

                if (feeStr != null && feeStr.equals("Order Processing Fee")) {
                    Cell amountCell = row.getCell(amountColumnIndex);
                    double amountValue = amountCell.getNumericCellValue();
                    if (amountCell != null) {
                        totalSum1 += amountValue;
                    }
                }

                Cell feeCell2 = row.getCell(feeNameIndex);
                String feeStr2 = feeCell2.getStringCellValue();
                if (feeStr2 != null && feeStr2.contains("Order Processing Fee - correction for undercharge")) {
                    // Get the amount from the specified column
                    Cell amountCell = row.getCell(amountColumnIndex);
                    double amountValue = amountCell.getNumericCellValue();
                    if (amountCell != null) {
                        // Add the amount to the total sum
                        totalSum2 += amountValue;
                    }
                }
            }

            // Print the total sum of commission amounts
            totalSum = totalSum1 + totalSum2;
            System.out.printf("Total sum of Order Processing Fee + Order Processing Fee - correction for undercharge: ");
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
