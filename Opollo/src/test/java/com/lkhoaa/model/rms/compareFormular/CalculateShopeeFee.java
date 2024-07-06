package com.lkhoaa.model.rms.compareFormular;

import java.io.File;

import static com.lkhoaa.model.rms.opollo.OpolloCommissionFee.sumOfOPCommissionFee;
import static com.lkhoaa.model.rms.opollo.OpolloPaymentFee.sumOfOPPaymentFee;
import static com.lkhoaa.model.rms.opollo.OpolloSPRevenue.sumOfOPRevenue;
import static com.lkhoaa.model.rms.opollo.OpolloSPShippingFee.sumOfOPShippingFee;
import static com.lkhoaa.model.rms.opollo.OpolloSPShopeeDiscount.sumOfOPShopeeDiscountFee;
import static com.lkhoaa.model.rms.opollo.OpolloSellerVoucherFee.sumOfOPSellerVoucherFee;
import static com.lkhoaa.model.rms.shopee.ShopeeCommissionFee.sumOfCommissionFee;
import static com.lkhoaa.model.rms.shopee.ShopeeDiscountFee.sumOfShopeeDiscountFee;
import static com.lkhoaa.model.rms.shopee.ShopeePaymentFee.sumOfPaymentFee;
import static com.lkhoaa.model.rms.shopee.ShopeeRevenue.sumOfSPRevenue;
import static com.lkhoaa.model.rms.shopee.ShopeeSellerVoucherFee.sumOfSellerVoucherFee;
import static com.lkhoaa.model.rms.shopee.ShopeeShippingFee.sumOfShippingFee;
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
        System.out.println("SPE" + excellFileName.toUpperCase());

        File filePath1 = new File(System.getProperty("user.dir") + "/Opollo/src/test/data/Shopee/" + excellFileName);
        File filePath2 = new File(System.getProperty("user.dir") + "/Opollo/src/test/data/Opollo/" + excellFileName);

        commissionSPFee = sumOfCommissionFee(String.valueOf(filePath1));
        commissionOPFee = sumOfOPCommissionFee(String.valueOf(filePath2));

        paymentSPFee = sumOfPaymentFee(String.valueOf(filePath1));
        paymentOPFee = sumOfOPPaymentFee(String.valueOf(filePath2));

        sellerVoucherSPFee = sumOfSellerVoucherFee(String.valueOf(filePath1));
        sellerVoucherOPFee = sumOfOPSellerVoucherFee(String.valueOf(filePath2));

        shippingSPFee = sumOfShippingFee(String.valueOf(filePath1));
        shippingOPFee = sumOfOPShippingFee(String.valueOf(filePath2));

        SPRevenue = sumOfSPRevenue(String.valueOf(filePath1));
        OPRevenue = sumOfOPRevenue(String.valueOf(filePath2));

        SPShopeDiscountFee = sumOfShopeeDiscountFee(String.valueOf(filePath1));
        OPShopeeDiscountFee = sumOfOPShopeeDiscountFee(String.valueOf(filePath2));
        compareAllFee();
        System.out.println("=====================================");
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
            System.out.println("==>> OK");
        } else {
            System.out.println("==>> The values are not equal.");
        }
    }
}
