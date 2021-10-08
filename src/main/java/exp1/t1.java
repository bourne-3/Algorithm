package exp1;

import java.util.Deque;
import java.util.LinkedList;

/**
    1 括号匹配
 */
public class t1 {

    public static void main(String[] args) {
        String in = "({})";
        boolean flag = true;
        // 使用栈的思路来做
        Deque<Character> stack = new LinkedList<>();
        char[] chs = in.toCharArray();
        for (char c:chs){
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || c != stack.pop()){
                flag = false;
                break;
            }
        }
        System.out.println("输入的括号是否为有效的：" + flag);

    }

    public void T() {

    }
}
