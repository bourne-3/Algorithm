package OutSide.test1;

/**

 */
public class t02 {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
//        int[] nums = {1};
        int target = 6;
        t02 t = new t02();
        int[] res = t.searchRange(nums, target);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int t1 = helper(nums, target);
        int t2 = helper(nums, target - 1);
        //if (t1 == 0 || t2 == 0) return new int[]{-1, -1};
        return new int[]{t2, t1-1};
    }


    int helper(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int flag = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                l = mid + 1;
                flag = 1;
            }else if (nums[mid] < target){
                l = mid + 1;
            }else if (nums[mid] > target){
                r = mid - 1;
            }
        }
        return flag == 0 ? 0 : l;
    }
}
