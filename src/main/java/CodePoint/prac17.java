package CodePoint;

import java.util.Deque;
import java.util.LinkedList;

/**

 有效的括号

 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

 有效字符串需满足：

 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合
 */
public class prac17 {

    public static void main(String[] args) {

    }

    public static boolean isValid(String s) {
        char[] chs = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (char c:chs){
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            // 注意 这里是 使用pop() 而不是使用 peek()。 因为比较的同时，也需要将该栈顶的元素出栈
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        return stack.isEmpty();
    }
}
