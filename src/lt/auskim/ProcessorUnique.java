package lt.auskim;

import static lt.auskim.FileIOProcessor.*;
import java.util.*;

public class ProcessorUnique extends WordProcessor {
    public ProcessorUnique() {
        super("unique");
    }

    public ProcessorUnique(String methodName) {
        super(methodName);
    };

    @Override
    public List<String> process(List<String> words) {
        Map<String, Integer> wordCount = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            result.add(entry.getKey());
        }
        return result;
    }
    @Override
    public boolean test(List<String> lines) {
        Set<String> stringSet = new HashSet<>();
        for (String str : lines) {
            if (!stringSet.add(str)) {
                return false;
            }
        }
        return true;
    }
}