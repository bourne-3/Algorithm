package OutSide.test1;

import java.util.ArrayList;
import java.util.List;

/**

 */
public class t06 {

    public static void main(String[] args) {

    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] visted;
    public List<List<Integer>> permute(int[] nums) {
        visted = new boolean[nums.length];
        backtracking(nums);
        return res;
    }

    private void backtracking(int[] nums) {
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 这里要不要idx？
            if (visted[i] == true){
                continue;
            }
            visted[i] = true;
            path.add(nums[i]);
            backtracking(nums);
            visted[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
