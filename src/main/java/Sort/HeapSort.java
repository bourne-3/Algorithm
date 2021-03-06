package Sort;

/**

 */
public class HeapSort {

    public static void main(String[] args) {
        HeapSort s = new HeapSort();

        int[] nums = {10,2,12,3,5};
        s.heapSort(nums);

        // 结果
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    void heapSort(int[] nums){
        int size = nums.length;
        // 定位最后的非叶子节点。因此需要用除法
        for (int i = size / 2 - 1; i >= 0; i--){
            adjust(nums, i, size);
        }

        for (int i = size - 1; i >= 1; i--){  // 注意这里是 >= 1 。 0每次都是被拿出来的
            swap(nums, 0, i);
            adjust(nums, 0, i);  // 这里的不应再是size，而是i，（因为i才是新的长度
        }
    }

    // 注意这里是vertexIdx
    private void adjust(int[] nums, int vertexIdx, int size) {
        int left = vertexIdx * 2 + 1;
        int right = vertexIdx * 2 + 2;
        int maxIdx = vertexIdx;
        if (left < size && nums[left] > nums[maxIdx]) maxIdx = left;
        if (right < size && nums[right] > nums[maxIdx]) maxIdx = right;
        if (maxIdx != vertexIdx){
            swap(nums, maxIdx, vertexIdx);
            adjust(nums, maxIdx, size);  // 递归，将maxIdx作为新的顶点
        }

    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
