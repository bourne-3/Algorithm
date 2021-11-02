package CodePoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 以数组 intervals 表示若干个区间的集合，
 其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。

 */
public class prac15 {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        prac15 t = new prac15();
        t.merge(intervals);
    }

    public void merge(int[][] intervals) {
        // 根据第一个元素排序
        Arrays.sort(intervals, ((o1, o2) -> Integer.compare(o1[0], o2[0])));;

        // 记录start
        int start = intervals[0][0];

        List<int[]> res = new ArrayList<>();

        // 循环
        for (int i = 1; i < intervals.length; i++){
            // 两个括号的内部是否有交叉
            if (intervals[i][0] > intervals[i-1][1]){
                // 不会重合，直接加到结果中
                res.add(new int[]{start, intervals[i-1][1]});
                start = intervals[i][0];
            }else {
                // start不用变 改变右边，谁大就是谁
                intervals[i][1] = Math.max(intervals[i-1][1], intervals[i][1]);
            }
        }
        // 最终收尾
        res.add(new int[]{start, intervals[intervals.length - 1][1]});

        int[][] resToArray = res.toArray(new int[res.size()][]);

        for (int[] arr : resToArray) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.print("|| ");
        }

    }
}
