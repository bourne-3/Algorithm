package OutSide.test1;

import java.util.ArrayList;
import java.util.List;

/**

 */
public class t03 {

    public static void main(String[] args) {

    }
    List<String> res = new ArrayList<>();
    StringBuilder tmp  = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        backtracking(n, 0, 0);
        return res;
    }

    private void backtracking(int n, int left, int right) {
        if (left == right && right == n){
            res.add(tmp.toString());
            return;
        }

        if (left < n){
            tmp.append('(');
            backtracking(n, left+1, right);
            tmp.deleteCharAt(tmp.length() - 1);
        }

        if (right < left){
            tmp.append(')');
            backtracking(n, left, right + 1);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }
}
