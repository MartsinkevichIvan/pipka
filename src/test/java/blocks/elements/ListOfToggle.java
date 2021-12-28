package blocks.elements;

import blocks.elements.checkers.CheckListOfToggles;
import driver.SingletonDriver;
import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import utils.Wait;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;

@Getter
public class ListOfToggle<T extends Supplier<String>> implements CheckListOfToggles<T> {
    private List<Toggle> blocks = new ArrayList<>();
    private final By by;

    @SneakyThrows
    public ListOfToggle(By by){
        this.by = by;
    }

    @SneakyThrows
    public List<Toggle> getList(){
        Wait.forMillis(1000); // Driver can't create list of all elements on time
        var elements = SingletonDriver.getDriver().findElements(by);
        blocks = elements.stream().map(i -> new Toggle(i)).collect(toList());
        return blocks;
    }
}
