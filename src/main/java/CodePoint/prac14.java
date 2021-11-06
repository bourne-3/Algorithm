package CodePoint;

/**

 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。


 */
public class prac14 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        exchange(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public  static int[] exchange(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r){
            while (l < r && nums[r] % 2 == 0) r--;
            while (l < r && nums[l] % 2 != 0) l++;
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
        return nums;
    }
}
