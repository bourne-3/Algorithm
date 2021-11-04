package Sort;

/**

 */
public class MergeSortT {

    public static void main(String[] args) {
        int[] nums = {10, 3, 5, 2, 12};

        MergeSortT t = new MergeSortT();
        t.mergeSort(nums, 0, nums.length - 1);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r) return;

        int mid = (l + r) >> 1;
        mergeSort(nums, l, mid);  // 这里不用- 1
        mergeSort(nums, mid + 1, r);
        mergeSortInOrder(nums, l, mid, r);
    }

    private void mergeSortInOrder(int[] nums, int bgn, int mid, int end) {
        int l = bgn, m = mid + 1, e = end;  // 这里两个数组的开头，其实可以改为tmp1以及tmp2会更好理解一些
        int[] res = new int[end - bgn + 1];
        int count = 0;
        while (l <= mid && m <= e){
            if (nums[l] <= nums[m]) res[count++] = nums[l++];
            else res[count++] = nums[m++];
        }
        while (l <= mid) res[count++] = nums[l++];
        while (m <= e) res[count++] = nums[m++];
        for (int i = 0; i < res.length; i++){
            nums[i + bgn] = res[i]; // 这里bgn不可以少
        }

    }


    public void T() {

    }
}
