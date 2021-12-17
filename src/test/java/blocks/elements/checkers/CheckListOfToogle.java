package blocks.elements.checkers;

import blocks.elements.Toogle;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;

public interface CheckListOfToogle<T extends Supplier<String>>{
    List<Toogle> getList();

    default CheckListOfToogle checkListValues(T... values){
        var textValues = Arrays.stream(values).map(Supplier::get).collect(toList());
        var toogleTexts = getList().stream().map(Toogle::getTitle).collect(toList());
        Assert.assertEquals(textValues, toogleTexts);
        return this;
    }

    default CheckListOfToogle checkAll(){
        var toogleTexts = getList().stream().map(i -> i.set(true)).collect(toList());
        return this;
    }

    default CheckListOfToogle uncheckAll(){
        var toogleTexts = getList().stream().map(i -> i.set(false)).collect(toList());
        return this;
    }
}
