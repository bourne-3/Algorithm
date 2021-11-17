package CodeTop.Tencent;

import java.util.Deque;
import java.util.LinkedList;

/**
 ["MinStack","push","push","push","getMin","pop","top","getMin"]
 [[],[-2],[0],[-3],[],[],[],[]]


 [null,null,null,null,-3,null,0,-2]

 */
public class prac24 {

    public static void main(String[] args) {
        prac24 t = new prac24();
        t.push(-2);
        t.push(0);
        t.push(-3);
        int min = t.getMin();
        System.out.println(min);

        t.pop();
        t.pop();
        System.out.println(t.getMin());
    }

    // 实现最小栈
    Deque<Integer> in;
    Deque<Integer> out;

    public prac24() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    public void push(int val) {
        in.push(val);
        if (out.isEmpty() || val <= out.peek()) out.push(val);
    }

    public void pop() {
        if (in.pop().equals(out.peek())) out.pop();
    }

    public int top() {
        return in.peek();
    }

    public int getMin() {
        return out.peek();
    }
}
