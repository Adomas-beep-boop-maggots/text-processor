package lt.auskim;

import java.util.*;

public class TextProcessorsDefault extends TextProcessors {
    public TextProcessorsDefault(String filePath) {
        super(filePath);
        TextProcessorsDefault.addProcessor(new SortProcessor());
        TextProcessorsDefault.addProcessor(new GroupedProcessor());
        TextProcessorsDefault.addProcessor(new UniqueProcessor());
    }

    public static class GroupedProcessor extends TextProcessor {
        public GroupedProcessor() {
            super("group");
        }

        @Override
        public List<String> process(List<String> words) {
            Map<String, Integer> wordOccurrences = new HashMap<>();
            for (String word : words) {
                wordOccurrences.put(word, wordOccurrences.getOrDefault(word, 0) + 1);
            }

            List<String> groupedWords = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : wordOccurrences.entrySet()) {
                groupedWords.add(entry.getKey() + ": " + entry.getValue());
            }
            return groupedWords;
        }
    }

    public static class SortProcessor extends TextProcessor {
        public SortProcessor() {
            super("sort");
            TextProcessorsDefault.addProcessor(this);
        }

        @Override
        public List<String> process(List<String> words) {
            List<String> result = new ArrayList<>();
            for (String s : words) {
                result.add(s.toUpperCase());
            }
            return result;
        }
    }

    public static class UniqueProcessor extends TextProcessor {
        public UniqueProcessor() {
            super("unique");
            TextProcessorsDefault.addProcessor(this);
        }

        @Override
        public List<String> process(List<String> words) {
            Set<String> uniqueWords = new HashSet<>(words);
            return new ArrayList<>(uniqueWords);
        }
    }
}
