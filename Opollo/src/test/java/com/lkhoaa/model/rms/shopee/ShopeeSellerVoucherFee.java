package com.lkhoaa.model.rms.shopee;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class ShopeeSellerVoucherFee {
    public static double sumOfSellerVoucherFee(String filePath) {
        double totalSum = 0;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = StreamingReader.builder().open(fis);

            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                if (workbook.getSheetName(i).startsWith("Income")) {
                    Sheet incomeSheet = workbook.getSheetAt(i);
                    for (Row row : incomeSheet) {
                        Cell cell = row.getCell(11); //L
                        if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                            totalSum += cell.getNumericCellValue();
                        }
                    }
                }
            }

            System.out.printf("Total sum of Seller Voucher fee on SP: ");
            System.out.printf("%.2f\n", totalSum);
            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalSum;
    }
}
