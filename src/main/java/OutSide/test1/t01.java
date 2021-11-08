package OutSide.test1;

import java.util.ArrayList;
import java.util.List;

/**

 */
public class t01 {

    public static void main(String[] args) {
        t01 t = new t01();
        t.letterCombinations("23");
    }
    String[] phoneNums = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();
    StringBuilder tmp = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        backtracking(digits, 0);
        return res;
    }

    private void backtracking(String digits, int idx) {
        if (tmp.length() == digits.length()){
            // 结束
            res.add(tmp.toString());
            return;
        }

        // 取出digits中的数字
        String s = phoneNums[digits.charAt(idx) - '0'];  // 第一步是数字中的第几个，第二步是取出phoneNums中的字符串
        for (int i = 0; i < s.length(); i++) {
            tmp.append(s.charAt(i));
            backtracking(digits, idx + 1);
            tmp.deleteCharAt(tmp.length() - 1);
        }

    }
}
