package OutSide.test1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**

 */
public class t03 {

    public static void main(String[] args) {
//        findContinuousSequence(9);
        maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> de = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            int val = nums[i];
            while (!de.isEmpty() && val > de.peekLast()){
                // 使得这个队列是保持单调的
                de.removeLast();
            }
            de.addLast(val);
        }

        // 窗口形成
        int[] res = new int[nums.length - k + 1];
        res[0] = de.peekFirst();
        for (int i = k; i < nums.length; i++) {
            // 第一个元素是否窗口外
            if (de.peekFirst() == nums[i - k]) de.removeFirst();

            // 继续添加
            int val = nums[i];
            while (!de.isEmpty() && val > de.peekLast()){
                // 使得这个队列是保持单调的
                de.removeLast();
            }
            de.addLast(val);
            res[i - k + 1] = de.peekFirst();
        }
        return res;

    }

    public static int[][] findContinuousSequence(int target) {
        int l = 1, r = 1;
        int sum = 0;
        List<int[]> path = new ArrayList<>();
        while (r < target){
            // 右边张开
            sum += r;
            while (sum > target){
                // 左边缩窗口
                sum -= l;
                l++;
            }
            if (sum == target){
                int[] tmp = new int[r - l + 1];
                for (int i = 0; i < tmp.length; i++) {
                    tmp[i] = l + i;
                }
                path.add(tmp);
            }

            r++;
        }
        System.out.println(path);
        return null;
    }


    public boolean isBalanced(TreeNode root) {
        int l = helper(root.left);
        int r = helper(root.right);
        return Math.abs(l - r) < 2;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        return Math.max(l, r) + 1;
    }
}
