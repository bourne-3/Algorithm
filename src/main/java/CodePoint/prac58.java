package CodePoint;

/**
 左旋转字符串

 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

 */
public class prac58 {

    public static void main(String[] args) {

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
}
