/*
 * Leetcode 853. Car Fleet (https://leetcode.com/problems/car-fleet/)
 * N cars are going to the same destination along a one lane road.  The destination is target miles away.
 * Each car i has a constant speed speed[i] (in miles per hour), and initial position position[i] miles towards the target along the road.
 * A car can never pass another car ahead of it, but it can catch up to it, and drive bumper to bumper at the same speed.
 * The distance between these two cars is ignored - they are assumed to have the same position.
 * A car fleet is some non-empty set of cars driving at the same position and same speed.  Note that a single car is also a car fleet.
 * If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.
 * How many car fleets will arrive at the destination?
 * Example 1:
 * Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
 * Output: 3
 */
package com.Stacks;

import java.util.Map;
import java.util.TreeMap;
/*
 * Approach:
 * 1. Use a treemap to store the distance and speed of the cars
 * 2. Iterate through the treemap
 * 3. If the time taken by the current car to reach the target is greater than the time taken by the previous car, increment the count
 * 4. Return the count
 * Time Complexity: O(nlogn)
 * Space Complexity: O(n)
 */
public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
         TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = position.length;
        for(int i=0; i<n; ++i){
            map.put(target - position[i], speed[i]);
        }
        int count = 0;
        double r = -1.0;
	/*for all car this value must > 0, so we can count for the car closeset to target*/
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int d = entry.getKey(); // distance
            int s = entry.getValue(); // speed
            double t = 1.0*d/s; // time to target
            if(t>r){ // this car is unable to catch up previous one, form a new group and update the value
                ++count;
                r = t;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CarFleet cf = new CarFleet();
        int target = 12;
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};
        System.out.println(cf.carFleet(target, position, speed));
    }
}
