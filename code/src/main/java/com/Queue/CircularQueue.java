/*
 * This is an implementation of a circular queue using an array
 * 1. The enqueue operation takes O(1) time
 * 2. The dequeue operation takes O(1) time
 * 3. The front operation takes O(1) time
 * 4. The isEmpty operation takes O(1) time
 * 5. The space complexity is O(n)
 * 6. The queue is bounded
 * 7. The queue is circular
 */

package com.Queue;

public class CircularQueue {

    private int[] queue;
    private int front;
    private int rear;
    private int size;

    /*
     * The constructor takes in the size of the queue
     * and initializes the queue with the given size
     * and sets the front and rear to 0
     */
    public CircularQueue(int size){
        queue = new int[size];
        front  = 0;
        rear = 0;
        this.size = size;
    }

    /*
     * The enqueue operation takes in an integer
     * and adds it to the queue
     * If the queue is full, it returns false
     * If the queue is not full, it adds the integer
     * to the queue and returns true
     * The rear is incremented by 1
     */
    public boolean enQueue(int x){
        if(isFull()){
            return false;
        }
        queue[rear] = x;
        rear = (rear + 1) % size;
        return true;
    }

    /*
     * The dequeue operation removes the element
     * at the front of the queue
     * If the queue is empty, it returns false
     * If the queue is not empty, it removes the element
     * at the front of the queue and returns true
     * The front is incremented by 1
     */
    public boolean deQueue(){
        if(isEmpty()){
            return false;
        }
        front = (front + 1) % size;
        return true;
    }

    /*
     * The front operation returns the element
     * at the front of the queue
     * If the queue is empty, it returns -1
     * If the queue is not empty, it returns the element
     * at the front of the queue
     */
    public int front(){
        if(isEmpty()){
            return -1;
        }
        return queue[front];
    }

    /*
     * The rear operation returns the element
     * at the rear of the queue
     * If the queue is empty, it returns -1
     * If the queue is not empty, it returns the element
     * at the rear of the queue
     */
    public int rear(){
        if(isEmpty()){
            return -1;
        }
        return queue[rear];
    }

    /*
     * The isEmpty operation returns true if the queue is empty
     * and false if the queue is not empty
     */
    public boolean isEmpty(){
        return front == rear;
    }

    /*
     * The isFull operation returns true if the queue is full
     * and false if the queue is not full
     */
    public boolean isFull(){
        return (rear + 1) % size == front;
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(3);
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        System.out.println(q.front());
        q.deQueue();    
        System.out.println(q.front());
    }
    
}
