package com.lkhoaa.model.rms.opollo;

import com.monitorjbl.xlsx.StreamingReader;
import io.qameta.allure.Step;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class OpolloWrongweightadjustmentFee {
    @Step("Opollo file: Calculate the sum of the column amount in the 'Wrong Weight Adjustment' sheet")
    public static double sumOfOPWrongweightadjustmentFee(String filePath) {
        double totalSum = 0;
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = StreamingReader.builder().open(fis);
            Sheet sheet = workbook.getSheet("Wrong weight adjustment");

            int amountColumnIndex = 7;

            for (Row row : sheet) {
                Cell cell = row.getCell(amountColumnIndex);
                if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                    double amountCell = cell.getNumericCellValue();
                    totalSum += 0-amountCell;
                }
            }

            // Print the total sum of commission amounts
            System.out.printf("Total sum of Wrong Weight Adjustment amounts on OP: ");
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
