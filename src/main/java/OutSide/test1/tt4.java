package OutSide.test1;

import java.util.HashMap;

/**

 */
public class tt4 {

    public static void main(String[] args) {
        int[] nums = {4,1,4,6};
        singleNumbers(nums);
    }

    public static int[] singleNumbers(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);

            }else {
                map.put(nums[i], 1);
            }

        }
        System.out.println(map);

        return nums;
    }

}
