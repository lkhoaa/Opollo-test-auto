package com.lkhoaa.testCases.RMS;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

import java.io.File;

import static com.lkhoaa.model.RMS.LZD.LZDCommissionFee.sumOfLzdCommisionFee;
import static com.lkhoaa.model.RMS.LZD.LZDDamageFee.sumOfLzdDamageFee;
import static com.lkhoaa.model.RMS.LZD.LZDFreeShippingMaxFee.sumOfLzdFreeShippingMaxFee;
import static com.lkhoaa.model.RMS.LZD.LZDLCPFee.sumOfLzdLCPFee;
import static com.lkhoaa.model.RMS.LZD.LZDLostFee.sumOfLzdLostFee;
import static com.lkhoaa.model.RMS.LZD.LZDLzdSubsidyFee.sumOfLzdLzdsubsidyFee;
import static com.lkhoaa.model.RMS.LZD.LZDLzdcoinDiscountFee.sumOfLzdLzdcoinDiscountFee;
import static com.lkhoaa.model.RMS.LZD.LZDPaymentFee.sumOfLzdPaymentFee;
import static com.lkhoaa.model.RMS.LZD.LZDPromotionalChargesFlexiCombo.sumOfLzdPromotionalChargesFlexiCombo;
import static com.lkhoaa.model.RMS.LZD.LZDRevenueCompleted.sumOfLzdRevenueCompletedFee;
import static com.lkhoaa.model.RMS.LZD.LZDRevenueReturned.sumOfLzdRevenueReturnedFee;
import static com.lkhoaa.model.RMS.LZD.LZDSellerVoucherFee.sumOfLzdSellerVoucherFee;
import static com.lkhoaa.model.RMS.LZD.LZDShippingFee.sumOfLzdShippingFee;
import static com.lkhoaa.model.RMS.LZD.LZDSponsoredAffiliateFee.sumOfLzdSponsoredAffiliateFee;
import static com.lkhoaa.model.RMS.LZD.LZDWrongweightadjustmentFee.sumOfLzdWrongweightadjustmentFee;
import static com.lkhoaa.model.RMS.Opollo.OPRevenueCompleted.sumOfOPRevenueCompletedFee;
import static com.lkhoaa.model.RMS.Opollo.OPRevenueReturned.sumOfOPRevenueReturnedFee;
import static com.lkhoaa.model.RMS.Opollo.OpolloCommissionFee.sumOfOPCommissionFee;
import static com.lkhoaa.model.RMS.Opollo.OpolloDamageFee.sumOfOPDamageFee;
import static com.lkhoaa.model.RMS.Opollo.OpolloFreeShippingMaxFee.sumOfOPFreeShippingMaxFee;
import static com.lkhoaa.model.RMS.Opollo.OpolloLCPFee.sumOfOPLCPFee;
import static com.lkhoaa.model.RMS.Opollo.OpolloLostFee.sumOfOPLostFee;
import static com.lkhoaa.model.RMS.Opollo.OpolloLzdSubsidyFee.sumOfOPLzdsubsidyFee;
import static com.lkhoaa.model.RMS.Opollo.OpolloLzdcoinDiscountFee.sumOfOPLzdcoinDiscountFee;
import static com.lkhoaa.model.RMS.Opollo.OpolloPaymentFee.sumOfOPPaymentFee;
import static com.lkhoaa.model.RMS.Opollo.OpolloPromotionalChargesFlexiCombo.sumOfOPPromotionalChargesFlexiCombo;
import static com.lkhoaa.model.RMS.Opollo.OpolloSellerVoucherFee.sumOfOPSellerVoucherFee;
import static com.lkhoaa.model.RMS.Opollo.OpolloShippingFee.sumOfOPShippingFee;
import static com.lkhoaa.model.RMS.Opollo.OpolloSponsoredAffiliateFee.sumOfOPSponsoredAffiliateFee;
import static com.lkhoaa.model.RMS.Opollo.OpolloWrongweightadjustmentFee.sumOfOPWrongweightadjustmentFee;

public class CalculateFee {
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
