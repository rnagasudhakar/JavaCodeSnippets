package Practice.MultiThreading.RandomInt;

public class Deadlock {

    private static  Integer obj1 = 12;
    private static  Integer obj2 = 14;


    // t1 acquired
    // t2
    private synchronized void x(){

    }

    public static void runMethod()  {
        Thread t1 = new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (obj1){
                try{
                    Thread.sleep(2000);
                }
                catch (Exception e) {

                }
                synchronized (obj2) {
                    System.out.println("Thread t2 acquring" + obj2);
                }

            }
        });

        Thread t2 = new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (obj2){
                try{
                    Thread.sleep(0);
                }
                catch (Exception e) {

                }
                synchronized (obj1) {
                    System.out.println("Thread t2 acquring" + obj1);
                }
            }
        });
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }
        catch (Exception e){

        }


    }



}
