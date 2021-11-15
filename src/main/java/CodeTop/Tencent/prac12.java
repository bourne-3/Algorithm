package CodeTop.Tencent;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**

 */
public class prac12 {

    public static void main(String[] args) {
        prac12 t = new prac12(1);
        t.put(2, 1);
        int i = t.get(1);
        System.out.println(i);

    }

    LinkedHashMap<Integer, Integer> map;
    int capacity;
    public prac12(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public int get(int key) {
        if (map.isEmpty() || !map.containsKey(key)) return -1;
        return map.get(key);
    }

    public void put(int key, int value) {
        map.put(key, value);
        if (map.size() > capacity){
            Iterator<Integer> it = map.keySet().iterator();
            map.remove(it.next());
        }
    }
}
