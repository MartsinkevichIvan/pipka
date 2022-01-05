package blocks.baseElements;

import blocks.baseElements.checkers.CheckListOfToggles;
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
    private final By by;

    @SneakyThrows
    public ListOfToggle(By by){
        this.by = by;
    }

    @SneakyThrows
    public List<Toggle> getList(){
        Wait.forMillis(1000); // Driver can't create list of all elements on time
        var elements = SingletonDriver.getDriver().findElements(by);
        return elements.stream().map(Toggle::new).collect(toList());
    }
}
