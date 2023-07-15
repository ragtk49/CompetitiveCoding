/*
 * Leetcode: 346. Moving Average from Data Stream (https://leetcode.com/problems/moving-average-from-data-stream/)
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * Implement the MovingAverage class:
 * MovingAverage(int size) - Initializes the object with the size of the window size.
 * double next(int val) - Returns the moving average of the last size values of the stream.
 */

package com.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {

    private int maxSize;
    private Queue<Integer> queue;
    private double sum;

    /*
     * The constructor takes in the size of the window
     * and initializes the queue and sum variables
     * The queue is initialized as a LinkedList
     */
    public MovingAverage(int size){
        this.maxSize = size;
        this.queue = new LinkedList();
        this.sum = 0;
    }
    /*
     * The next() method adds the element val to the queue
     * and returns the average of the last size values of the stream
     * If the queue size is equal to the window size,
     * the first element of the queue is removed from the queue
     * The sum is updated by subtracting the removed element
     */
    public double next(int val){
        if(queue.size() == maxSize){
            sum = sum - queue.poll();
        }
        queue.offer(val);
        sum = sum + val;
        return sum / queue.size();
    }

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));
    }
    
}
