package CodePoint;

import java.util.Deque;
import java.util.LinkedList;

/**

 */
public class BaseKnowlege {

    public static void main(String[] args) {
        forQueue();
    }

    public static void forQueue() {
        // 队列的实验
        Deque<Integer> de = new LinkedList<>();

        // offer 其实就和 offerLast
        de.offer(1);
        de.offer(2);
        de.offer(3);
        // ===============   队列的入口是右边，出口是左边

        System.out.println(de);
        // poll其实就是 removeFirst
        de.poll();
        System.out.println(de);
        // ============


    }
}
