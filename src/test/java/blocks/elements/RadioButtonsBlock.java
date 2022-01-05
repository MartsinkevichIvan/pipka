package blocks.elements;

import driver.SingletonDriver;
import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import java.util.List;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;

@Getter
public class RadioButtonsBlock<T extends Supplier<String>>{
    private List<RadioButton> buttons;

    @SneakyThrows
    public RadioButtonsBlock(By by) {
        buttons = SingletonDriver.getDriver().findElements(by).stream().map(RadioButton::new).collect(toList());
    }

    @SneakyThrows
    public RadioButton getButton(T value){;
        return buttons.stream().filter(i->value.get().equals(i.getTitle().getText())).findFirst().get();
    }
}
