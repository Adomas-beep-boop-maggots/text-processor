package lt.auskim;

import java.util.ArrayList;
import java.util.List;

public class FileIOProcessor extends FileIO {

    public static void setDefaultOutputFile(String defaultFile) {
        createDirectory(defaultFile);
        defaultOutputFile = defaultFile;
    }

    public static void setDefaultInputFile(String defaultFile) {
        createDirectory(defaultFile);
        defaultInputFile = defaultFile;
    }
    public static String defaultOutputFile = "output.txt";
    public static String defaultInputFile = "input.txt";

    public static String getDefaultOutputFileExt(WordProcessor processor) {
        return changeFileExtention(defaultOutputFile, processor);
    }
    private static String addFileExtension(String filename, WordProcessor processor) {
        if (filename.endsWith("." + processor.methodName)) {
            return filename;
        } else {
            return filename + "." + processor.methodName;
        }
    }
    public static String changeFileExtention(String filename, WordProcessor processor) {
        String striped = FileIO.stripFileExtension(filename);
        return addFileExtension(striped, processor);
    }
    public static List<String> readAndProcessWords(WordProcessor processor) {
        List<String> words = readFileToWords(defaultInputFile);
        return processor.process(words);
    }

    public static void writeProcessedWordsToFile(List<String> words, WordProcessor processor) {
        FileIO.writeWordsToFile(getDefaultOutputFileExt(processor), words);
    }

    public static boolean readFileAndTest(WordProcessor processor) {
        List<String> lines = FileIO.readFileLines(getDefaultOutputFileExt(processor));
        return processor.test(lines);
    }

    public static void deleteFile(WordProcessor processor) {
        deleteFile(getDefaultOutputFileExt(processor));
    }
}
