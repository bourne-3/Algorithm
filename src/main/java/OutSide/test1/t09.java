package OutSide.test1;

/**

 */
public class t09 {

    public static void main(String[] args) {
        t09 s = new t09();
        int[] nums = {10,2,12,3,5};
        s.heapSort(nums);

        // 结果
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    void heapSort(int[] nums) {
        int len = nums.length;  // 左闭右开
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjust(nums, i, len);
        }

        for (int i = len - 1; i >= 1; i--) {  // 这里是大于等于1
            swap(nums, 0, i);
            adjust(nums, 0, i);
        }
    }

    private void adjust(int[] nums, int i, int len) {
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int maxIdx = i;
        if (l < len && nums[l] > nums[maxIdx]) maxIdx = l;
        if (r < len && nums[r] > nums[maxIdx]) maxIdx = r;
        if (maxIdx != i){
            swap(nums, maxIdx, i);
            adjust(nums, maxIdx, len);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
