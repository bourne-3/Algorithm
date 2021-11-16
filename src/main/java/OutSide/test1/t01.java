package OutSide.test1;

/**

 */
public class t01 {

    public static void main(String[] args) {
        t01 t = new t01();
        int[] nums = {1, 3,3};
        t.findMin(nums);
    }

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r){
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) r = mid;
            else if(nums[mid] > nums[r]) l = mid + 1;
            else return findRes(nums, l, r);
        }
        return nums[l];
    }

    private int findRes(int[] nums, int l, int r) {
        int res = nums[l];
        for (int i = l; i <= r; i++){
            if (nums[i] < res) res = nums[i];
        }
        return res;
    }
}
