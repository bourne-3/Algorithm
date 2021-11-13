package OutSide.test1;

/**

 */
public class t10 {

    public static void main(String[] args) {
        t10 s = new t10();
        int[] nums = {10,2,12,3,5};
        s.heapSort(nums);

        // 结果
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    void heapSort(int[] nums) {

        // 最后一个非叶子节点
        int size = nums.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            adjust(nums, i, size);
        }

        for (int i = size - 1; i >= 1; i--) {  // 这里是大于等于1
            swap(nums, 0, i);
            adjust(nums, 0, i);
        }
    }

    private void adjust(int[] nums, int idx, int size) {
        int left = idx * 2 + 1;
        int right = idx * 2 + 2;
        int maxIdx = idx;
        if (left < size && nums[left] > nums[maxIdx]) maxIdx = left;
        if (right < size && nums[right] > nums[maxIdx]) maxIdx = right;
        if (maxIdx != idx){
            swap(nums, maxIdx, idx);
            adjust(nums, maxIdx, size);
        }
    }

    private void swap(int[] nums, int i, int i1) {
        int tmp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = tmp;
    }
}
