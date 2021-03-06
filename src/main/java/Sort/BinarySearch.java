package Sort;

/**
    1 首先看 r 取的值是否获得 nums.length - 1 可以获得， nums.length的话就不可以获得
        根据此来判断while是否要取 = 号， 以及 l = mid + 1 还是 l = mid
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 6, 10, 12, 20};
        int target = 6;  // res 3
        BinarySearch binarySearch = new BinarySearch();
        int res = binarySearch.search(nums, target);
        System.out.println(res);
    }

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1; // 这里的r注意
        while (l <= r){  // 这里的 = 号 注意
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) l = mid + 1;  // 注意 由于在上面已经考虑了mid 所以这次mid就不考虑了
            else if (nums[mid] > target) r = mid - 1;
        }
        return -1;
    }
}
