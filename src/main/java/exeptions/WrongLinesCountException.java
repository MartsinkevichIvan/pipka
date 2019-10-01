package exeptions;

public class WrongLinesCountException extends IllegalArgumentException {
    public WrongLinesCountException(int actualLinesCount, int expectedLinesCount) {
        super(String.format("Wrong putted lines count actual lines count is %1$s, but expected %2$s", actualLinesCount, expectedLinesCount));
    }
}
