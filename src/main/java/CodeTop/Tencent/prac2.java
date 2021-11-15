package CodeTop.Tencent;

/**
    // 快排
 */
public class prac2 {

    public static void main(String[] args) {

    }

    public void QuickSort(int[] nums, int l, int r) {
        if (l < r){
            int p = partition(nums, l, r);
            QuickSort(nums, l, p - 1);
            QuickSort(nums, p + 1, r);
        }
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
