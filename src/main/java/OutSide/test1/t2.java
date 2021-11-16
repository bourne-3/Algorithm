package OutSide.test1;

/**

 */
public class t2 {

    public static void main(String[] args) {

    }

    public int findRepeatNumber(int[] nums) {
        int count = 0;
        while (count < nums.length){
            if (nums[count] == count) {
                count++;
                continue;
            }

            int nIdx = nums[count];
            if (nums[nIdx] == nIdx) return nIdx;

            int tmp = nums[nIdx];
            nums[nIdx] = nums[count];
            nums[count] = tmp;
        }
        return -1;
    }

    void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
