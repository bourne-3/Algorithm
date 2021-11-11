package OutSide.test1;

import java.util.ArrayList;
import java.util.List;

/**

 */
public class t01 {

    public static void main(String[] args) {
        t01 t = new t01();
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        t.trap(nums);
    }




    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);

        // 业务
        res.add(root.val);

        dfs(root.right);
    }


    public int[] constructArr(int[] a) {
        if (a.length == 0) return new int[]{};

        // left[i] 的定义是：除了a[i]之外，左边到i的所有累乘积
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        // 初始化
        left[0] = 1;
        right[a.length - 1] = 1;

        // 递推
        for (int i = 1; i < a.length; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }

        for (int i = a.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }

        // 统计结果
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            res[i] = left[i] * right[i];
        }

        return res;
    }


    public int trap(int[] height) {
        // 记得两个dp数组
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];
        // 初始化
        left[0] = height[0];
        right[len - 1] = height[len - 1];

        // 开始记录
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        // 统计结果
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += Math.min(left[i], right[i]) - height[i];
        }
        return res;


    }


    public int maxArea(int[] height) {
        int res = 0, l = 0, r = height.length - 1;
        int tmp;
        while (l < r) {
            if (height[l] < height[r]) {
                tmp = (r - l) * height[l];
            } else {
                tmp = (l - r) * height[r];
            }
            res = Math.max(tmp, res);
        }
        return res;
    }
}
