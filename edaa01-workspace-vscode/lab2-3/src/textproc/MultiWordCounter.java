package textproc;

//import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MultiWordCounter implements TextProcessor {
    private Map<String, Integer> map;

    public MultiWordCounter(String[] words) {
        map = new TreeMap<>();
        for (String key : words) {
            map.putIfAbsent(key, 0);
        }

    }

    @Override
    public void process(String w) {
        if (map.containsKey(w)) {
            map.put(w, map.get(w) + 1);
        }
    }

    @Override
    public void report() {
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }

}
