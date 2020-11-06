
/**
 * Write a class StockSpanner which collects daily price quotes for some stock,
 * and returns the span of that stock's price for the current day.
 * 
 * The span of the stock's price today is defined as the maximum number of
 * consecutive days (starting from today and going backwards) for which the
 * price of the stock was less than or equal to today's price.
 * 
 * For example, if the price of a stock over the next 7 days were [100, 80, 60,
 * 70, 60, 75, 85], then the stock spans would be [1, 1, 1, 2, 1, 4, 6]
 * 
 * LeetCode :- https://leetcode.com/problems/online-stock-span/
 */

import java.util.ArrayList;
import java.util.Stack;

public class StockSpan {
    ArrayList<Integer> list;
    Stack<Integer> prevMax;

    public StockSpan() {
        list = new ArrayList<Integer>();
        prevMax = new Stack<Integer>();
    }

    public int next(int price) {
        list.add(price);
        if (prevMax.isEmpty()) {
            prevMax.push(0);
            return 1;
        }
        while (!prevMax.isEmpty() && list.get(prevMax.peek()) <= price) {
            prevMax.pop();
        }
        if (prevMax.isEmpty()) {
            prevMax.push(list.size() - 1);
            return list.size();
        }
        int ans = list.size() - 1 - prevMax.peek();
        prevMax.push(list.size() - 1);
        return ans;
    }

    public static void main(String args[]) {
        StockSpan S = new StockSpan();
        System.out.print(S.next(100) + " ");
        System.out.print(S.next(80) + " ");
        System.out.print(S.next(60) + " ");
        System.out.print(S.next(70) + " ");
        System.out.print(S.next(60) + " ");
        System.out.print(S.next(75) + " ");
        System.out.print(S.next(85) + " ");
    }
}
