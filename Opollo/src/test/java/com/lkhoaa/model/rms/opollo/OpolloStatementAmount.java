package com.lkhoaa.model.rms.opollo;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class OpolloStatementAmount {
    public static double sumOfOPStatementAmount(String filePath) {
        double totalSum = 0;
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = StreamingReader.builder().open(fis);
            Sheet sheet = workbook.getSheet("Sale Out");

            for (Row row : sheet) {
                Cell cell = row.getCell(19); //T
                if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                    totalSum += cell.getNumericCellValue();
                }
            }

            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalSum;
    }
}
