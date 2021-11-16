package OutSide.test1.saveQuestion;

/**
    最小公倍数和最大公约数
 */
public class Q2 {

    public static void main(String[] args) {
        Q2 t = new Q2();

        int val1 = 60, val2 = 24;

        int n1 = t.getGcd(val1, val2);
        System.out.println(val1 + "和" + val2 + " 最大公约数为：" + n1);
        int n2 = t.getLcm(val1, val2);
        System.out.println(val1 + "和" + val2 + " 最小公约数为：" + n2);
    }

    // 最小公倍数   它依赖于最大公约数
    public int getLcm(int a, int b) {
        /**
         * 何为最小公倍数？能同时被数字m和数字n整除的最小整数。例如，24和60的最小公倍数等于120
         */
        int gcd = getGcd(a, b); // 得到最大公约数
        int lcm = a * b / gcd;  // 这是一个公式 (a,b) * [a,b]=ab(a,b均为整数)。
        return lcm;
    }

    // 最大公约数   使用辗转相除法
    public int getGcd(int a, int b){
        return b == 0 ? a : getGcd(b, a % b);
    }

    /**
     * 非递归的写法
     * while(n > 0)
     *          {
     *             int temp = m % n;
     *             m = n;
     *             n = temp;
     *         }
     return m;
     */
}
