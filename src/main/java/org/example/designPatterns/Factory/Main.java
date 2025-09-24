package org.example.designPatterns.Factory;


public class Main {

    public static void main(String[] args) {

        FeeCalculator feeCalculator = FeeCalculatorFactory.getFeeCalculator("VIT");

        int score = feeCalculator.getHostelFee();

        System.out.print(score);

    }

}
