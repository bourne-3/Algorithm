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

    void heapSort(int[] nums) {
        int size = nums.length;
        // 这里i初始化为最小的非叶子节点
        for (int i = size / 2 - 1; i >= 0; i--) {
            adjust(nums, size, i);
        }
        for (int i = size - 1; i >= 1; i--) {
            // 每次都把数字的顶部节点和最末尾的叶子节点交换
            swap(nums, 0, i);

            // 将剩余的i-1个进行交换  （注意这里是 左闭右开的）
            adjust(nums, i, 0);
        }
    }

    void adjust(int[] nums, int len, int index) {
        int l = 2 * index + 1;
        int r = 2 * index + 2;
        int maxIndex = index;
        if (l < len && nums[l] > nums[maxIndex]) maxIndex = l;
        if (r < len && nums[r] > nums[maxIndex]) maxIndex = r;
        if (maxIndex != index) {
            // 交换
            swap(nums, maxIndex, index);

            adjust(nums, len, maxIndex);
        }
    }

    void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
