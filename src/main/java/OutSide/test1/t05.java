package OutSide.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**

 */
public class t05 {

    public static void main(String[] args) {
        t05 t = new t05();
        String[] res = t.permutation("abc");
        for (String s : res) {

            System.out.print(s + " ");
        }
    }
    List<String> res = new ArrayList<>();
    StringBuilder tmp = new StringBuilder();
    boolean[] hasUsed;

    public String[] permutation(String s) {
        char[] chs = s.toCharArray();
        Arrays.sort(chs);
        hasUsed = new boolean[chs.length];
        backtracking(chs);
        String[] out = res.toArray(new String[0]);
        return out;
    }

    private void backtracking(char[] chs) {
        if (tmp.length() == chs.length){
            res.add(tmp.toString());
            return;
        }

        for (int i = 0; i < chs.length; i++) {

            if (i > 0 && chs[i] == chs[i - 1] && hasUsed[i-1] == false) {
                continue;
            }

            if (hasUsed[i] == false){
                hasUsed[i] = true;
                tmp.append(chs[i]);
                backtracking(chs);
                hasUsed[i] = false;
                tmp.deleteCharAt(tmp.length() - 1);
            }
        }

    }


}
