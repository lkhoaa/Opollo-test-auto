package com.lkhoaa.model.rms.compareFormular;

import java.io.File;

import static com.lkhoaa.model.rms.opollo.OpolloAffCommissionFee.sumOfOPAffCommissionFee;
import static com.lkhoaa.model.rms.opollo.OpolloCommissionFee.sumOfOPCommissionFee;
import static com.lkhoaa.model.rms.opollo.OpolloPaymentFee.sumOfOPPaymentFee;
import static com.lkhoaa.model.rms.opollo.OpolloRevenueTTK.sumOfOPRevenue;
import static com.lkhoaa.model.rms.opollo.OpolloSFPServiceFee.sumOfOPSFPServiceFee;
import static com.lkhoaa.model.rms.opollo.OpolloTTKShippingFee.sumOfOPShippingFee;
import static com.lkhoaa.model.rms.tiktok.TTKAffCommissionFee.sumOfTTKAffCommissionFee;
import static com.lkhoaa.model.rms.tiktok.TTKCommissionFee.sumOfTTKCommissionFee;
import static com.lkhoaa.model.rms.tiktok.TTKPaymentFee.sumOfTTKPaymentFee;
import static com.lkhoaa.model.rms.tiktok.TTKRevenue.sumOfTTKRevenue;
import static com.lkhoaa.model.rms.tiktok.TTKSFPServiceFee.sumOfTTKSFPServiceFee;
import static com.lkhoaa.model.rms.tiktok.TTKShippingFee.sumOfTTKShippingFee;
import static java.lang.Math.abs;

public class CalculateTTKFee {
    private static double commissionTTKFee;
    private static double commissionOPFee;
    private static double paymentTTKFee;
    private static double paymentOPFee;
    private static double shippingTTKFee;
    private static double shippingOPFee;
    private static double SFPServiceTTKFee;
    private static double SFPServiceOPFee;
    private static double affCommissionTTKFee;
    private static double affCommissionOPFee;
    private static double revenueTTK;
    private static double revenueOP;

    public static void compareTTKFee(String fileName) {
        String excellFileName = fileName;
        System.out.println("TTK" + excellFileName.toUpperCase());

        File filePath1 = new File(System.getProperty("user.dir") + "/Opollo/src/test/data/Tiktok/" + excellFileName);
        File filePath2 = new File(System.getProperty("user.dir") + "/Opollo/src/test/data/Opollo/" + excellFileName);

        commissionTTKFee = sumOfTTKCommissionFee(String.valueOf(filePath1));
        commissionOPFee = sumOfOPCommissionFee(String.valueOf(filePath2));

        paymentTTKFee = sumOfTTKPaymentFee(String.valueOf(filePath1));
        paymentOPFee = sumOfOPPaymentFee(String.valueOf(filePath2));

        shippingTTKFee = sumOfTTKShippingFee(String.valueOf(filePath1));
        shippingOPFee = sumOfOPShippingFee(String.valueOf(filePath2));

        affCommissionTTKFee = sumOfTTKAffCommissionFee(String.valueOf(filePath1));
        affCommissionOPFee = sumOfOPAffCommissionFee(String.valueOf(filePath2));

        SFPServiceTTKFee = sumOfTTKSFPServiceFee(String.valueOf(filePath1));
        SFPServiceOPFee = sumOfOPSFPServiceFee(String.valueOf(filePath2));

        revenueTTK = sumOfTTKRevenue(String.valueOf(filePath1));
        revenueOP = sumOfOPRevenue(String.valueOf(filePath2));

        compareAllFee();
        System.out.println("=====================================");
    }

    public static void compareAllFee() {
        double tolerance = 10;
        double differenceCommission = abs(commissionTTKFee - commissionOPFee);
        double differencePayment = abs(paymentTTKFee - paymentOPFee);
        double differenceShipping = abs(shippingTTKFee - shippingOPFee);
        double differenceAffCommission = abs(affCommissionTTKFee - affCommissionOPFee);
        double differenceSFPService = abs(SFPServiceTTKFee - SFPServiceOPFee);
        double differenceRevenue = abs(revenueTTK - revenueOP);
        if ((abs(differenceCommission
                - differencePayment
                - differenceShipping
                - differenceAffCommission
                - differenceSFPService
                - differenceRevenue)) < tolerance) {
            System.out.println("===> OK");
        } else {
            System.out.println("===> The values are not equal.");
            if (differenceCommission > tolerance) {
                System.out.printf("Difference in Commission Fee: ");
                System.out.printf("%.2f\n", differenceCommission);
            }
            if (differencePayment > tolerance) {
                System.out.printf("Difference in Payment Fee: ");
                System.out.printf("%.2f\n", differencePayment);
            }
            if (differenceShipping > tolerance) {
                System.out.printf("Difference in Shipping Fee: ");
                System.out.printf("%.2f\n", differenceShipping);
            }
            if (differenceAffCommission > tolerance) {
                System.out.printf("Difference in Affiliate Commission Fee: ");
                System.out.printf("%.2f\n", differenceAffCommission);
            }
            if (differenceSFPService > tolerance) {
                System.out.printf("Difference in SFP Service Fee: ");
                System.out.printf("%.2f\n", differenceSFPService);
            }
            if (differenceRevenue > tolerance) {
                System.out.printf("Difference in Revenue: ");
                System.out.printf("%.2f\n", differenceRevenue);
            }
        }
    }
}