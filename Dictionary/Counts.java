import java.util.HashMap;

public class Counts {
    private HashMap<String, Integer> counts;

    public Counts() {
        this.counts = new HashMap<>();
        String word = "word";
        counts.merge(word, 1, Integer::sum);
    }

    public Integer countsContainsKey(HashMap<String, Integer> counts, String word) {
        if(counts.containsKey(word)) {
            int i = counts.get(word);
            counts.replace(word, i+1);
            return i+1;
        } else {
            counts.put(word, 1);
            return 1;
        }
    }

    public Integer countsGetAndCheckNull(HashMap<String, Integer> counts, String word) {
        Integer i=0;
        if((i = counts.get(word)) != null) {
            counts.replace(word, i+1);
            return i+1;
        } else {
            counts.put(word, 1);
            return 1;
        }
    }

    public Integer countGetOrDefault(HashMap<String, Integer> counts, String word) {
        Integer i = counts.getOrDefault(word, 1);
        if(counts.replace(word, i+1) == null) {
            counts.put(word, 1);
            return 1;
        }
        return i+1;
    }

    public Integer countPutIfAbsent(HashMap<String, Integer> counts, String word) {
        Integer i=0;
        if((i = counts.putIfAbsent(word, 1)) != null) {
            counts.replace(word, i+1);
            return i+1;
        }
        return 1;
    }
}