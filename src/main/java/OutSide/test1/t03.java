package OutSide.test1;

import java.util.Deque;
import java.util.LinkedList;

/**

 */
public class t03 {

    public static void main(String[] args) {

    }
    // 两个队列实现一个栈
    Deque<Integer> in;
    Deque<Integer> out;
    public t03() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    public void push(int x) {
        // 要保持一个队列永远是空的
        in.offer(x);
        while (!out.isEmpty()){
            in.offer(out.poll());
        }

        Deque<Integer> tmp = in;
        in = out;
        out = tmp;
    }

    public int pop() {
        return out.poll();
    }

    public int top() {
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
