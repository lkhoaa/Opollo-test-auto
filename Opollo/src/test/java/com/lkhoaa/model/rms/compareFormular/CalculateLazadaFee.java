package com.lkhoaa.model.rms.compareFormular;

import io.qameta.allure.Step;

import java.io.File;

import static com.lkhoaa.model.rms.lazada.LZDCommissionFee.sumOfLzdCommisionFee;
import static com.lkhoaa.model.rms.lazada.LZDDamageFee.sumOfLzdDamageFee;
import static com.lkhoaa.model.rms.lazada.LZDFreeShippingMaxFee.sumOfLzdFreeShippingMaxFee;
import static com.lkhoaa.model.rms.lazada.LZDLCPFee.sumOfLzdLCPFee;
import static com.lkhoaa.model.rms.lazada.LZDLostFee.sumOfLzdLostFee;
import static com.lkhoaa.model.rms.lazada.LZDLzdSubsidyFee.sumOfLzdLzdsubsidyFee;
import static com.lkhoaa.model.rms.lazada.LZDLzdcoinDiscountFee.sumOfLzdLzdcoinDiscountFee;
import static com.lkhoaa.model.rms.lazada.LZDPaymentFee.sumOfLzdPaymentFee;
import static com.lkhoaa.model.rms.lazada.LZDPromotionalChargesFlexiCombo.sumOfLzdPromotionalChargesFlexiCombo;
import static com.lkhoaa.model.rms.lazada.LZDRevenueCompleted.sumOfLzdRevenueCompletedFee;
import static com.lkhoaa.model.rms.lazada.LZDRevenueReturned.sumOfLzdRevenueReturnedFee;
import static com.lkhoaa.model.rms.lazada.LZDSellerVoucherFee.sumOfLzdSellerVoucherFee;
import static com.lkhoaa.model.rms.lazada.LZDShippingFee.sumOfLzdShippingFee;
import static com.lkhoaa.model.rms.lazada.LZDSponsoredAffiliateFee.sumOfLzdSponsoredAffiliateFee;
import static com.lkhoaa.model.rms.lazada.LZDWrongweightadjustmentFee.sumOfLzdWrongweightadjustmentFee;
import static com.lkhoaa.model.rms.opollo.OPRevenueCompleted.sumOfOPRevenueCompletedFee;
import static com.lkhoaa.model.rms.opollo.OPRevenueReturned.sumOfOPRevenueReturnedFee;
import static com.lkhoaa.model.rms.opollo.OpolloCommissionFee.sumOfOPCommissionFee;
import static com.lkhoaa.model.rms.opollo.OpolloDamageFee.sumOfOPDamageFee;
import static com.lkhoaa.model.rms.opollo.OpolloFreeShippingMaxFee.sumOfOPFreeShippingMaxFee;
import static com.lkhoaa.model.rms.opollo.OpolloLCPFee.sumOfOPLCPFee;
import static com.lkhoaa.model.rms.opollo.OpolloLostFee.sumOfOPLostFee;
import static com.lkhoaa.model.rms.opollo.OpolloLzdSubsidyFee.sumOfOPLzdsubsidyFee;
import static com.lkhoaa.model.rms.opollo.OpolloLzdcoinDiscountFee.sumOfOPLzdcoinDiscountFee;
import static com.lkhoaa.model.rms.opollo.OpolloPaymentFee.sumOfOPPaymentFee;
import static com.lkhoaa.model.rms.opollo.OpolloPromotionalChargesFlexiCombo.sumOfOPPromotionalChargesFlexiCombo;
import static com.lkhoaa.model.rms.opollo.OpolloSellerVoucherFee.sumOfOPSellerVoucherFee;
import static com.lkhoaa.model.rms.opollo.OpolloLZDShippingFee.sumOfOPShippingFee;
import static com.lkhoaa.model.rms.opollo.OpolloSponsoredAffiliateFee.sumOfOPSponsoredAffiliateFee;
import static com.lkhoaa.model.rms.opollo.OpolloWrongweightadjustmentFee.sumOfOPWrongweightadjustmentFee;

