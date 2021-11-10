package OutSide.test1;

import java.util.ArrayList;
import java.util.List;

/**

 */
public class t02 {

    public static void main(String[] args) {
        t02 t = new t02();
        t.subsets(new int[]{1,2,3});
    }
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return res;
    }

    private void backtracking(int[] nums, int idx) {
        res.add(new ArrayList<>(tmp));

        for (int i = idx; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtracking(nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
