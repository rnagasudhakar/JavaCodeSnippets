package org.example.designPatterns.Factory;

public class AmritaFeeCalculator implements FeeCalculator {


    @Override
    public int getTotalFee() {
        return 600000;
    }

    @Override
    public int getHostelFee() {
        return 100000;
    }

    @Override
    public int getTutionFee() {
        return 500000;
    }
}
