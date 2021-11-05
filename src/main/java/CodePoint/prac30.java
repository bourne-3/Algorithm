package CodePoint;

import java.util.Deque;
import java.util.LinkedList;

/**
 包含min函数的栈
 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
public class prac30 {

    Deque<Integer> in;
    Deque<Integer> out;
    public static void main(String[] args) {

    }

    /** initialize your data structure here. */
    public prac30() {
        // 实例化
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    public void push(int x) {
        in.push(x);
        // 如果 out为空 或者 x小于等于out的顶端 out就要加入元素
        if (out.isEmpty() || x <= out.peek()){
            out.push(x);
        }
    }

    public void pop() {
        // 输出的元素刚好是最小值，就要把out的顶部移除
        if (in.pop().equals(out.peek())) out.pop();
    }

    public int top() {
        return in.peek();
    }

    public int min() {
        return out.peek();
    }
}
