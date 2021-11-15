package CodeTop.Tencent;

/**
 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 */
public class prac7 {

    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        // 摩尔投票法
        int vote = 0, x = 0;
        for (int n:nums){
            if (vote == 0) x = n;
            vote += x == n ? 1 : -1;
        }
        return x;
    }
}
