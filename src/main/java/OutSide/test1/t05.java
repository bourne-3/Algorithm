package OutSide.test1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**

 */
public class t05 {

    public static void main(String[] args) {
        String s = "(";
        t05 t = new t05();
        boolean valid = t.isValid(s);
        System.out.println(valid);


    }

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        char[] chs = s.toCharArray();
        for (char c:chs){
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }
}
