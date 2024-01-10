package com.lkhoaa.testCases.RMS;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.lkhoaa.model.RMS.FormulaCompare.CalculateLazadaFee.compareExcelSums;

public class CompareAllFileLazada {

    public static void main(String[] args) {
        String folderPath = System.getProperty("user.dir") + "/Opollo/src/test/data/LZD/";

        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        if (files != null) {
            List<String> fileNames = new ArrayList<>();

            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".xlsx")) {
                    String fileName = file.getName();
                    fileNames.add(fileName);
                }
            }

            for (String fileName : fileNames) {
                compareExcelSums(fileName);
            }
        }
    }
}
