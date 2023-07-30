/*
 * LeetCode 622 - Design Circular Queue (https://leetcode.com/problems/design-circular-queue/)
 * Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle
 */

package com.Queue;
/*
 * Approach: We can use an array to implement a circular queue. We can use two pointers front and rear to keep track of the front and rear of the queue.
 * The front points to the first element of the queue and the rear points to the last element of the queue.
 * The front is initialized to -1 and the rear is initialized to -1.
 * The front is incremented by 1 when an element is removed from the queue.
 * The rear is incremented by 1 when an element is added to the queue.
 * The front and rear are reset to -1 when the queue becomes empty.
 * The front and rear are reset to 0 when the queue becomes full.
 */
public class CircularQueue {

    private int[] queue;
    private int front;
    private int rear;
    private int size;

    /*
     * The constructor takes in the size of the queue
     * and initializes the queue, front, rear and size variables
     * The front is initialized to 0
     * The rear is initialized to -1
     */
    public CircularQueue(int size){
        queue = new int[size];
        front  = -1;
        rear = -1;
        this.size = size;
    }

    /*
     * The enQueue() method inserts an element at the rear of the queue if it is not full. 
     * If the queue is empty before insertion, 
     * the front index is updated accordingly
     * If the queue is not full, it adds the element x
     * to the rear of the queue and returns true
     * The rear is incremented by 1
     */
    public boolean enQueue(int x){
        if(isFull()){
            return false;
        }
        if(isEmpty()){
            front = 0;
        }
        rear = (rear + 1) % size;
        queue[rear] = x;
        return true;
    }

    /*
     * The deQueue() method removes the front element from the queue if it is not empty. 
     * If the queue becomes empty after deletion, 
     * the front and rear indices are reset to -1
     * If the queue is not empty, it removes the element
     * at the front of the queue and returns true
     * The front is incremented by 1
     */
    public boolean deQueue(){
        if(isEmpty()){
            return false;
        }
        if (front == rear) {
            front = -1;
            rear = -1;
            return true;
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
        return front == -1;
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
        System.out.println(q.enQueue(1));
        System.out.println(q.enQueue(2));
        System.out.println(q.enQueue(3));
        System.out.println(q.enQueue(4));
        System.out.println(q.rear());
        System.out.println(q.isFull());
        System.out.println(q.deQueue());    
        System.out.println(q.enQueue(4));
        System.out.println(q.rear());
    }
    
}
