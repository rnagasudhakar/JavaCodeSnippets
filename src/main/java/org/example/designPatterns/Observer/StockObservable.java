package org.example.designPatterns.Observer;

public interface StockObservable {

    void addObserver(ItemObserver itemObserver);

    void removeObserver(ItemObserver itemObserver);

    void notifyObservers();

    void updateStock(int stock);

}
