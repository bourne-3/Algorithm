package CodeTop.Tencent;

import java.util.ArrayList;
import java.util.List;

/**
 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 找到所有出现两次的元素。

 这道题真的太精彩了，非常的好。用于考验算法能力
 */
public class prac19___ {

    public static void main(String[] args) {

    }

    public List<Integer> findDuplicates(int[] nums) {
        // 这里是用hash表还是用环形链表？  有些元素，因此不止一个出现两次，不能用环形链表
        int size = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int targetIdx = nums[i];
            nums[targetIdx - 1] += size;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > size * 2) res.add(i + 1);
        }
        return res;

    }
}
