package OutSide.test1;

/**

 */
public class t06 {

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        t06 t = new t06();
        int i = t.findKthLargest(nums, nums.length - k);
        System.out.println(i);
    }

    public int findKthLargest(int[] nums, int k) {
        // 使用两种方法去解
        return helper(nums, 0, nums.length - 1, k);
    }

    private int helper(int[] nums, int l, int r, int k) {
        if (l < r){
            int p = partition(nums, l, r);
            if (p < k) helper(nums, p + 1, r, k);
            if (p > k) helper(nums, l, p - 1, k);
        }
        return nums[k];
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        while (l < r){
            while (l < r && nums[r] >= pivot) r--;
            nums[l] = nums[r];
            while (l < r && nums[l] <= pivot) l++;
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        return l;
    }
}
