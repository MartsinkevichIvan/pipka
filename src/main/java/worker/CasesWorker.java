package worker;

import exeptions.WrongLinesCountException;
import help.utils.IntegersRandomaizer;
import help.utils.TxtReader;
import help.utils.TxtWriter;

import java.util.Optional;
import java.util.stream.Collectors;


public abstract class CasesWorker {
    static private int DEFAULT_LINES_COUNT = 10;

    public static String selectCases(String pathToFile, int linesCount) {
        var path = Optional.ofNullable(pathToFile).orElseThrow(() -> new NullPointerException("Path to source file is null"));

        var lists = TxtReader.getLines(path);
        var tableHeader = lists.get(0);
        lists.remove(tableHeader);

        if (lists.size() < linesCount)
            throw new WrongLinesCountException(lists.size(), linesCount);

        var resultLines = IntegersRandomaizer.getUniqueIntegers(lists.size(), linesCount);

        var resultLists =
                lists.stream()
                        .collect(Collectors.groupingBy(s -> !resultLines.contains(lists.indexOf(s))))
                        .values().parallelStream().peek(list -> list.add(0, tableHeader)).collect(Collectors.toList());

        TxtWriter.createFile(path, resultLists.get(1));
        return TxtWriter.createFile(path.replace(".txt", "_res.txt"), resultLists.get(0));
    }

    public static String selectCases(String pathToFile) {
        return selectCases(pathToFile, DEFAULT_LINES_COUNT);
    }

}

