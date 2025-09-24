package Practice.Deadlock;

public class SharedResource {



     public synchronized  void consume(){
         try{
             Thread.sleep(100);
             wait();
         }
         catch(Exception e){
             // handle exception
         }
     }

}
