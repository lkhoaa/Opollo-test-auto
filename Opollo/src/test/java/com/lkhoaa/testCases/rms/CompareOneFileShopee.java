package com.lkhoaa.testCases.rms;

import static com.lkhoaa.model.rms.compareFormular.CalculateShopeeFee.compareSPFee;

public class CompareOneFileShopee {
    public static void main(String[] args) {
        String fileName = "kew";
        String fileFullName = fileName + ".xlsx";
        compareSPFee(fileFullName);
    }
}