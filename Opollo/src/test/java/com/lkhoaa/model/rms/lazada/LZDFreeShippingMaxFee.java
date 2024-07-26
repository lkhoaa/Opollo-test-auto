package com.lkhoaa.model.rms.lazada;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class LZDFreeShippingMaxFee {
    public static double sumOfLzdFreeShippingMaxFee(String filePath) {
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
                if (feeStr != null && feeStr.equals("Free Shipping Max Fee")) {
                    Cell amountCell = row.getCell(amountColumnIndex);
                    double amountValue = amountCell.getNumericCellValue();
                    totalSum1 += amountValue;
                }

                Cell feeCell2 = row.getCell(feeNameIndex);
                String feeStr2 = feeCell2.getStringCellValue();
                if (feeStr2 != null && feeStr2.equals("Reversal of Free Shipping Max Fee")) {
                    Cell amountCell = row.getCell(amountColumnIndex);
                    double amountValue = amountCell.getNumericCellValue();
                    totalSum2 += amountValue;
                }
            }

            // Print the total sum of commission amounts
            totalSum = totalSum1 + totalSum2;
            System.out.printf("Total sum of Free Shipping Max Fee + Reversal on LZD: ");
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
