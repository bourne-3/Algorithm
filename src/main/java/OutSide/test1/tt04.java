package OutSide.test1;

import CodePoint.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**

 */
public class tt04 {

    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        int start = intervals[0][0];
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++){
            if (intervals[i][0] > intervals[i-1][1]){
                list.add(new int[]{start, intervals[i-1][1]});
                start = intervals[i][0];
            }else {
                intervals[i][1] = Math.max(intervals[i-1][1], intervals[i][1]);
            }
        }
        // 最终收尾
        list.add(new int[]{start, intervals[intervals.length - 1][1]});
        int[][] res = list.toArray(new int[list.size()][]);
        return res;
    }
}
