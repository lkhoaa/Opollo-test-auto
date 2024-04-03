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
        double sum1 = 0;
        double sum2 = 0;
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = StreamingReader.builder().open(fis);
            Sheet sheet = workbook.getSheet("Shipping Fee");

            for (Row row : sheet) {
                Cell cell = row.getCell(20); //U
                if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                    totalSum += cell.getNumericCellValue();
                }
            }
//            System.out.printf("Total sum of Shipping fee on OP: ");
//            System.out.printf("%.2f\n", totalSum);
            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalSum;
    }
}
