package CodeTop.Tencent;

/**

 */
public class prac3 {

    public static void main(String[] args) {
        prac3 t = new prac3();
        int[] nums = {21, 13, 2, 4, 11};
        t.heapSort(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }


    }

    public void heapSort(int[] nums) {
        int size = nums.length;
        // 找出第一个非叶子节点
        for (int i = size / 2 - 1; i >= 0; i--){
            adjust(nums, i, size - 1);
        }

        for (int i = size - 1; i >= 1; i--){
            swap(nums, 0, i);
            adjust(nums, 0, i);
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

    private void swap(int[] nums, int i, int i1) {
        int tmp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = tmp;
    }
}
