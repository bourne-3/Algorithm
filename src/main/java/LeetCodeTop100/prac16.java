package LeetCodeTop100;

/**
 在排序数组中查找元素的第一个和最后一个位置
 */
public class prac16 {

    public static void main(String[] args) {

    }

    public int[] searchRange(int[] nums, int target) {
        int flag = biHelper(nums, target);
        if (flag == -1) return new int[]{-1, -1};
        // 左右滑动窗口
        int l = flag, r = flag;
        while (l - 1 >= 0 && nums[l - 1] == nums[l]) l--;
        while (r + 1 < nums.length && nums[r + 1] == nums[r]) r++;
        return new int[]{l, r};
    }

    int biHelper(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) r = mid - 1;
            else if (nums[mid] < target) l = mid + 1;
            else return mid;
        }
        return -1;
    }
}
