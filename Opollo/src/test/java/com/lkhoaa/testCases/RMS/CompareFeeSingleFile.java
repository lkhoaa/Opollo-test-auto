package com.lkhoaa.testCases.RMS;

import io.qameta.allure.Description;

import static com.lkhoaa.testCases.RMS.CalculateLZDFee.compareExcelSums;

public class CompareFeeSingleFile {
    @Description("Compare 2 commission fee in 2 files")
    public static void main(String[] args) {
        String fileName = "LZDRMN";
        String fileFullName = fileName + ".xlsx";
        compareExcelSums(fileFullName);
    }
}