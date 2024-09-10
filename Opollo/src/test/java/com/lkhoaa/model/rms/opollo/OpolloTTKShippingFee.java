package com.lkhoaa.model.rms.opollo;

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
        double sum3 = 0;
        double sum4 = 0;
        double sum5 = 0;
        double sum6 = 0;
        double sum7 = 0;
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = StreamingReader.builder().open(fis);
            Sheet sheet = workbook.getSheet("Shipping Fee");

            for (Row row : sheet) {
//                Cell cell1= row.getCell(21); //V
//                if (cell1 != null && cell1.getCellType() == CellType.NUMERIC) {
//                    sum1 += 0 - cell1.getNumericCellValue();
//                }
//
//                Cell cell2 = row.getCell(22); //W
//                if (cell2 != null && cell2.getCellType() == CellType.NUMERIC) {
//                    sum2 += 0 - cell2.getNumericCellValue();
//                }
//
//                Cell cell3 = row.getCell(23); //X
//                if (cell3 != null && cell3.getCellType() == CellType.NUMERIC) {
//                    sum3 += 0 - cell3.getNumericCellValue();
//                }
//
                Cell cell4 = row.getCell(24); //Y
                if (cell4 != null && cell4.getCellType() == CellType.NUMERIC) {
                    sum4 += cell4.getNumericCellValue();
                }
//
//                Cell cell5 = row.getCell(25); //Z
//                if (cell5 != null && cell5.getCellType() == CellType.NUMERIC) {
//                    sum5 += 0 - cell5.getNumericCellValue();
//                }
//
//                Cell cell6 = row.getCell(26); //AA
//                if (cell6 != null && cell6.getCellType() == CellType.NUMERIC) {
//                    sum6 += cell6.getNumericCellValue();
//                }
            }
//            System.out.printf("Total sum of Shipping fee on OP: ");
//            System.out.printf("%.2f\n", totalSum);
            totalSum = sum1 + sum2 + sum3 + sum4 + sum5 + sum6;
            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalSum;
    }
}
