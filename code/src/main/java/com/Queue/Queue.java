/*
 * Basic Queue implementation using ArrayList
 * This implementation is not thread safe
 * 1. The enqueue operation takes O(n) time
 * 2. The dequeue operation takes O(n) time
 * 3. The front operation takes O(1) time
 * 4. The isEmpty operation takes O(1) time
 * 5. The space complexity is O(n)
 * 6. The queue is unbounded
 */

package com.Queue;

import java.util.ArrayList;
import java.util.List;

public class Queue {

    private List<Integer> queue;
    private int front;

    public Queue(){
        queue = new ArrayList<Integer>();
        front = 0;
    }

    public boolean enqueue(int x){
        queue.add(x);
        return true;
    }

    public boolean dequeue(){
        if(queue.isEmpty()){
            return false;
        }
        front++;
        return true;
    }

    public int front(){
        return queue.get(front);
    }

    public boolean isEmpty(){
        return front >= queue.size();
    }
    
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.front());
        q.dequeue();    
        System.out.println(q.front());
    }
    
}
