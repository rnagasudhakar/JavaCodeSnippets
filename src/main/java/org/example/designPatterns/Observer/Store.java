package org.example.designPatterns.Observer;

public class Store {

    public static void main(String[] args){

        StockObservable iphoneStockObservableImpl = new IphoneStockObservableImpl();

        ItemObserver observerOne = new Observer1();

        iphoneStockObservableImpl.addObserver(observerOne);

        iphoneStockObservableImpl.updateStock(10);



    }

}
