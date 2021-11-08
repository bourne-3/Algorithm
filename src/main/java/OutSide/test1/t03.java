package OutSide.test1;

/**

 */
public class t03 {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        t03 t = new t03();
        t.search(nums, target);
    }

    public int search(int[] nums, int target) {
        // 使用二分查找结合滑动指针
        int idx = helper(nums, target);
        if (idx == -1) return 0;
        // 向左和向右滑动
        int l = idx, r = idx;
        while (l >= 0 && nums[l - 1] == nums[idx]) l--;
        while (r < nums.length && nums[r + 1] == nums[idx]) r++;
        return r - l + 1;
    }

    private int helper(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) l = mid + 1;
            else if (nums[mid] > target) r = mid - 1;
            else return mid;
        }
        return -1;
    }
}
