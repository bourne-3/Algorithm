package OutSide.test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 子集问题
 */
public class t01 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();

    public static void main(String[] args) {

        t01 t = new t01();
        t.subSet(new int[]{1, 2, 3});



    }



    public void subSet(int[] nums) {
        backtracking(nums, 0);

        for (List<Integer> i : res) {
            System.out.print(i + " ");
        }
    }

    private void backtracking(int[] nums, int startIdx) {
        res.add(new ArrayList<>(tmp));

        for (int i = startIdx; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtracking(nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }


}


