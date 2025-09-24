package org.example.designPatterns.Factory;

public   class FeeCalculatorFactory {

    public static  FeeCalculator getFeeCalculator(String college){
        switch (college){
            case "SRM":
                return new SRMFeeCalculator();
            case "VIT":
                return new VITFeeCalculator();
            default:
                return new AmritaFeeCalculator();
        }
    }

}
