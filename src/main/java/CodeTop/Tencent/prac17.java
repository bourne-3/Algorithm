package CodeTop.Tencent;

import java.util.Deque;
import java.util.LinkedList;

/**

 */
public class prac17 {

    public static void main(String[] args) {

    }

    public String removeDuplicates(String s) {
        Deque<Character> de = new LinkedList<>();
        for (char c:s.toCharArray()){
            if (!de.isEmpty() && de.peek() == c){
                de.pop();
                continue;
            }
            de.push(c);
        }
        StringBuilder path = new StringBuilder();
        for (char c:de){
            path.append(c);
        }
        return path.reverse().toString();
    }
}
