package OutSide.test1;

import java.util.Deque;
import java.util.LinkedList;

/**

 */
public class t08 {

    public static void main(String[] args) {

    }

    public boolean isValid(String s) {
        Deque<Character> de = new LinkedList<>();
        for (char c:s.toCharArray()){
            if (c == '{') de.push('}');
            else if (c == '[') de.push(']');
            else if (c == '(') de.push(')');
            else if (de.isEmpty() || de.pop() != c) return false;
        }
        return true;
    }
}
