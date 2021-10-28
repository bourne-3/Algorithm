package Sort;

/**
    1 这个方法就是左右两边向中间收缩的版本 （教科书上的那种方法）
 */
public class QuickSortT_v2 {

    public static void main(String[] args) {
        int[] nums = {10, 3, 5, 2, 12};

        QuickSortT_v2 t = new QuickSortT_v2();
        int[] res = t.Sort(nums);
        for (int n : res) {
            System.out.print(n + " ");
        }
    }

    public int[] Sort(int[] nums) {
        QuickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void QuickSort(int[] nums, int l, int r) {
        if (l < r){
            int idx = partition(nums, l, r);
            QuickSort(nums, l, idx - 1);
            QuickSort(nums, idx + 1, r);
        }
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        while (l < r){
            // 这里要取等于号，不然会出错。
            // 这里是与pivot比较
            while (l < r && nums[r] >= pivot) r--;  // 不断的找出比pivot小的数，因此当大于pivot就移动指针
            nums[l] = nums[r];
            while (l < r && nums[l] <= pivot) l++;
            nums[r] = nums[l];
        }
        nums[l] = pivot;  // 当两个下标重合，就可以把pivot放过来
        return l;
    }
}
