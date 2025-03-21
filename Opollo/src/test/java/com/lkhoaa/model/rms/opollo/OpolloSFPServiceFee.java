package com.lkhoaa.model.rms.opollo;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.apache.commons.math3.util.FastMath.abs;

public class OpolloSFPServiceFee {
    public static double sumOfOPSFPServiceFee(String filePath) {
        double totalSum = 0;
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = StreamingReader.builder().open(fis);
            Sheet sheet = workbook.getSheet("SFP Service Fee - Tiktok");

            for (Row row : sheet) {
                Cell cell1 = row.getCell(4); //E
                if (cell1 != null && cell1.getCellType() == CellType.NUMERIC) {
                    totalSum += 0-cell1.getNumericCellValue();
                }
            }

            System.out.printf("Total sum of SFP service fee on OP: ");
            System.out.printf("%.2f\n", totalSum);

            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalSum;
    }
}
