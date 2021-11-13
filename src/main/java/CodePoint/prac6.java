package CodePoint;

import java.util.ArrayList;
import java.util.List;

/**

 */
public class prac6 {

    public static void main(String[] args) {
        prac6 t = new prac6();
        t.letterCombinations("23");
    }
    String[] phoneStr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        backtracking(digits, 0);
        return res;
    }

    private void backtracking(String digits, int idx) {
        if (path.length() == digits.length()){
            // 结束
            res.add(path.toString());
            return;
        }

        // 取出digits的数字   digits.charAt(idx);
        // 然后再去列表中找出对应的字母
        String s = phoneStr[digits.charAt(idx)  - '0'];
        for (int i = 0; i < s.length(); i++) {
            path.append(s.charAt(i));
            backtracking(digits, idx + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
