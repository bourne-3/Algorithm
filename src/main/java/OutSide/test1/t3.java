package OutSide.test1;

/**

 */
public class t3 {

    public static void main(String[] args) {

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKthNum(nums1, 0, nums2, 0, left) + findKthNum(nums1, 0, nums2, 0, right)) / 2.0;
    }

    private double findKthNum(int[] nums1, int i, int[] nums2, int j, int mid) {
        // i和j表示两个数组的起始位置
        // 边界条件
        if (i == 0) return nums2[j + mid];
        if (j == 0) return nums1[i + mid];
        if (i == j) return Math.max(nums1[i], nums2[j]);

        // 一般情况
        int val1 = i + mid / 2 < nums1.length ? nums1[i + mid / 2] : Integer.MAX_VALUE;
        int val2 = j + mid / 2 < nums2.length ? nums1[j + mid / 2] : Integer.MAX_VALUE;

        if (val1 < val2){
            return findKthNum(nums1, i + mid / 2 , nums2,j,mid - mid/2);
        }else {
            return findKthNum(nums1, i  , nums2,j + mid / 2,mid - mid/2);
        }
    }
}
