import exeptions.WrongGetPathException;
import exeptions.WrongLinesCountException;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import worker.CasesWorker;

public class ReaderTest {
    String pathToFile = "/Users/artsiom_rudzko/Documents/testTask/src/main/resources/table.txt";

    @Test(priority = 1)
    public void readTest() {
        CasesWorker.selectCases(pathToFile);
    }

    @Test(expectedExceptions = WrongGetPathException.class)
    public void wrongSourceFilePathTest() {
        CasesWorker.selectCases(pathToFile + RandomStringUtils.randomAlphanumeric(10));
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void checkNullPathToSourceFile() {
        CasesWorker.selectCases(null);
    }

    @Test(expectedExceptions = WrongLinesCountException.class)
    public void checkIncorrectLinesCount() {
        CasesWorker.selectCases(pathToFile, 35);
    }
}
