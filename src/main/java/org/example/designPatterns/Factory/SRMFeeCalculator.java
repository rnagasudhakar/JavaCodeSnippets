package org.example.designPatterns.Factory;

public class SRMFeeCalculator implements FeeCalculator{
    @Override
    public int getTotalFee() {
        return 800000;
    }

    @Override
    public int getHostelFee() {
        return 200000;
    }

    @Override
    public int getTutionFee() {
        return 600000;
    }
}
