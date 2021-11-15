package OutSide.test1;

import java.util.Deque;
import java.util.LinkedList;

/**

 */
public class t03 {

    public static void main(String[] args) {

    }
    Deque<Integer> in;
    Deque<Integer> out;
    public t03() {
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
        if (in.isEmpty()) return -1;
        return in.peek();
    }

    public int getMin() {
        if (out.isEmpty()) return -1;
        return out.peek();
    }
}
