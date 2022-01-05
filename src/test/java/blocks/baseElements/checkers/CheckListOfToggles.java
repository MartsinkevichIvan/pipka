package blocks.baseElements.checkers;

import blocks.baseElements.Toggle;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;

public interface CheckListOfToggles<T extends Supplier<String>>{
    List<Toggle> getList();

    default CheckListOfToggles setToggleActive(T... values){
        var valuesTexts = Arrays.stream(values).map(i -> i.get()).collect(toList());
        getList().stream().filter(i -> valuesTexts.contains(i.getTitle().getText())).forEach(i -> i.set(true));
        return this;
    }
    default CheckListOfToggles setToggleInactive(T... values){
        var valuesTexts = Arrays.stream(values).map(i -> i.get()).collect(toList());
        getList().stream().filter(i -> valuesTexts.contains(i.getTitle().getText())).forEach(i -> i.set(false));
        return this;
    }

    default CheckListOfToggles checkListValues(T... values){
        var textValues = Arrays.stream(values).map(Supplier::get).collect(toList());
        var toggleTexts = getList().stream().map(Toggle::getTitle).collect(toList());
        Assert.assertEquals(textValues, toggleTexts);
        return this;
    }

    default CheckListOfToggles checkAll(){
        var toggleTexts = getList().stream().map(i -> i.set(true)).collect(toList());
        return this;
    }

    default CheckListOfToggles uncheckAll(){
        var toggleTexts = getList().stream().map(i -> i.set(false)).collect(toList());
        return this;
    }
}
