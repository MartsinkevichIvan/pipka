package help.utils;

import exeptions.WrongSavePathException;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.logging.Logger;

public class TxtWriter {
    public static String createFile(String pathToFile, List<String> lines) {
        var rewriteFile = new File(pathToFile).exists() ? StandardOpenOption.TRUNCATE_EXISTING : StandardOpenOption.CREATE;
        try {
            Files.write(Paths.get(pathToFile),
                    lines,
                    StandardCharsets.UTF_8,
                    rewriteFile);
        } catch (IOException e) {
            Logger.getLogger(TxtWriter.class.getClass().getName()).warning(e.getMessage());
            throw new WrongSavePathException(pathToFile);
        }
        return pathToFile;
    }
}
