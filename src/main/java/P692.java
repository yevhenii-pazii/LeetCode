import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;

public class P692 {

    public static void main(String[] args) {
        System.out.println(new P692().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println(new P692().topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>(words.length);
        for (var s : words) {
            map.merge(s, 1, Integer::sum);
        }

        Comparator<String> comparator = (s1, s2) -> map.get(s2) - map.get(s1);
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(map.keySet().size(),
                comparator.thenComparing(Function.identity()));
        priorityQueue.addAll(map.keySet());


        List<String> result = new ArrayList<>(k);
        for (; k > 0; k--) {
            result.add(priorityQueue.remove());
        }

        return result;
    }
}
