Install:
run, `cd text-processor/ && ./build`

Notes:
4. Funkcionalumas, kuriuo gales pasinaudoti kitas programuotojas savo projekte:
a) nuskaityti teksta is failo. AND
c) nuskaityti (pasirinktinai) failu su pletiniais .<proc>
[x] List<String> readFileToWords()                              | FileIO
[x] List<String> readAndProcessWords(<proc-class>)              | FileIOProessor

ir atspausdinti konsoleje
[x]              printWords(words)                              | FileIO

b) sukurti faila (pasirinktinai) su pletiniais .<proc>
[x]              writeWordsToFile(words)                        | FileIO
[x]              writeProcessedWordsToFile(words, <proc-class>) | FileIOProcessor

d) patkrinti ar duomenys failuose (pasirinktinai) su pletiniais <proc> suformuoti teisingai;
[x]              readFileAndTest(<proc-class>)                  | FileIOProcessor

e) istrinti failus (pasirinktinai) su pletiniais .<proc>
[x]              deleteFile(filePath)                           | FileIO
[x]              deleteFile(<proc-class>)                       | FileIOProessor

x -> Done