package CodePoint;

import java.util.ArrayList;
import java.util.List;

/**

 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class prac19 {

    public static void main(String[] args) {
        prac19 t = new prac19();
        List<List<Integer>> res = t.subsets(new int[]{1, 2, 3});
        System.out.println(res);
    }
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return res;
    }

    // 这里使用一个idx来记录访问过的
    private void backtracking(int[] nums, int idx) {
        res.add(new ArrayList<>(tmp));

        for (int i = idx; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtracking(nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }


}
