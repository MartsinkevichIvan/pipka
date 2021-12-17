package blocks.elements;

import blocks.elements.checkers.CheckListOfToogle;
import driver.SingletonDriver;
import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import spring.annotations.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;

@Getter
public class ListOfToogle<T extends Supplier<String>> implements CheckListOfToogle<T>{
    private List<Toogle> blocks = new ArrayList<>();
    private final By by;

    @SneakyThrows
    public ListOfToogle(By by){
        this.by = by;
    }

    @SneakyThrows
    public List<Toogle> getList(){
        if(blocks.isEmpty()){
            var elements = SingletonDriver.getDriver().findElements(by);
            blocks = elements.stream().map(i -> new Toogle(i)).collect(toList());
        }
        return blocks;
    }

}
