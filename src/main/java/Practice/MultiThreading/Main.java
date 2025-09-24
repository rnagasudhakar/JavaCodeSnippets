package Practice.MultiThreading;

public class Main {

    public static void main(String[] args){

        SharedResource sharedResource = new SharedResource(10);

        Runnable task1 = ()->{
            for(int i=0;i<10;i++){
                sharedResource.consumeData();
            }
        };

        Thread consumer = new Thread(task1);

        Runnable task2 = ()->{
            for(int i=0;i<10;i++){
                sharedResource.produceData(i);
            }
        };

        Thread producer = new Thread(task2);

        producer.start();
        consumer.start();

    }
}
