package exp1;

import java.util.ArrayList;
import java.util.List;

/**
 子集

 输入：nums = []
 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class t3 {

    public static void main(String[] args) {
        t3 t = new t3();
        int[] in = {1,2,3};
        System.out.println(t.subsets(in));
    }
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return res;
    }

    // 关键是idx，使用idx来控制个数。（注意在调用backtracking的时候，改变了idx的值）
    private void backtracking(int[] nums, int idx) {
        res.add(new ArrayList<>(path));
        for (int i = idx; i < nums.length; i++){
            path.add(nums[i]);
            backtracking(nums, idx + 1);
            path.remove(path.size()-1);
        }
    }
}
