package OutSide.test1;

import java.util.PriorityQueue;

/**

 */
public class t07 {

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int target = 4;
        t07 t = new t07();
        int i = t.findKthLargest(nums, target);
        System.out.println(i);
    }
    PriorityQueue<Integer> q;
    int k;
    public int findKthLargest(int[] nums, int k) {
        // 使用优先级队列？
        this.q = new PriorityQueue<>(k);
        this.k = k;
        for (int n:nums){
            add(n);
        }
        return q.peek();
    }
    public int add(int n){
        if (q.size() < k){
            q.offer(n);
        }else if (n > q.peek()){
            q.poll();
            q.offer(n);
        }

        return q.peek();
    }
}
