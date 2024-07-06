package com.lkhoaa.testCases.rms;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import static com.lkhoaa.model.rms.compareFormular.CalculateTTKFee.compareTTKFee;

public class CompareAllFileTiktok {
    public static void main(String[] args) {
        String folderPath = System.getProperty("user.dir") + "/Opollo/src/test/data/Opollo/";

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
                compareTTKFee(fileName);
            }
        }
    }
}
