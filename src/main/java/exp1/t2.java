package exp1;

import java.util.ArrayList;
import java.util.List;

/**
    括号生成
 输入：n = 3
 输出：["((()))","(()())","(())()","()(())","()()()"]
 */
public class t2 {

    public static void main(String[] args) {
        t2 t = new t2();
        System.out.println(t.generateParenthesis(3));
    }

    List<String> res = new ArrayList<>();
    StringBuilder tmp = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        backtracking(0, 0, n, tmp);
        return res;
    }

    private void backtracking(int l, int r, int n, StringBuilder tmp) {
        if (r == l && r == n){
            res.add(tmp.toString());
            return;
        }

        if (l < n){
            backtracking(l + 1, r, n, tmp.append("("));
            tmp.deleteCharAt(tmp.length()-1);
        }

        if (r < l){
            backtracking(l, r + 1, n, tmp.append(")"));
            tmp.deleteCharAt(tmp.length()-1);
        }
    }
}
