package textproc;

import java.util.ArrayList;
import java.util.Comparator;
//import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class GeneralWordCounter implements TextProcessor {
    private Map<String, Integer> map;
    private Set<String> stopwords;

    public GeneralWordCounter(Set<String> stopwords) {
        map = new TreeMap<>();
        this.stopwords = stopwords;
    }

    @Override
    public void process(String w) { 
        if (!stopwords.contains(w)) {
            if (map.containsKey(w)) {
                map.put(w, map.get(w) + 1);
            } else {
                map.put(w, 1);
            }
        }
    }

    @Override
    public void report() {

        /* for (String key : map.keySet()) {
            if (map.get(key) >= 200) {
                System.out.println(key + ": " + map.get(key));
            }
        } */

        Set<Map.Entry<String, Integer>> wordSet = map.entrySet();
        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);

        //* Sorterar på förekomster först, sedan alfabetiskt om förekomsterna är lika */
        Comparator<Map.Entry<String, Integer>> comparator = (e1, e2) -> {
            int value = e2.getValue().compareTo(e1.getValue());
            if (value == 0) {
                return e1.getKey().compareTo(e2.getKey());
            }
            return value;
        };

        wordList.sort(comparator);

        for (int i = 0; i < 20; i++) {
            System.out.println(wordList.get(i));
        }
    }

    public List<Map.Entry<String, Integer>> getWordList() {
        return new ArrayList<>(map.entrySet());
    }

}
