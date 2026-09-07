package Stack;

import java.util.*;

public class StockSpan {

    public static int[] span(int price[]) {
        int n = price.length;
        Stack<Integer> s = new Stack<>();
        s.push(0);// 1st index
        int span[] = new int[n];
        span[0] = 1;

        for (int i = 1; i < n; i++) {
            while (s.size() > 0 && price[i] > price[s.peek()]) {
                s.pop();
            }
            if (s.size() == 0) {
                span[i] = i + 1;
            } else {
                span[i] = i - s.peek();
            }
            s.push(i);
        }
        return span;
    }

    public static void main(String args[]) {
        int price[] = { 1, 2, 3, 2, 4, 6, 5, 9, 2, 1, 3, 4, 7 };

        int span[] = span(price);
        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        }
    }
}
