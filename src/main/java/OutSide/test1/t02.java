package OutSide.test1;

import java.util.PriorityQueue;

/**

 */
public class t02 {

    public static void main(String[] args) {

    }

    PriorityQueue<Integer> q;
    int k;

    public t02(int k, int[] nums) {
        this.q = new PriorityQueue<>(k);
        this.k = k;

        for (int n:nums){
            add(n);
        }

    }

    public int add(int val) {
        if (q.size() < k){
            // 入队
            q.offer(val);
        }else if (!q.isEmpty() && val > q.peek()){
            q.poll();
            q.offer(val);
        }

        return q.peek();
    }
}
