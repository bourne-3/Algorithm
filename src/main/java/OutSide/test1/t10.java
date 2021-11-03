package OutSide.test1;

/**

 */
public class t10 {

    public static void main(String[] args) {
        int[] nums = {19, 2, 8 ,10 ,21};
        t10 t = new t10();
        t.Sort(nums, 0, nums.length - 1);

        // out
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    void Sort(int[] nums, int l, int r){
        if (l < r){
            int pivot = partition(nums, l, r);
            Sort(nums, l, pivot - 1);
            Sort(nums, pivot + 1, r);
        }
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        while (l < r){
            while (l < r && nums[r] >= pivot) r--;
            nums[l] = nums[r];
            while (l < r && nums[l] <= pivot) l++;
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        return l;
    }

}
