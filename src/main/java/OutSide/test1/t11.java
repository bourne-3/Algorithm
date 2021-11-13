package OutSide.test1;

/**

 */
public class t11 {

    public static void main(String[] args) {
        t11 s = new t11();
//        int[] nums = {10,2,12,3,5};
        int[] nums = {5,3 ,2,1};
        s.heapSort(nums);

        // 结果
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    void heapSort(int[] nums){
        int size = nums.length;
        for (int i = size / 2 - 1; i >= 0; i--){
            adjust(nums, i, size);
        }

        for (int i = size - 1; i >= 1; i--){
            swap(nums, 0, i);
            adjust(nums, 0, i);  // 这里的不应再是size，而是i，（因为i才是新的长度
        }
    }

    private void adjust(int[] nums, int vertexIdx, int size) {
        int left = vertexIdx * 2 + 1;
        int right = vertexIdx * 2 + 2;
        int maxIdx = vertexIdx;
        if (left < size && nums[left] > nums[maxIdx]) maxIdx = left;
        if (right < size && nums[right] > nums[maxIdx]) maxIdx = right;
        if (maxIdx != vertexIdx){
            swap(nums, maxIdx, vertexIdx);
            adjust(nums, maxIdx, size);
        }

    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
