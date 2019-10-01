package exeptions;

public class WrongSavePathException extends IllegalArgumentException {
    public WrongSavePathException(String pathToFile) {
        super(String.format("Can't save result txt file by path : %s", pathToFile));
    }
}
