package Practice.MultiThreading.RandomInt;

public class SequencePrinter {


    private  int counter = 1;
    private final Object object = new Object();

    private  void sharedResource(int turnId){
        synchronized (object){
            int maxCounter = 24;
            while(counter <= maxCounter){
                int expectedTurn = (counter -1 ) % 3 + 1;
                while(turnId != expectedTurn){
                    try{
                        object.wait();
                    }catch (Exception _){

                    }
                    expectedTurn = (counter -1 ) % 3 + 1;
                }
                System.out.println(Thread.currentThread().getName() + " " + counter);
                counter++;
                object.notifyAll();
            }
        }
    }




    public void sequenceIntialisation(){
        Thread t1 = new Thread(()->{
            this.sharedResource(1);
        });
        t1.setName("T1");
        Thread t2 = new Thread(()->{
            this.sharedResource(2);
        });
        t2.setName("T2");
        Thread t3 = new Thread(()->{
            this.sharedResource(3);
        });
        t3.setName("T3");
        t1.start();
        t2.start();
        t3.start();
    }


}
