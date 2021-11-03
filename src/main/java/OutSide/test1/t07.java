package OutSide.test1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**

 */
public class t07 {

    public static void main(String[] args) {
        Deque<Integer> de = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        de.offer(1);
        de.offer(2);
        de.offer(3);

        de.offerFirst(10);
        de.offerFirst(20);
        de.addFirst(40);

        System.out.println(de);



        System.out.println("======");
        int len = de.size();
        for (int i = 0; i < len; i++) {
            System.out.print(de.poll() + " " );
        }
    }

    public void T() {

    }
}
