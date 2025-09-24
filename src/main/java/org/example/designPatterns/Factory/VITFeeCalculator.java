package org.example.designPatterns.Factory;

public  class VITFeeCalculator implements FeeCalculator{
    @Override
    public int getTotalFee() {
        return 300000;
    }

    @Override
    public int getHostelFee() {
        return 10000;
    }

    @Override
    public int getTutionFee() {
        return 20000;
    }
}
