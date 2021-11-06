package CodePoint;

import java.util.Deque;
import java.util.LinkedList;

/**
 栈的压入、弹出序列

 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1}
 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。

  
 */
public class prac31 {

    public static void main(String[] args) {

    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> de = new LinkedList<>();
        int count = 0;
        // 两个循环处理，外部循环入栈，内部循环判断栈顶元素是否与pop序列中的元素一致。使用一个指针count移动
        for (int in : pushed){
            de.push(in);
            while (!de.isEmpty() && de.peek() == popped[count]){
                de.pop();
                count++;
            }
        }
        return de.isEmpty();
    }
}
