package OutSide.test1;

import org.omg.CORBA.MARSHAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**

 */
public class t04 {

    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {
        // 根据第一个元素排序
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        List<int[]> res = new ArrayList<>();

        int start = intervals[0][0];
        for (int i = 1; i < intervals.length; i++){
            if (intervals[i][0] > intervals[i-1][1]){
                res.add(new int[]{start, intervals[i-1][1]});
                start = intervals[i][0];
            }else {
                intervals[i][1] = Math.max(intervals[i-1][1], intervals[i][1]);
            }
        }

        res.add(new int[]{start, intervals[intervals.length-1][1]});
//        int[][] ints = res.toArray(new int[res.size()][]);

        return null;
    }
}
