package OutSide.test1;

import java.util.PriorityQueue;

/**

 */
public class t03 {

    public static void main(String[] args) {
        int[] nums = {4, 5, 8, 2};
        t03 t = new t03(3, nums);
        System.out.println(t.add(3));  // 4
        System.out.println(t.add(5));  //  5
        System.out.println(t.add(10));  //  5
        System.out.println(t.add(9));  //  8
        System.out.println(t.add(4));  //  8

    }
    // 使用优先级队列
    PriorityQueue<Integer> q;
    int k;
    public t03(int k, int[] nums) {
        this.q = new PriorityQueue<>(k);
        this.k = k;
        // 入队
        for (int n :nums){
            add(n);
        }

    }

    public int add(int val) {
        if (q.size() < k){
            q.offer(val);
        }else if (val > q.peek()){
            q.poll();
            q.offer(val);
        }
        if (q.isEmpty()) return -1;
        return q.peek();
    }
}
