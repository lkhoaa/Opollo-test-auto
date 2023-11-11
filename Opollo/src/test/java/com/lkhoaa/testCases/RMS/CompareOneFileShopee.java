package com.lkhoaa.testCases.RMS;

import static com.lkhoaa.testCases.RMS.CalculateShopeeFee.compareSPFee;

public class CompareOneFileShopee {
    public static void main(String[] args) {
        String fileName = "JNJ";
        String fileFullName = fileName + ".xlsx";
        compareSPFee(fileFullName);
    }
}