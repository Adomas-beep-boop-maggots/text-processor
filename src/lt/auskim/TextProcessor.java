package lt.auskim;

import java.util.List;

public abstract class TextProcessor {
    private String methodName;

    public abstract List<String> process(List<String> words);

    public TextProcessor(String methodName) {
        this.methodName = methodName;
        TextProcessors.addProcessor(this);
    }

    public String getMethodName() {
        return methodName;
    }
}