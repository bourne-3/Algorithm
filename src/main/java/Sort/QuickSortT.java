package Sort;

/**

 */
public class QuickSortT {

    public static void main(String[] args) {
        int[] nums = {10, 3, 5, 2, 12};
        QuickSortT t = new QuickSortT();
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
            int p = helper(nums, l, r);
            QuickSort(nums, l, p - 1);
            QuickSort(nums, p + 1, r);
        }
    }

    private int helper(int[] nums, int l, int r) {
        int pivot = nums[l];
        int i = l;
        int j = i + 1;
        for (; j <= r; j++){
            if (nums[j] < pivot){
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i, l);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i]= nums[j];
        nums[j] = tmp;
    }
}
