package OutSide.test1;

import java.util.HashMap;

/**
 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 */
public class t02 {

    public static void main(String[] args) {
        t02 t = new t02();
        t.T01();
    }

    public int search(int[] nums, int target) {
        // 滑动窗口的思路
        int idx = BSearch(nums,target);
        if (idx == -1) return 0;
        // 向两边滑动
        int l = idx, r = idx;
        // 向左边
        while (l - 1 >= 0 && nums[l-1] == nums[idx]) l--;
        while (r + 1 < nums.length && nums[r + 1] == nums[idx]) r++;
        return r - l + 1;
    }

    private int BSearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int mid = l + (r - l )/ 2;
            if (nums[mid] < target) l = mid + 1;
            else if (nums[mid] > target) r = mid - 1;
            else return mid;
        }
        return -1; // 没找到
    }

    public void T01(){
        int[] nums = {2,1,3,19};
        sortArray(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public int[] sortArray(int[] nums) {
        merge(nums, 0, nums.length - 1);
        return nums;
    }

    private void merge(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = l + (r-l)/2;
        merge(nums, l, mid);
        merge(nums, mid + 1, r);
        mergeSort(nums, l, r, mid);
    }

    private void mergeSort(int[] nums, int l, int r, int mid) {

        int t1 = l, t2 = mid + 1;
        int[] tmp = new int[r - l + 1];
        int c = 0;
        while (t1 <= mid && t2 <= r){
            if (nums[t1] <= nums[t2]) tmp[c++] = nums[t1++];
            else tmp[c++] = nums[t2++];
        }

        while (t1 <= mid) tmp[c++] = nums[t1++];
        while (t2 <= r) tmp[c++] = nums[t2++];

        for (int i = 0; i < tmp.length; i++) {
            nums[i + l] = tmp[i];
        }

    }

    public char firstUniqChar(String s) {
        if (s.length() == 0) return ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chs = s.toCharArray();
        for (char c:chs){
            if (map.containsKey(c)){
                map.put(c, map.get(c) + 1);
                continue;
            }

            map.put(c, 1);
        }

        for (char c:chs){
            int val = map.get(c);
            if (val == 1) return c;
        }
        return ' ';
    }
}
