package CodePoint;

/**
 在排序数组中查找数字 I
 一般排序数组 都是使用二分查找，其他都没用。
 */
public class prac48 {

    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        // 滑动窗口的思路
        int idx = BSearch(nums,target);
        if (idx == -1) return 0;
        // 向两边滑动
        int l = idx, r = idx;
        // 向左边
        while (l - 1 >= 0 && nums[l-1] == nums[idx]) l--;
        while (r + 1 < nums.length && nums[r + 1] == nums[idx]) r++;
        return r - l + 1;
    }

    private int BSearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int mid = l + (r - l )/ 2;
            if (nums[mid] < target) l = mid + 1;
            else if (nums[mid] > target) r = mid - 1;
            else return mid;
        }
        return -1; // 没找到
    }
}
