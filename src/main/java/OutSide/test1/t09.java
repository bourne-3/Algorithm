package OutSide.test1;

import java.util.HashMap;

/**

 */
public class t09 {

    public static void main(String[] args) {
        int[] in = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int i = majorityElement(in);
        System.out.println(i);
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }else {
                map.put(nums[i], 0);
            }
            if (map.get(nums[i]) > max) {
                max = map.get(nums[i]);
                res = nums[i];
            }
        }
        return res;
    }
}
