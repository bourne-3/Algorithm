package OutSide.test1;

import java.util.Deque;
import java.util.LinkedList;

/**

 */
public class t04 {

    public static void main(String[] args) {

    }
    Deque<Integer> in;
    Deque<Integer> out;
    public t04() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    public void push(int x) {
        in.push(x);
        if (out.isEmpty() || x <= out.peek()) out.push(x);
    }

    public void pop() {
        if (in.pop().equals(out.peek())) out.pop();
    }

    public int top() {
        return in.peek();
    }

    public int min() {
        return out.peek();
    }
}
