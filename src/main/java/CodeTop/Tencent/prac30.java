package CodeTop.Tencent;

/**

 */
public class prac30 {

    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        int vote = 0, z = 0;
        for (int n : nums) {
            if (vote == 0) z = n;
            vote += z == n ? 1 : -1;
        }
        return z;
    }
}
