package OutSide.test1;

/**

 */
public class t3 {

    public static void main(String[] args) {
        int[] nums = {1 ,3 ,4 ,2 ,2};
        findDuplicate(nums);
    }

    public static int findDuplicate(int[] nums) {
        // 环形链表
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        // 找到交点了 fast重新回到头部
        fast = 0;
        while (fast != slow){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;

    }
}
