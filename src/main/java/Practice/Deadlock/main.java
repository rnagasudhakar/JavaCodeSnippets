package Practice.Deadlock;



public class main {

    public static void main(String[] args){
        SharedResource sharedResource = new SharedResource();
        Thread t1 = new Thread(()->{
            System.out.println("thread 1 is here");
            sharedResource.consume();
        });

        Thread t2 = new Thread(()->{
            System.out.println("thread 1 is here");
            sharedResource.consume();
        });

        t1.start();
        t2.start();
    }
}
