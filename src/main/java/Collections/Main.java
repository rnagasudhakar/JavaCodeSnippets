package Collections;

import java.util.*;

public class Main {

    public static void main(String[] args){
       int[] arr = new int[5]; // array declaration
        List<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(30);
        list.remove(1);
        list.get(0);

       Queue<Integer> queue = new LinkedList<>();
       queue.offer(10);
       queue.offer(10);
       queue.poll();
       queue.peek();

       Deque<Integer> s = new ArrayDeque<>(); // push pop peek

        Queue<Integer> pq = new PriorityQueue<>();// max heap

        Queue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        Comparator<Integer> comparator = (p1,p2)-> (p1-p2);
        list.sort(comparator);

        HashMap<Integer,Integer> mp = new HashMap<>();
        mp.put(1,2);
        mp.put(2,3);
        mp.put(3,4);

        for(Map.Entry<Integer,Integer> entry: mp.entrySet()){
            System.out.println(entry.getValue()+ " "+ entry.getKey());
        }

        for(Integer num:list){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }


    }

}
