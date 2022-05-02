import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        //这道题目只能通过maxHeap来做，因为sorted by frequency from highest to lowest
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i]))
                map.put(words[i], map.get(words[i]) + 1);
            else
                map.put(words[i], 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>
                ((a, b) -> (
                        a.getValue() != b.getValue() ? b.getValue() - a.getValue() : a.getKey().compareTo(b.getKey())));

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            maxHeap.offer(entry);
        }
        for (int i = 0; i < k; i++) {
            res.add(maxHeap.poll().getKey());
        }

        return res;
    }
}

