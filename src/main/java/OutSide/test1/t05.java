package OutSide.test1;

/**

 */
public class t05 {

    public static void main(String[] args) {
        trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }

    public static int trap(int[] height) {
        // 两个dp数组，比如int[] left来说， left[i]表示i(包含)之前底部的高度
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = height[0];
        right[len - 1] = height[len - 1];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        for (int i = len - 2; i >= 0 ; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        int res = 0 ;
        for (int i = 0; i < len; i++) {
            int tmp = Math.min(left[i], right[i]) - height[i];
            res += tmp;
        }

        return res;
    }
}
