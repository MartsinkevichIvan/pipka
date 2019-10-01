package help.utils;

import exeptions.WrongGetPathException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public abstract class TxtReader {
    public static List<String> getLines(String pathToFile) {
        File file = new File(pathToFile);

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            Logger.getLogger(TxtWriter.class.getClass().getName()).warning(e.getMessage());
            throw new WrongGetPathException(pathToFile);
        }
        return br.lines().filter(line -> null != line && !line.isEmpty()).collect(Collectors.toList());
    }
}
