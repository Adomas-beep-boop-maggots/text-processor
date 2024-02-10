package lt.auskim;

import static lt.auskim.FileIOProcessor.*;
import java.util.*;
import java.util.Objects;

public class ProcessorSort extends WordProcessor {
    public ProcessorSort() {
        super("sort");
    }

    public ProcessorSort(String methodName) {
        super(methodName);
    }
    @Override
    public List<String> process(List<String> words) {
        Collections.sort(words);
        return words;
    }

    @Override
    public boolean test(List<String> lines) {
        List<String> expect = process(new ArrayList<String>(lines));

//      WRONG!!!
//      List<String> expect = process(lines);

        return Objects.equals(lines, expect);
    }
}