package exeptions;

public class WrongGetPathException extends IllegalArgumentException {
    public WrongGetPathException(String pathToFile) {
        super(String.format("Can't get txt file by path : %s", pathToFile));
    }
}
