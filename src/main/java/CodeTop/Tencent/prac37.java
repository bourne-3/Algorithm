package CodeTop.Tencent;

import java.util.Deque;
import java.util.LinkedList;

/**

 */
public class prac37 {

    public static void main(String[] args) {

    }

    public String removeDuplicates(String s, int k) {
        Deque<Character> strs = new LinkedList<>();
        Deque<Integer> times = new LinkedList<>();
        for (char c:s.toCharArray()){
            if (strs.isEmpty() || strs.peek()!=c){
                strs.push(c);
                times.push(1);
            }else if (strs.peek() == c){
                Integer val = times.pop();
                times.push(val + 1);
            }

            //检查是否有重复
            if (!times.isEmpty() && times.peek() == k){
                times.pop();
                strs.pop();
            }
        }

        // 输出
        StringBuilder path = new StringBuilder();
        int size = strs.size();
        for (int i = 0; i < size; i++) {
            char c = strs.pop();
            int val = times.pop();
            for (int j = 0; j < val; j++) {
                path.append(c);
            }
        }
        return path.reverse().toString();
    }
}
