package OutSide.test1;

import java.util.ArrayList;
import java.util.List;

/**

 */
public class t03 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public static void main(String[] args) {
        t03 t = new t03();
        t.combinationSum(new int[]{2,3,6,7}, 7, 0);
        for (List<Integer> re : t.res) {
            System.out.print(re);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target, int idx) {
        backtracking(candidates, target, idx);
        return res;
    }

    private void backtracking(int[] candidates, int target, int idx) {
        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        if (target < 0) return;

        for (int i = idx; i < candidates.length; i++) {
            path.add(candidates[i]);
            target -= candidates[i];

            backtracking(candidates, target, i);
            target += candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
