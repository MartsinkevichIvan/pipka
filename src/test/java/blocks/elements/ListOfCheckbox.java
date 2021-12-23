package blocks.elements;

import blocks.elements.checkers.CheckListOfCheckbox;
import driver.SingletonDriver;
import lombok.SneakyThrows;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;

public class ListOfCheckbox<T extends Supplier<String>> implements CheckListOfCheckbox<T> {
    private List<Checkbox> blocks = new ArrayList<>();
    private final By by;

    @SneakyThrows
    public ListOfCheckbox(By by){
        this.by = by;
    }

    @SneakyThrows
    public List<Checkbox> getList(){
        var elements = SingletonDriver.getDriver().findElements(by);
        blocks = elements.stream().map(i -> new Checkbox(i)).collect(toList());
        return blocks;
    }
}
