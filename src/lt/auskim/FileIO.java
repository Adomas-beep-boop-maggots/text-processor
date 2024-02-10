package lt.auskim;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

public class FileIO {
    public static void createDirectory(String path) {
        int pathIndex = path.lastIndexOf('/');
        if (pathIndex == -1) {
            return;
        }
        String directoryPath = path.substring(0, pathIndex);
        if (!directoryPath.isEmpty()) {
            Path directory = Paths.get(directoryPath);
            if (!Files.exists(directory)) {
                try {
                    Files.createDirectories(directory);
                    System.out.println("Directory created: " + directory);
                } catch (IOException e) {
                    System.err.println("Failed to create directory: " + directory);
                    e.printStackTrace();
                }
            }
        }
    }

    public static String stripFileExtension(String filename) {
        int lastDotIndex = filename.lastIndexOf('.');
        if (lastDotIndex > 0) {
            return filename.substring(0, lastDotIndex);
        } else {
            return filename;
        }
    }

    public static void writeWordsToFile(String filePath, List<String> words) {
        createDirectory(filePath);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String word : words) {
                bw.write(word);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readFileToWords(String filePath) {
        List<String> words = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
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

    public static List<String> readFileLines(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
    public static void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File deleted successfully.");
            } else {
                System.err.println("Failed to delete the file.");
            }
        } else {
            System.err.println("File does not exist.");
        }
    }

    public static void printWords(List<String> words) {
        for (String word : words) {
            System.out.println(word);
        }
    }
}