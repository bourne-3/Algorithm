package OutSide.test1;

import java.util.Deque;
import java.util.LinkedList;

/**

 */
public class t2 {

    public static void main(String[] args) {
        t2 queue = new t2();
        queue.appendTail(5);
        queue.appendTail(2);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }

    Deque<Integer> in = new LinkedList<>();
    Deque<Integer> out = new LinkedList<>();

    public t2() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (!out.isEmpty()) return out.pop();
        if (in.isEmpty()) return -1;
        while (!in.isEmpty()){
            out.push(in.pop());
        }
        return out.pop();
    }
}
