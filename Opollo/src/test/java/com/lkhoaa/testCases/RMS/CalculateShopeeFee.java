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
    public static void compareSPFee(String fileName) {
        String excellFileName = fileName;
        System.out.println(excellFileName);

        File filePath1 =  new File(System.getProperty("user.dir") + "/Opollo/src/test/data/Shopee/" + excellFileName);
        File filePath2 =  new File(System.getProperty("user.dir") + "/Opollo/src/test/data/Opollo/" + excellFileName);

        double commissionSPFee = sumOfCommissionFee(String.valueOf(filePath1));
        double commissionOPFee = sumOfOPCommissionFee(String.valueOf(filePath2));
        compareSum(commissionSPFee,commissionOPFee);

        double paymentSPFee = sumOfPaymentFee(String.valueOf(filePath1));
        double paymentOPFee = sumOfOPPaymentFee(String.valueOf(filePath2));
        compareSum(paymentSPFee,paymentOPFee);

        double sellerVoucherSPFee = sumOfSellerVoucherFee(String.valueOf(filePath1));
        double sellerVoucherOPFee = sumOfOPSellerVoucherFee(String.valueOf(filePath2));
        compareSum(sellerVoucherSPFee,sellerVoucherOPFee);

        double ShippingSPFee = sumOfShippingFee(String.valueOf(filePath1));
        double ShippingOPFee = sumOfOPShippingFee(String.valueOf(filePath2));
        compareSum(ShippingSPFee,ShippingOPFee);

        double SPRevenue = sumOfSPRevenue(String.valueOf(filePath1));
        double OPRevenue = sumOfOPRevenue(String.valueOf(filePath2));
        compareSum(SPRevenue,OPRevenue);

        double SPShopeDiscount = sumOfShopeeDiscountFee(String.valueOf(filePath1));
        double OPShopeeDiscount = sumOfOPShopeeDiscountFee(String.valueOf(filePath2));
        compareSum(SPShopeDiscount,OPShopeeDiscount);
        System.out.println("<=====================================>");
    }

    public static void compareSum(double sum1, double sum2) {
        double tolerance = 0.0001;
        if (Math.abs((sum1 - sum2)) < tolerance) {
            System.out.println("The values are equal.");
        } else {
            System.out.println("The values are not equal.");
        }
    }
}
