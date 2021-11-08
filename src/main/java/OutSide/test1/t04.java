package OutSide.test1;

/**

 */
public class t04 {

    public static void main(String[] args) {

        t04 t = new t04();

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        t.maxSubArray(nums);
    }


    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (dp[i-1] > 0){
                dp[i] = dp[i-1] + nums[i];
            }else {
                dp[i] = nums[i];
            }
        }
        return dp[nums.length - 1];
    }


    public int[] getLeastNumbers(int[] arr, int k) {
        int l = 0, r = arr.length - 1;
        recure(arr, l, r, k);
        return arr;
    }

    private void recure(int[] arr, int l, int r, int k) {
        if (l < r){
            int p = partition(arr, l, r);
            if (p < k) recure(arr, l, p - 1, k);
            if (p > k) recure(arr, p + 1, r, k);
        }
    }

    private int partition(int[] arr, int l, int r) {
        int pivot = arr[l];
        while (l < r){
            while (l < r && arr[r] >= pivot) r--;
            arr[l] = arr[r];
            while (l < r && arr[l] <= pivot) l++;
            arr[r] = arr[l];
        }
        arr[l] = pivot;
        return l;
    }


    public String longestPalindrome(String s) {
        String s1 = "";
        String s2 = "";
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            s1 = extend(s, i, i);
            res = s1.length() > res.length() ? s1 : res;
            s2 = extend(s, i, i + 1);
            res = s2.length() > res.length() ? s2 : res;
        }
        return res;
    }

    public String extend(String s, int start, int end){
        String tmp = "";
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            tmp = s.substring(start, end + 1);
            start--;
            end++;
        }
        return tmp;
    }
}
