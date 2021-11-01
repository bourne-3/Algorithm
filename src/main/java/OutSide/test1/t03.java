package OutSide.test1;

/**
 * 归并排序练习
 */
public class t03 {

    public static void main(String[] args) {
        int[] nums = {59, 1, 30, 5, 29};

        t03 t = new t03();
        t.mergeSort(nums, 0, nums.length - 1);

        // output
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public void mergeSort(int[] nums, int l, int r) {

        if (l >= r) return;

        int mid = (l + r) / 2;
        mergeSort(nums, l, mid);  // 这里不用 - 1
        mergeSort(nums, mid + 1, r);
        mergeRes(nums, l, r, mid);
    }

    private void mergeRes(int[] nums, int bgn, int end, int mid) {
        int l = bgn, m = mid + 1, e = end;
        int[] res = new int[end - bgn + 1];
        int cur = 0;
        while (l <= mid && m <= e){
            if (nums[l] < nums[m]) res[cur++] = nums[l++];
            else res[cur++] = nums[m++];
        }

        while (l <= mid) res[cur++] = nums[l++];
        while (m <= e) res[cur++] = nums[m++];

        // 将元素放到原有的数组中
        for (int i = 0; i < res.length; i++) {
            nums[i + bgn] = res[i];
        }
    }
}
