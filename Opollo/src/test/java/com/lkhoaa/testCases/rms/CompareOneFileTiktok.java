package com.lkhoaa.testCases.rms;

import static com.lkhoaa.model.rms.compareFormular.CalculateTTKFee.compareTTKFee;

public class CompareOneFileTiktok {
    public static void main(String[] args) {
        String fileName = "test";
        String fileFullName = fileName + ".xlsx";
        compareTTKFee(fileFullName);
    }
}
