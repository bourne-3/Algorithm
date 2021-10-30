package CodePoint;

import java.util.ArrayList;
import java.util.List;

/**
 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

 String[] numString = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
 */
public class prac4 {
    String[] numString = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    StringBuilder tmp = new StringBuilder();
    List<String> res = new ArrayList<>();
    public static void main(String[] args) {
        prac4 t = new prac4();
        t.helper("23");
    }

    public void helper(String digits) {
        backtracking(digits, 0);
        // 输出结果
        for (String s : this.res) {
            System.out.print(s + " ");
        }
    }

    private void backtracking(String digits, int idx) {

        // base case （也就是结束条件）
        if (tmp.length() == digits.length()){
            res.add(tmp.toString());
            return;
        }

        // 取出numsString中的字符串
            // 首先去除digits中的数字，然后根据其数字在numString内部中找出字符串
        String s = numString[digits.charAt(idx) - '0'];
        // 遍历这个字符串
        for (int i = 0; i < s.length(); i++) {
            // 把字符串中的char拿出来
            tmp.append(s.charAt(i));
            backtracking(digits, idx+1);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }
}
