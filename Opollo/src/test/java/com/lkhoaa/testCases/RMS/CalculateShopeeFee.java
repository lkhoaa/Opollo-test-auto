package com.lkhoaa.testCases.RMS;

import java.io.File;

import static com.lkhoaa.model.RMS.Opollo.OpolloCommissionFee.sumOfOPCommissionFee;
import static com.lkhoaa.model.RMS.Opollo.OpolloPaymentFee.sumOfOPPaymentFee;
import static com.lkhoaa.model.RMS.Opollo.OpolloSPRevenue.sumOfOPRevenue;
import static com.lkhoaa.model.RMS.Opollo.OpolloSPShippingFee.sumOfOPShippingFee;
import static com.lkhoaa.model.RMS.Opollo.OpolloSPShopeeDiscount.sumOfOPShopeeDiscountFee;
import static com.lkhoaa.model.RMS.Opollo.OpolloSellerVoucherFee.sumOfOPSellerVoucherFee;
import static com.lkhoaa.model.RMS.Shopee.ShopeeCommissionFee.sumOfCommissionFee;
import static com.lkhoaa.model.RMS.Shopee.ShopeeDiscountFee.sumOfShopeeDiscountFee;
import static com.lkhoaa.model.RMS.Shopee.ShopeePaymentFee.sumOfPaymentFee;
import static com.lkhoaa.model.RMS.Shopee.ShopeeRevenue.sumOfSPRevenue;
import static com.lkhoaa.model.RMS.Shopee.ShopeeSellerVoucherFee.sumOfSellerVoucherFee;
import static com.lkhoaa.model.RMS.Shopee.ShopeeShippingFee.sumOfShippingFee;
import static java.lang.Math.abs;

public class CalculateShopeeFee {
    private static double commissionSPFee;
    private static double commissionOPFee;
    private static double paymentSPFee;
    private static double paymentOPFee;
    private static double sellerVoucherSPFee;
    private static double sellerVoucherOPFee;
    private static double shippingSPFee;
    private static double shippingOPFee;
    private static double SPShopeDiscountFee;
    private static double OPShopeeDiscountFee;
    private static double SPRevenue;
    private static double OPRevenue;

    public static void compareSPFee(String fileName) {
        String excellFileName = fileName;
        System.out.println(excellFileName);

        File filePath1 = new File(System.getProperty("user.dir") + "/Opollo/src/test/data/Shopee/" + excellFileName);
        File filePath2 = new File(System.getProperty("user.dir") + "/Opollo/src/test/data/Opollo/" + excellFileName);

        commissionSPFee = sumOfCommissionFee(String.valueOf(filePath1));
        commissionOPFee = sumOfOPCommissionFee(String.valueOf(filePath2));
//        compareSum(commissionSPFee,commissionOPFee);

        paymentSPFee = sumOfPaymentFee(String.valueOf(filePath1));
        paymentOPFee = sumOfOPPaymentFee(String.valueOf(filePath2));
//        compareSum(paymentSPFee,paymentOPFee);

        sellerVoucherSPFee = sumOfSellerVoucherFee(String.valueOf(filePath1));
        sellerVoucherOPFee = sumOfOPSellerVoucherFee(String.valueOf(filePath2));
//        compareSum(sellerVoucherSPFee,sellerVoucherOPFee);

        shippingSPFee = sumOfShippingFee(String.valueOf(filePath1));
        shippingOPFee = sumOfOPShippingFee(String.valueOf(filePath2));
//        compareSum(shippingSPFee,shippingOPFee);

        SPRevenue = sumOfSPRevenue(String.valueOf(filePath1));
        OPRevenue = sumOfOPRevenue(String.valueOf(filePath2));
//        compareSum(SPRevenue,OPRevenue);

        SPShopeDiscountFee = sumOfShopeeDiscountFee(String.valueOf(filePath1));
        OPShopeeDiscountFee = sumOfOPShopeeDiscountFee(String.valueOf(filePath2));
//        compareSum(SPShopeDiscountFee,OPShopeeDiscountFee);
        compareAllFee();
        System.out.println("=====================================");
    }

    public static void compareSum(double sum1, double sum2) {
        double tolerance = 0.0001;
        if (Math.abs(sum1 - sum2) < tolerance) {
            System.out.println("The values are equal.");
        } else {
            System.out.println("The values are not equal.");
        }
    }

    public static void compareAllFee() {
        double tolerance = 0.0001;
        System.out.println(abs(SPRevenue - OPRevenue));
        if ((abs(abs(commissionSPFee - commissionOPFee)
                - abs(paymentSPFee - paymentOPFee)
                - abs(sellerVoucherSPFee - sellerVoucherOPFee)
                - abs(shippingSPFee - shippingOPFee)
                - abs(SPShopeDiscountFee - OPShopeeDiscountFee)
                - abs(SPRevenue - OPRevenue)))
                < tolerance) {
            System.out.println("==>> The values are equal.");
        } else {
            System.out.println("==>> The values are not equal.");
        }
    }
}
