package OutSide.test1;

import java.util.*;

/**

 */
public class t01 {

    public static void main(String[] args) {
//        maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
//        isStraight(new int[]{1, 2, 3, 4, 5});

//        lastRemaining(5, 3);
//        maxProfit(new int[]{7,1,5,3,6,4});
        constructArr(new int[]{1,2,3,4,5});
    }

    public static int[] constructArr(int[] a) {
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        left[0] = 1;
        right[a.length - 1] = 1;

        // 左边到右边
        for (int i = 1; i < left.length; i++) {
            left[i] = left[i-1] * a[i - 1];
        }
        // 右边到左边
        for (int i = right.length - 2; i >= 0; i--){
            right[i] = right[i+1] * a[i + 1];
        }

        int[] res = new int[a.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = left[i] * right[i] ;
        }
        return res;
    }

    public int sumNums(int n) {
        boolean flag = n > 1 && (n += sumNums(n -1)) > 0;
        return n;
    }

    public static int maxProfit(int[] prices) {
        int cost = prices[0];
        int res = 0;
        for (int n:prices){
            cost = Math.min(n, cost);
            res = Math.max(res, n - cost);
        }
        return res;

    }

    public static int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int cur = 0;
        while (list.size() > 1){
            int len = list.size();
            cur = (cur + m - 1) % len;
            list.remove(cur);
        }
        return list.get(0);
    }


    public static boolean isStraight(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int n:nums){
            if (n == 0)continue;
            max = n > max ? n:max;
            min = n < min ? n:min;
            if (set.add(n) == false) return false;
        }
        return max - min < 5;
    }


    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[]{};
        Deque<Integer> de = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while  (!de.isEmpty() && de.peekLast() < nums[i]){
                de.removeLast();
            }
//            de.offerLast(nums[i]);
            de.addLast(nums[i]);
        }
        int[] res = new int[nums.length - k + 1];
        res[0] = de.peekFirst();
        for (int i = k; i < nums.length; i++) {

            if (nums[i - k] == de.peekFirst()) de.removeFirst();

            while  (!de.isEmpty() && de.peekLast() < nums[i]){
                de.removeLast();
            }
            de.offerLast(nums[i]);

            res[i - k + 1] = de.peekFirst();
        }
        return res;
    }
}
