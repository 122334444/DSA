package Stack;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        System.out.println(s);
        s.peek();
        System.out.println(s);
        s.pop();
        System.out.println(s);
    }
}
