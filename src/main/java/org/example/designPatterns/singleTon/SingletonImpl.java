package org.example.designPatterns.singleTon;


public class SingletonImpl {


    private static class SingleTonInstance{
        private static  final SingletonImpl singletonInstance1 = new SingletonImpl();
    }

    private static volatile SingletonImpl singletonInstance;

    // makes constructor private
    private SingletonImpl(){

    }


    public static  SingletonImpl getSingletonInstance(){
        // double locking
        // here the problem is usually in cores updates happen in the L1 cache which later periodically sync to main memory
        // So to avoid this problem we use volatile keyword which enables read or write from main memory only
        if(singletonInstance==null) {
            synchronized (SingletonImpl.class) {
                if (singletonInstance == null) {
                    singletonInstance = new SingletonImpl();
                }
            }
        }
        return singletonInstance;

        // return SingletonImpl.SingleTonInstance.singletonInstance1; using nested classes
    }
}

// second solution using nested class
