package com.lkhoaa.testCases.rms;

import static com.lkhoaa.model.rms.compareFormular.CalculatePlatformDataFee.comparePlatformFee;

public class ComparePlatformFee {
    public static void main(String[] args) {
        String fileName = "cbb";
        String fileFullName = fileName + ".xlsx";
        comparePlatformFee(fileFullName);
    }
}
