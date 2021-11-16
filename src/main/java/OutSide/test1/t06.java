package OutSide.test1;

import java.util.Deque;
import java.util.LinkedList;

/**

 */
public class t06 {

    public static void main(String[] args) {

    }

    public void T() {

    }

    Deque<Integer> in;
    Deque<Integer> out;
    public t06() {
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
