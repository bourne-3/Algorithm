package OutSide.test1;

/**

 */
public class t02 {

    public static void main(String[] args) {
        int[] nums = {59, 1, 30, 5, 29};

        t02 t = new t02();
        t.Sort(nums, 0, nums.length - 1);

        // output
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public void Sort(int[] nums, int l, int r) {
        if (l < r){
            int idx = Partition(nums, l, r);
            Sort(nums, l, idx - 1);
            Sort(nums, idx + 1, r);
        }
    }

    private int Partition(int[] nums, int l, int r) {
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
