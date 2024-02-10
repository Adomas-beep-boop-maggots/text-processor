package lt.auskim;

import java.util.List;
import static lt.auskim.FileIOProcessor.*;

public class Main {

    public static void main(String[] args) {
        setDefaultInputFile("example/input.txt");
        setDefaultOutputFile("output/output.*");
        WordProcessor processor = new ProcessorGrouped("group");
//        WordProcessor processor = new ProcessorSort("sort");
//        WordProcessor processor = new ProcessorUnique("unique");
//        processor.process();

//      a) nuskaityti teksta is failo.
//      List<String> stringList = FileIO.readFileToWords("input-path.txt");
//      c) nuskaityti (pasirinktinai) failu su pletiniais .<proc>
        List<String> stringList = readAndProcessWords(processor);
//      ir atspausdinti konsoleje
        printWords(stringList);

//      b) sukurti faila (pasirinktinai) ir irasyti faila su pletiniais .<proc>
        writeProcessedWordsToFile(stringList, processor);

//      d) patkrinti ar duomenys failuose (pasirinktinai) su pletiniais <proc> suformuoti teisingai;
        System.out.println(readFileAndTest(processor)); // True or False

//      e) istrinti failus (pasirinktinai) su pletiniais <proc>
        deleteFile(processor);
    }
}