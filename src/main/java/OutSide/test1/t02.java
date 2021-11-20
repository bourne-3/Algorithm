package OutSide.test1;

/**

 */
public class t02 {

    public static void main(String[] args) {
        String res = addStrings("11", "123");
        System.out.println(res);
    }

    public static String addStrings(String num1, String num2) {
        int carray = 0;
        StringBuilder path =  new StringBuilder();
        int i = num1.length() - 1 , j = num2.length() - 1;


        while (i >= 0 || j >= 0){
            int n = i >= 0 ? num1.charAt(i) - '0' : 0;
            int m = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n + m + carray;
            carray = tmp / 10;
            path.append(tmp % 10);
            i--;
            j--;
        }


        // 收尾
        if (carray != 0) path.append(carray);
        return path.reverse().toString();
    }
}
