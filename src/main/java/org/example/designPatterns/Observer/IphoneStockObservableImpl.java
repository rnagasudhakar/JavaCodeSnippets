package org.example.designPatterns.Observer;

import java.util.ArrayList;
import java.util.List;

public class IphoneStockObservableImpl implements  StockObservable{

    List<ItemObserver> itemObserverList;
    public int stock;

    IphoneStockObservableImpl(){
        this.itemObserverList = new ArrayList<ItemObserver>();
        this.stock = 0;
    }

    @Override
    public void addObserver(ItemObserver itemObserver) {
        itemObserverList.add(itemObserver);
    }

    @Override
    public void removeObserver(ItemObserver itemObserver) {
        itemObserverList.remove(itemObserver);
    }

    @Override
    public void notifyObservers() {
        for(ItemObserver itemObserver : itemObserverList){
            itemObserver.update();
        }
    }

    @Override
    public void updateStock(int stock) {
        this.stock += stock;
        if(this.stock == 0){
            notifyObservers();
        }
    }



}
