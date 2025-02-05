package com.lkhoaa.testCases.rms;

import static com.lkhoaa.model.rms.compareFormular.CalculateLazadaFee.compareExcelSums;

public class CompareOneFileLazada {
    public static void main(String[] args) {
        String fileName = "lzdmde";
        String fileFullName = fileName + ".xlsx";
        compareExcelSums(fileFullName);
    }
}
