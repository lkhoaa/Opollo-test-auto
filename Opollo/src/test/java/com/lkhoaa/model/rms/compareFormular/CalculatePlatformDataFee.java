package com.lkhoaa.model.rms.compareFormular;

import java.io.File;

import static com.lkhoaa.model.rms.platformRec.EscrowAmountOP.sumOfOPEscrowAmountOP;
import static com.lkhoaa.model.rms.shopee.EscrowAmountSP.sumOfEscrowAmountSP;

public class CalculatePlatformDataFee {
    public static void comparePlatformFee(String fileName){
        String excelFileName = fileName;
        System.out.println(excelFileName);

        File filePath1 = new File(System.getProperty("user.dir") + "/Opollo/src/test/data/Shopee/" + excelFileName);
        File filePath2 = new File(System.getProperty("user.dir") + "/Opollo/src/test/data/PlatformData/" + excelFileName);

        double escrowAmountFeeSP = sumOfEscrowAmountSP(String.valueOf(filePath1));
        double escrowAmountFeeOP = sumOfOPEscrowAmountOP(String.valueOf(filePath2));
        compareSums(escrowAmountFeeSP, escrowAmountFeeOP);
        System.out.println("--------------------------------");
    }

    public static void compareSums(double sum1, double sum2) {
        if (sum1 == sum2) {
            System.out.println("OK");
        } else {
            System.out.println("The sums are not equal.");
        }
    }
}
