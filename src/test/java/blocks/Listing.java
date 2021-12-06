package blocks;

import org.openqa.selenium.WebElement;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

public class Listing {

    public static  <T extends Card> List<T> getListing(List<WebElement> element, Class<T> classs) {
        Constructor<T> constructor = null;
        try {
            constructor = classs.getConstructor(WebElement.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        Constructor<T> finalConstructor = constructor;
        return element.stream().map(i-> {
            try {
                return finalConstructor.newInstance(i);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());
    }
}
