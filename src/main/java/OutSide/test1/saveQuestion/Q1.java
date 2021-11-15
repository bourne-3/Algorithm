package OutSide.test1.saveQuestion;

import java.util.ArrayList;
import java.util.List;

/**
    问题：这里怎么去重 那些内容一起，只是顺序颠倒了而已的内容
        比如：[1, 1, 1, 2], [1, 1, 2, 1], [1, 2, 1, 1],[2, 1, 1, 1]  这四个，内容是一样的，我只需要留一个
 */
public class Q1 {

    public static void main(String[] args) {
        Q1 t = new Q1();

        int res = t.change(5, new int[]{1, 2, 5});
        System.out.println(t.res);
        System.out.println(res);
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public int change(int amount, int[] coins) {
        // 可以凑成总金额的硬币组合数
        backtracking(amount, coins, 0);
        return res.size();
    }

    private void backtracking(int amount, int[] coins, int idx) {
        // 结束条件
        if (amount == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        if (amount < 0) return;

        // 循环
        // 提出问题：如何让重复的数字给去除掉
        for (int i = 0; i < coins.length; i++) {
            path.add(coins[i]);
            backtracking(amount - coins[i], coins, i + 1);
            path.remove(path.size()-1);
        }

    }
}
