package CodeTop.Tencent;

import java.util.PriorityQueue;

/**
 数据流中的第 K 大元素
 // 有两种解法
 */
public class prac36 {

    public static void main(String[] args) {

    }

    PriorityQueue<Integer> q;
    int k;
    public prac36(int k, int[] nums) {
        this.q = new PriorityQueue<>();
        this.k = k;
        for (int n:nums){
            add(n);
        }
    }

    public int add(int val) {
        if (q.size() < k) {
            q.offer(val);
        }else if (!q.isEmpty() && val > q.peek()){
            q.poll();
            q.offer(val);
        }
        if (q.isEmpty()) return -1;
        return q.peek();
    }
}
