package com.lkhoaa.model.RMS.Opollo;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.apache.commons.math3.util.FastMath.abs;

public class OpolloTTKShippingFee {
    public static double sumOfOPShippingFee(String filePath) {
        double totalSum = 0;
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = StreamingReader.builder().open(fis);
            Sheet sheet = workbook.getSheet("Shipping Fee");

            for (Row row : sheet) {
                Cell cell1 = row.getCell(7); //H
                if (cell1 != null && cell1.getCellType() == CellType.NUMERIC) {
                    totalSum += cell1.getNumericCellValue();
                }
            }

            System.out.printf("Total sum of Shipping fee on OP: ");
            System.out.printf("%.2f\n", abs(totalSum));

            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalSum;
    }
}
