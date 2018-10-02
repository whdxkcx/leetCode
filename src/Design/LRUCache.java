package Design;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class LRUCache {
   private  LinkedHashMap<Integer, Integer> map = null;
   private int capacity = 0;



    public LRUCache(int capacity) {
        this.map = new LinkedHashMap<>();
        this.capacity = capacity;

    }

    public int get(int key) {
        int val = map.getOrDefault(key, -1);
        if (val != -1) {
            map.remove(key);
            map.put(key, val);
        }
        return val;
    }

    public void put(int key, int value) {
        if (get(key) == -1 && map.size() >= capacity) {
            map.remove(map.keySet().iterator().next());
        }
        map.put(key, value);
    }
}
