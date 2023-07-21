package lt.auskim;

import java.io.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextProcessors {
    private String outputDirectory;
    private List<String> readWords;

    public TextProcessors(String filePath) {
        this.processors = new HashMap<>();
        this.outputDirectory = "output/";
        this.readWords = readFromFile(filePath);
    }

    private static Map<TextProcessor, String> processors;

    public static void addProcessor(TextProcessor processor) {
        processors.put(processor, processor.getMethodName());
    }

    public void runProcessors() {
        for (TextProcessor processor : processors.keySet()) {
            List<String> input = new ArrayList<>();
            process(processor);
        }

    }

    private List<String> readFromFile(String filePath) {
        List<String> words = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim(); // Trim leading and trailing whitespace
                if (!line.isEmpty()) { // Skip empty lines
                    String[] wordsInLine = line.split("\\W+");
                    for (String word : wordsInLine) {
                        if (!word.isEmpty()) {
                            words.add(word.toLowerCase());
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

    public List<String> process(TextProcessor processor) {
        try {
            List<String> processedWords = processor.process(readWords);
            writeProcessedWordsToFile(processor, processedWords);
            return processedWords;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void writeProcessedWordsToFile(TextProcessor processor, List<String> processedWords) {
        String processorName = processor.getMethodName();
//        System.out.println(processorName);
        String outputFile = outputDirectory + "output." + processorName;

        try {
            File directory = new File(outputDirectory);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
                for (String word : processedWords) {
                    bw.write(word);
                    bw.newLine();
                }
                System.out.println("Processed words have been written to: " + outputFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}