package CodePoint;

/**
 0～n-1中缺失的数字

 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。

 */
public class prac49 {

    public static void main(String[] args) {

    }

    public int missingNumber(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int mid = l + (r-l)/2;
            if (nums[mid] == mid) l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }
}
