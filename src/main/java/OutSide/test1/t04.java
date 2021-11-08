package OutSide.test1;

import java.util.ArrayList;
import java.util.List;

/**

 */
public class t04 {

    public static void main(String[] args) {
//        findContinuousSequence(9);
//        reverseWords("the sky is blue");

        t04 t = new t04();
        t.reverseLeftWords("abcdefg", 2);
    }

    public String reverseLeftWords(String s, int n) {
        // 调用三次helper
        StringBuilder path = new StringBuilder(s);
        helper(path, 0, n - 1);
        helper(path, n, path.length() - 1);
        helper(path, 0, path.length() -1);
        System.out.println(path.toString());
        return path.toString();

    }

    void helper(StringBuilder path, int i, int j){
        while (i < j){
            char left = path.charAt(i);
            char right = path.charAt(j);
            path.setCharAt(i, right);
            path.setCharAt(j, left);
            i++;
            j--;
        }
    }



    public static String reverseWords(String s) {
        s = s.trim();
        int r = s.length() - 1;
        int l = r;
        char[] chs = s.toCharArray();
        StringBuilder path = new StringBuilder();
        while (l >= 0){
            while (l >= 0 && chs[l] != ' ') l--;
            // 遇到空格了
            path.append(s.substring(l + 1, r + 1) + " ");
            while (l >= 0 && chs[l] == ' ') l--;
            r = l;
        }
        return path.toString().trim();

    }


    public static int[][] findContinuousSequence(int target) {
        int left = 1, right = 1;
        int sum = 0;
        List<int[]> path = new ArrayList<>();
        while (right < target){
            sum += right;
            while (sum > target){
                sum -= left;
                left++;
            }
            if (sum == target){
                int[] tmp = new int[right - left + 1];
                for (int i = 0; i < tmp.length; i++) {
                    tmp[i] = left + i;
                }
                path.add(tmp);
            }
            right++;
        }
        int[][] res = path.toArray(new int[path.size()][]);
        return res;
    }
}
