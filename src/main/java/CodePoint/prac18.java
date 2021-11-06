package CodePoint;

import java.util.ArrayList;
import java.util.List;

/**
 括号生成

 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

 有效括号组合需满足：左括号必须以正确的顺序闭合。
 */
public class prac18 {

    public static void main(String[] args) {
        prac18 t = new prac18();
        List<String> res = t.generateParenthesis(3);
        System.out.println(res);
    }
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtracking(n, 0, 0, "");
        return res;
    }

    private void backtracking(int n, int left, int right, String s) {
        if (left == right && n == right){
            res.add(s);
            return;
        }

        if (left < n){
            backtracking(n, left+1,right,s+"(");
        }

        if (right < left){
            backtracking(n, left,right + 1,s+")");
        }
    }
}
