package com.lkhoaa.model.RMS.Opollo;

import com.monitorjbl.xlsx.StreamingReader;
import io.qameta.allure.Step;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class OpolloShippingFee {
    @Step("Opollo file: Calculate the sum of the column amount in the 'commission fee' sheet")
    public static double sumOfOPShippingFee(String filePath) {
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
            Sheet sheet = workbook.getSheet("Shipping Fee");

            // Iterate through each row in the sheet
            for (Row row : sheet) {
                // Get the fee name from the specified column
                Cell cell1 = row.getCell(6);
                if (cell1 != null && cell1.getCellType() == CellType.NUMERIC) {
                    totalSum1 += cell1.getNumericCellValue();
                }

                Cell cell2 = row.getCell(7);
                if (cell2 != null && cell2.getCellType() == CellType.NUMERIC) {
                    totalSum2 += cell2.getNumericCellValue();
                }

                Cell cell3 = row.getCell(8);
                if (cell3 != null && cell3.getCellType() == CellType.NUMERIC) {
                    totalSum3 += cell3.getNumericCellValue();
                }

                Cell cell4 = row.getCell(9);
                if (cell4 != null && cell4.getCellType() == CellType.NUMERIC) {
                    totalSum4 += cell4.getNumericCellValue();
                }

                Cell cell5 = row.getCell(10);
                if (cell5 != null && cell5.getCellType() == CellType.NUMERIC) {
                    totalSum5 += cell5.getNumericCellValue();
                }

                Cell cell6 = row.getCell(11);
                if (cell6 != null && cell6.getCellType() == CellType.NUMERIC) {
                    totalSum6 += cell6.getNumericCellValue();
                }

                Cell cell7 = row.getCell(12);
                if (cell7 != null && cell7.getCellType() == CellType.NUMERIC) {
                    totalSum7 += cell7.getNumericCellValue();
                }

                Cell cell8 = row.getCell(13);
                if (cell8 != null && cell8.getCellType() == CellType.NUMERIC) {
                    totalSum8 += cell8.getNumericCellValue();
                }

                Cell cell9 = row.getCell(14);
                if (cell9 != null && cell9.getCellType() == CellType.NUMERIC) {
                    totalSum9 += cell9.getNumericCellValue();
                }
            }

            // Print the total sum of commission amounts
            totalSum = totalSum1 + totalSum2 + totalSum3 + totalSum4 + totalSum5 + totalSum6 + totalSum7 + totalSum8 + totalSum9;
            System.out.printf("Total sum of Shipping fee on OP: ");
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