public class CalculateLazadaFee {
    @Step
    public static void compareExcelSums(String fileName){
        String excelFileName = fileName;
        System.out.println(excelFileName);

        File filePath1 = new File(System.getProperty("user.dir") + "/Opollo/src/test/data/LZD/" + excelFileName);
        File filePath2 = new File(System.getProperty("user.dir") + "/Opollo/src/test/data/Opollo/" + excelFileName);

        double revenueCompletedLZDFee = sumOfLzdRevenueCompletedFee(String.valueOf(filePath1));
        double revenueCompletedOPFee = sumOfOPRevenueCompletedFee(String.valueOf(filePath2));
        compareSums(revenueCompletedLZDFee, revenueCompletedOPFee);

        double revenueReturnedLZDFee = sumOfLzdRevenueReturnedFee(String.valueOf(filePath1));
        double revenueReturnedOPFee = sumOfOPRevenueReturnedFee(String.valueOf(filePath2));
        compareSums(revenueReturnedLZDFee, revenueReturnedOPFee);

        double lostClaimLZDFee = sumOfLzdLostFee(String.valueOf(filePath1));
        double lostClaimOPFee = sumOfOPLostFee(String.valueOf(filePath2));
        compareSums(lostClaimLZDFee, lostClaimOPFee);

        double damagedClaimLZDFee = sumOfLzdDamageFee(String.valueOf(filePath1));
        double damagedClaimOPFee = sumOfOPDamageFee(String.valueOf(filePath2));
        compareSums(damagedClaimLZDFee, damagedClaimOPFee);

        double sellerVoucherLZDFee = sumOfLzdSellerVoucherFee(String.valueOf(filePath1));
        double sellerVoucherOPFee = sumOfOPSellerVoucherFee(String.valueOf(filePath2));
        compareSums(sellerVoucherLZDFee, sellerVoucherOPFee);

        double commissionLZDFee = sumOfLzdCommisionFee(String.valueOf(filePath1));
        double commissionOPFee = sumOfOPCommissionFee(String.valueOf(filePath2));
        compareSums(commissionLZDFee, commissionOPFee);

        double paymentLZDFee = sumOfLzdPaymentFee(String.valueOf(filePath1));
        double paymentOPFee = sumOfOPPaymentFee(String.valueOf(filePath2));
        compareSums(paymentLZDFee, paymentOPFee);

        double lzdsubsidyLZDFee = sumOfLzdLzdsubsidyFee(String.valueOf(filePath1));
        double lzdsubsidyOPFee = sumOfOPLzdsubsidyFee(String.valueOf(filePath2));
        compareSums(lzdsubsidyLZDFee, lzdsubsidyOPFee);

        double lzdcoinDiscountLZDFee = sumOfLzdLzdcoinDiscountFee(String.valueOf(filePath1));
        double lzdcoinDiscountOPFee = sumOfOPLzdcoinDiscountFee(String.valueOf(filePath2));
        compareSums(lzdcoinDiscountLZDFee, lzdcoinDiscountOPFee);

        double promotionalChargesFlexiComboLZDFee = sumOfLzdPromotionalChargesFlexiCombo(String.valueOf(filePath1));
        double promotionalChargesFlexiComboOPFee = sumOfOPPromotionalChargesFlexiCombo(String.valueOf(filePath2));
        compareSums(promotionalChargesFlexiComboLZDFee, promotionalChargesFlexiComboOPFee);

        double freeShippingMaxLZDFee = sumOfLzdFreeShippingMaxFee(String.valueOf(filePath1));
        double freeShippingMaxOPFee = sumOfOPFreeShippingMaxFee(String.valueOf(filePath2));
        compareSums(freeShippingMaxLZDFee, freeShippingMaxOPFee);

        double shippingFeeLZDFee = sumOfLzdShippingFee(String.valueOf(filePath1));
        double shippingFeeOPFee = sumOfOPShippingFee(String.valueOf(filePath2));
        compareSums(shippingFeeLZDFee, shippingFeeOPFee);

        double lcpFeeLZDFee = sumOfLzdLCPFee(String.valueOf(filePath1));
        double lcpFeeOPFee = sumOfOPLCPFee(String.valueOf(filePath2));
        compareSums(lcpFeeLZDFee, lcpFeeOPFee);

        double sponsoredAffiliatesLZDFee = sumOfLzdSponsoredAffiliateFee(String.valueOf(filePath1));
        double sponsoredAffiliatesOPFee = sumOfOPSponsoredAffiliateFee(String.valueOf(filePath2));
        compareSums(sponsoredAffiliatesLZDFee, sponsoredAffiliatesOPFee);

        double wrongWeightAdjustmentLZDFee = sumOfLzdWrongweightadjustmentFee(String.valueOf(filePath1));
        double wrongWeightAdjustmentOPFee = sumOfOPWrongweightadjustmentFee(String.valueOf(filePath2));
        compareSums(wrongWeightAdjustmentLZDFee, wrongWeightAdjustmentOPFee);
        System.out.println("--------------------------------");
    }

    @Step("Compare the sums of two Excel files")
    public static void compareSums(double sum1, double sum2) {
        if (sum1 == sum2) {
            System.out.println("The sums are equal.");
        } else {
            System.out.println("The sums are not equal.");
        }
    }
}
