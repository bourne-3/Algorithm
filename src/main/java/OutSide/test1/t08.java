package OutSide.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**

 */
public class t08 {
    List<String> res = new ArrayList<>();
    StringBuilder tmp = new StringBuilder();
    boolean[] hasUsed;

    public static void main(String[] args) {
//        String s = "abc";
        String s = "aab";
        t08 t = new t08();
        t.permutation(s);
        for (String demo : t.res) {
            System.out.print(demo + " ");
        }
    }

    public void permutation(String s) {
        char[] chs = s.toCharArray();
        hasUsed = new boolean[chs.length];
//        Arrays.sort(chs);
        backtracking(chs, hasUsed);

    }

    private void backtracking(char[] chs, boolean[] hasUsed) {
        if (chs.length == tmp.length()){
            // 结果添加
            res.add(tmp.toString());
            return;
        }

        for (int i = 0; i < chs.length; i++) {
            // 这一部分去重不可以少
            if (i > 0 && chs[i] == chs[i - 1] && hasUsed[i - 1] == false) {
                continue;
            }


            if (hasUsed[i] == false){
                hasUsed[i] = true;
                tmp.append(chs[i]);
                backtracking(chs, hasUsed);
                hasUsed[i] = false;
                tmp.deleteCharAt(tmp.length()-1);
            }
        }
    }
}
