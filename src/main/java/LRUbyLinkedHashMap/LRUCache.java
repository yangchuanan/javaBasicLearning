package LRUbyLinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-06 20:35
 * @Descripe 基于LinkedHashMap实现LRU缓存
 * @Version 0.0.1
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    public static final int MAX_ENTRIES = 3;

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_ENTRIES;
    }

    LRUCache() {
        super(MAX_ENTRIES, 0.75f, true);
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>();
        cache.put(1, "a");
        cache.put(2, "b");
        cache.put(3, "c");
        cache.get(1);
        cache.put(4, "d");
        System.out.println(cache.keySet());
    }
}
