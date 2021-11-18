package CodeTop.Tencent;

import java.util.HashMap;

/**

 */
public class prac29 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        twoSum(nums, target);
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];  // a + b = target  ==>  a = target - b;
            if (map.containsKey(val)){
                res[0] = i;
                res[1] = map.get(val);
                break;
            }
            map.put(nums[i], i);  // 这里是把nums[i]放入！
        }
        return res;
    }
}
