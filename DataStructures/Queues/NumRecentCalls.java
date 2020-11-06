
/**
 * You have a RecentCounter class which counts the number of recent requests
 * within a certain time frame.
 * 
 * Implement the RecentCounter class:
 * 
 * RecentCounter() Initializes the counter with zero recent requests. int
 * ping(int t) Adds a new request at time t, where t represents some time in
 * milliseconds, and returns the number of requests that has happened in the
 * past 3000 milliseconds (including the new request). Specifically, return the
 * number of requests that have happened in the inclusive range [t - 3000, t].
 * It is guaranteed that every call to ping uses a strictly larger value of t
 * than the previous call.
 * 
 * LeetCode :- https://leetcode.com/problems/number-of-recent-calls/
 */

import java.util.LinkedList;

public class NumRecentCalls {
    static class RecentCounter {
        LinkedList<Integer> list;

        public RecentCounter() {
            list = new LinkedList<Integer>();
        }

        public int ping(int t) {

            list.add(t);

            int lowerRange = t - 3000;

            while (list.peek() < lowerRange) {
                list.remove();
            }

            return list.size();

        }
    }

    public static void main(String args[]) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
    }

}
