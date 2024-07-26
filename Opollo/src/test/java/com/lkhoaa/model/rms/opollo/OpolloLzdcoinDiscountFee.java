package com.lkhoaa.model.rms.opollo;

import com.monitorjbl.xlsx.StreamingReader;
import io.qameta.allure.Step;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class OpolloLzdcoinDiscountFee {
    @Step("Opollo file: Calculate the sum of the column amount in the 'Lzdcoin Discount' sheet")
    public static double sumOfOPLzdcoinDiscountFee(String filePath) {
        double totalSum = 0;
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = StreamingReader.builder().open(fis);
            Sheet sheet = workbook.getSheet("Lzdcoin Discount");

            int amountColumnIndex = 10;

            for (Row row : sheet) {
                Cell cell = row.getCell(amountColumnIndex);
                if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                    double amountCell = cell.getNumericCellValue();
                    totalSum += 0-amountCell;
                }
            }

            System.out.printf("Total sum of Lzdcoin Discount amounts on OP: ");
            System.out.printf("%.2f\n", totalSum);

            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalSum;
    }
}
