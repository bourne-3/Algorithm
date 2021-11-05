package OutSide.test1;

/**

 */
public class tt3 {

    public static void main(String[] args) {
        tt3 t = new tt3();
        int res = t.findRightBound(new int[]{5, 7, 7, 8, 8, 10}, 8) - t.findRightBound(new int[]{5, 7, 7, 8, 8, 10}, 8 - 1);
        System.out.println(res);
    }

    public int search(int[] nums, int target) {
        return findRightBound(nums, target) - findRightBound(nums, target - 1);
    }

    public int findRightBound(int[] nums, int target){
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int mid = (l + r) / 2;
            if (nums[mid] <= target) l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }
}
