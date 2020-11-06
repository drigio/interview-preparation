
/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * 
 * LeetCode :- https://leetcode.com/problems/moving-average-from-data-stream/
 */

import java.util.LinkedList;

public class MovingAverage {
    static class MoveAvg {
        LinkedList<Integer> list;
        int window;
        int sum;

        MoveAvg(int window) {
            list = new LinkedList<Integer>();
            this.window = window;
            sum = 0;
        }

        float next(int num) {
            sum += num;
            list.add(num);
            if (list.size() > window) {
                sum -= list.remove();
            }
            return sum / list.size();
        }
    }

    public static void main(String args[]) {
        MoveAvg m = new MoveAvg(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));
    }
}
