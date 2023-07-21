import lt.auskim.TextProcessor;
import lt.auskim.TextProcessors;
import lt.auskim.TextProcessorsDefault;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        TextProcessorsDefault runner = new TextProcessorsDefault("input.txt");
//        runner.process(new TextProcessorsDefault.GroupedProcessor());
        runner.runProcessors();
    }
}