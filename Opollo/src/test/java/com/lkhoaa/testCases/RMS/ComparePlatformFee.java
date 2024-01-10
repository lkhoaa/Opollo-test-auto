package com.lkhoaa.testCases.RMS;

import static com.lkhoaa.model.RMS.FormulaCompare.CalculatePlatformDataFee.comparePlatformFee;

public class ComparePlatformFee {
    public static void main(String[] args) {
        String fileName = "cbb";
        String fileFullName = fileName + ".xlsx";
        comparePlatformFee(fileFullName);
    }
}
