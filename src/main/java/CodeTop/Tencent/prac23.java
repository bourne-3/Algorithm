package CodeTop.Tencent;

import java.util.Deque;
import java.util.LinkedList;

/**
 用栈实现队列
 */
public class prac23 {

    public static void main(String[] args) {

    }

    Deque<Integer> in;
    Deque<Integer> out;

    public prac23() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        if (!out.isEmpty()) return out.pop();
        if (in.isEmpty()) return -1;
        while (!in.isEmpty()){
            out.push(in.pop());
        }
        return out.pop();
    }

    public int peek() {
        if (out.isEmpty()) return -1;
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
