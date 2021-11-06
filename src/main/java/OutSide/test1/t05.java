package OutSide.test1;

import java.util.Deque;
import java.util.LinkedList;

/**

 */
public class t05 {

    public static void main(String[] args) {

    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> de = new LinkedList<>();
        int count = 0;
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
