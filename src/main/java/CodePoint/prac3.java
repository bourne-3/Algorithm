package CodePoint;

/**
 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，
 输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。

 */
public class prac3 {

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};  // 旋转点为1
        prac3 t = new prac3();
        int res = t.helper(nums);
        System.out.println("旋转点为：" + res);

    }

    public int helper(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r){
            int mid = (l + r) / 2;
            if (nums[mid] < nums[r]) r = mid;
            else if (nums[mid] > nums[r]) l = mid + 1;
            else {
                return findMin(nums, l , r);
            }
        }
        return nums[l];
    }

    private int findMin(int[] nums, int l, int r) {
        int min = nums[l];
        for (int i = l; i < r; i++){
            if (nums[i] < min) min = nums[i];
        }
        return min;
    }
}
