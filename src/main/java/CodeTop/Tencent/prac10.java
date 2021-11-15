package CodeTop.Tencent;

import java.util.ArrayList;
import java.util.List;

/**

 */
public class prac10 {

    public static void main(String[] args) {

    }

    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int cur = 0;
        while (list.size() > 1){
            int size = list.size();
            cur = (cur + m - 1) % size;
            list.remove(cur);
        }
        return list.get(0);
    }
}
