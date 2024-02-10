package lt.auskim;

import java.util.List;
public abstract class WordProcessor {
    protected String methodName;
    public WordProcessor(String methodName) {
        this.methodName = methodName;
    }

    public abstract List<String> process(List<String> words);
    public abstract boolean test(List<String> lines);
}