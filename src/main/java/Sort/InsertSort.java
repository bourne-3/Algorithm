package Sort;

/**

 */
public class InsertSort {

    public static void main(String[] args) {
        int[] nums = {4,3,5,7,12};
        Sort(nums);;

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }




    public static void Sort(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            int tmp = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > tmp){
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = tmp;
        }
    }
}
