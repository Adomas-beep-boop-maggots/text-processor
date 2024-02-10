package lt.auskim;

import static lt.auskim.FileIOProcessor.*;

import java.util.*;

public class ProcessorGrouped extends WordProcessor {
    public ProcessorGrouped() {
        super("group");
    }
    public ProcessorGrouped(String methodName) {
        super(methodName);
    }
@Override
public List<String> process(List<String> words) {
    Map<String, Integer> wordCount = new HashMap<>();
    List<String> result = new ArrayList<>();

    for (String word : words) {
        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
    }

    for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
        result.add(entry.getKey() + ": " + entry.getValue());
    }
    return result;
}

    @Override
    public boolean test(List<String> lines) {
        Set<String> uniqueWords = new HashSet<>();

        for (String line : lines) {
            String[] parts = line.split(": ");
            if (parts.length != 2) {
                return false;
            }

            String word = parts[0].trim();
            String number = parts[1].trim();

            try {
                Integer.parseInt(number);
            } catch (NumberFormatException e) {
                return false;
            }

            if (!uniqueWords.add(word)) {
                return false;
            }
        }
        return true;
    }
}
