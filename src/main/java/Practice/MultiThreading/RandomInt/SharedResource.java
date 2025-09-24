package Practice.MultiThreading.RandomInt;



public class SharedResource {

    synchronized void methodA(){
        int res=0;
        for(int i=0;i<100;i++){
            res+=i;
        }
        try {
           Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("running in methodA" + res);
    }

    synchronized void methodB(){

        int res=0;
        for(int i=0;i<100;i++){
            res+=i;
        }
        System.out.println("running in methodB" + res);
    }

    void runSharedResource(){
        Thread t1 = new Thread(()->{
            this.methodA();
        });
        Thread t2 = new Thread(()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.methodB();
        });
        t1.start();
        t2.start();
    }

}
