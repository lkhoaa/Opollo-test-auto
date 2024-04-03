package com.lkhoaa.testCases.RMS;

import static com.lkhoaa.model.RMS.FormulaCompare.CalculateTTKFee.compareTTKFee;

public class CompareOneFileTiktok {
    public static void main(String[] args) {
        String fileName = "frs";
        String fileFullName = fileName + ".xlsx";
        compareTTKFee(fileFullName);
    }
}
