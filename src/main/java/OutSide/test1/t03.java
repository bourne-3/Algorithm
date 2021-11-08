package OutSide.test1;

import java.util.ArrayList;
import java.util.List;

/**

 */
public class t03 {

    public static void main(String[] args) {
        findContinuousSequence(9);
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
