package CodePoint;

/**
 旋转数组的最小数字
 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  

 */
public class prac9 {

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2}; // 1
        int res = minArray(nums);
        System.out.println(res);
    }

    public static int minArray(int[] numbers) {
        // 定义两个边界 l r
        int l = 0, r = numbers.length - 1;
        while (l < r){
            int mid = l + (r - l) / 2;
            if (numbers[mid] < numbers[r]) r = mid;
            else if (numbers[mid] > numbers[r]) l = mid + 1;
            else return findRes(numbers, l, r);
        }
        return numbers[l];
    }

    private static int findRes(int[] numbers, int l, int r) {
        int min = numbers[l]; // 这里要把最左边的放进来 而不是用0
        for (int i = l; i < r; i++){
            if (numbers[i] < min) min = numbers[i];
        }
        return min;
    }
}
