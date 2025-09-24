package Practice.MultiThreading;

import java.util.ArrayList;

public class SharedResource {
    private int resourceSize;
    private ArrayList<Integer> resource;
    public SharedResource(int size){
        this.resourceSize = size;
        this.resource = new ArrayList<>();
    }

    public SharedResource() {

    }


    public synchronized  void  consumeData()  {
        while(this.resource.size()==0){
            try{
                wait(500);
            }
            catch(InterruptedException e){
                Thread.currentThread().interrupt();
                return ;
            }
        }
        int data = resource.remove(0);
        System.out.println("current thread is" + Thread.currentThread().getName() + " " + data);
        notifyAll();
    }

    public synchronized  void  produceData(Integer data)  {
        while(this.resource.size() >=resourceSize){
            try{
                wait(500);
            }
            catch(InterruptedException e){
                Thread.currentThread().interrupt();
                return ;
            }
        }
        this.resource.add(data);
        System.out.println("current thread is" + Thread.currentThread().getName() + " " + data);
        notifyAll();
    }

}
