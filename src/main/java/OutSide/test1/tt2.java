package OutSide.test1;

/**

 */
public class tt2 {

    public static void main(String[] args) {
        // 归并排序
        tt2 t = new tt2();
        int[] nums = {10, 3, 5, 2, 12};
        t.merge(nums, 0, nums.length - 1);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public void merge(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        merge(nums, l, mid);
        merge(nums, mid + 1, r);
        mergeSort(nums, l, r, mid);
    }

    private void mergeSort(int[] nums, int l, int r, int mid) {
        int bgn = l, end = r, m = mid + 1;
        int[] tmp = new int[r - l + 1];

        int count = 0;
        while (bgn <= mid && m <= end) {
            if (nums[bgn] < nums[m]) {
                tmp[count++] = nums[bgn++];
            } else {
                tmp[count++] = nums[m++];
            }
        }

        for (int i = bgn; i <= mid; i++) {
            tmp[count++] = nums[bgn++];
        }

        for (int i = m; i <= end; i++) {
            tmp[count++] = nums[m++];
        }

        // 覆盖原来的数组
        for (int i = 0; i < tmp.length; i++) {
            nums[i + l] = tmp[i];
        }
    }
}
