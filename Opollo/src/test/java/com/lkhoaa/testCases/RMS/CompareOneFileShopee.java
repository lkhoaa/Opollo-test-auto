package com.lkhoaa.testCases.RMS;

import static com.lkhoaa.model.RMS.FormulaCompare.CalculateShopeeFee.compareSPFee;

public class CompareOneFileShopee {
    public static void main(String[] args) {
        String fileName = "rma";
        String fileFullName = fileName + ".xlsx";
        compareSPFee(fileFullName);
    }
}