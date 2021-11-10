package LeetCodeTop100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 合并区间
 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。

 */
public class prac22 {

    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, ((o1, o2) -> Integer.compare(o1[0], o2[0])));
        int start = intervals[0][0];
        List<int[]> res = new ArrayList<>();
        for (int i = 1; i < intervals.length ; i++) {
            if (intervals[i][0] > intervals[i-1][1]){
                // 添加
                res.add(new int[]{start, intervals[i-1][1]});
                start = intervals[i][0];
            }else {
                // 因为这里的i会变成下一次的i-1
                intervals[i][1] = Math.max(intervals[i-1][1], intervals[i][1]);
            }
        }
        // 收尾
        res.add(new int[]{start, intervals[intervals.length - 1][1]});
        int[][] out = res.toArray(new int[res.size() - 1][]);
        return out;
    }
}
