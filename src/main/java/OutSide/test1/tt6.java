package OutSide.test1;

import java.util.ArrayList;
import java.util.List;

/**

 */
public class tt6 {

    public static void main(String[] args) {
        int[][] res = findContinuousSequence(9);
        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i + " ");
            }
            System.out.println("===");
        }


    }

    public static int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();

        for (int l = 1, r = 1, sum = 0; r < target; r++){
            sum += r;
            while (sum > target) {
                sum -= l++;
            }
            if (sum == target){
                int[] tmp = new int[r - l + 1];
                for (int k = 0; k < tmp.length; k++){
                    tmp[k] = l + k;
                }
                list.add(tmp);
            }



        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
