package CodePoint;

/**
 构建乘积数组
 */
public class prac67 {

    public static void main(String[] args) {

    }

    public int[] constructArr(int[] a) {
        // 边界
        if (a.length == 0) return new int[]{};

        // 定义dp数组以及初始化状态
        // left数组表示 left[i] 在i时刻前所有数组的累计 （这里不会包含i）
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        // 两个状态都是从1开始累计
        left[0] = 1;
        right[a.length - 1] = 1;

        //从左到右
        for (int i = 1; i < left.length; i++) {
            left[i] = left[i-1] * a[i-1];  // left[i-1]记录这累计量
        }
        //从右到左
        for (int i = right.length - 2; i >= 0; i--){
            right[i] = right[i+1] * a[i+1];
        }

        // 结果收集
        int[] res = new int[a.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;


    }
}
