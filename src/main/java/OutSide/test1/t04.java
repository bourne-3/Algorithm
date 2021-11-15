package OutSide.test1;

import java.util.Deque;
import java.util.LinkedList;

/**

 */
public class t04 {

    public static void main(String[] args) {

    }
    // 两个栈实现队列
    Deque<Integer> in;
    Deque<Integer> out;

    public t04() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    public void push(int x) {
        in.push(x);

    }

    public int pop() {
        if (!out.isEmpty()) return out.pop();
        if (in.isEmpty()) return -1;
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
        return out.pop();
    }

    public int peek() {
        return out.peek();
    }

    public boolean empty() {
        return out.isEmpty();
    }
}
