package CodeTop.Tencent;

/**

 */
public class prac32 {

    public static void main(String[] args) {

    }

    public int findMin(int[] nums) {
        // 好像前面有一个middle的和这道题是同一个解法？

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] < nums[r]) r = m;
            else if (nums[m] > nums[r]) l = m + 1;
            else return findRes(nums, l ,r);
        }
        return nums[l];
    }

    private int findRes(int[] nums, int l, int r) {
        int res = nums[l];
        for (int i = l; i < r; i++) {
            if (nums[i] < res) res = nums[i];
        }
        return res;
    }
}
